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

// 1) Declare and get value of parameters Tu_ngay, Den_ngay in body API sales detail report
def req = findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoBanHangChiTiet')
def reqJson = new JsonSlurper().parseText(req.getBodyContent().getText())
String expectedDate_Report = "${reqJson.tu_ngay}-${reqJson.den_ngay}"

KeywordUtil.logInfo("Expect NGAY_BC to be: ${expectedDate_Report}")

// ▶ Now fire your sales detail report request
ResponseObject response = WS.sendRequest(
	findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoBanHangChiTiet', [('access_token') : GlobalVariable.access_token])
)

// ▶ Verify status code & message
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'Thanh cong')

String body = response.getResponseBodyContent()

println "RESPONSE: " + body

// ▶  collect all NGAY_BC values
def ngayList = new groovy.json.JsonSlurper().parseText(body).map.rs*.NGAY_BC

def actualDate_Report = ngayList.findAll { it != expectedDate_Report }

if (actualDate_Report) {
    KeywordUtil.markFailedAndStop("⛔ NGAY_BC mismatches: ${actualDate_Report}")
} else {
    KeywordUtil.logInfo("✅ All NGAY_BC match '${expectedDate_Report}'")
}