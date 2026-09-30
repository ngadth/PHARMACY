import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// ▶ Now fire your list store order request
ResponseObject response = WS.sendRequest(
	findTestObject('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNCC/DanhSachCuaHangDatHang', [('access_token') : GlobalVariable.access_token])
)

// ▶ Verify status code & message
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'Thanh cong')

String body = response.getResponseBodyContent()

println "RESPONSE: " + body

//▶ Verify that NAME and ID in response not null
def json = new JsonSlurper().parseText(body)
def items = json.map.rs

def bad = items.findAll { entry ->
    entry.NAME  == null || entry.NAME.toString().trim().isEmpty() ||
    entry.ID    == null || entry.ID.toString().trim().isEmpty()
}

if (bad) {
    // show which records are incomplete
    bad.eachWithIndex { entry, idx ->
        KeywordUtil.logInfo("Record #${idx} missing fields → NAME:${entry.NAME}, ID:${entry.ID}")
    }
    KeywordUtil.markFailedAndStop("⛔ ${bad.size()} record(s) have null/empty NAME or ID")
} else {
    KeywordUtil.logInfo("✅ All ${items.size()} record(s) have non-null NAME and ID")
}