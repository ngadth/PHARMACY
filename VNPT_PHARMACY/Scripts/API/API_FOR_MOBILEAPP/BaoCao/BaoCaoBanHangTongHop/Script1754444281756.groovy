import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)


// ▶ Now fire your sales summary report request
ResponseObject response = WS.sendRequest(
	findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoBanHangTongHop', [('access_token') : GlobalVariable.access_token])
)

// ▶ Verify status code & message
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'Thanh cong')

String body = response.getResponseBodyContent()

println "RESPONSE: " + body

// Verify that parameter NHOM contain value Duoc Pham in response
def nhoms = new groovy.json.JsonSlurper().parseText(body).map.rs*.NHOM

def actual_valueNhoms = nhoms.findAll { it != 'Duoc pham' }

if (actual_valueNhoms) {
	KeywordUtil.markFailedAndStop("⛔ Found bad NHOMs: ${actual_valueNhoms}")
} else {
	KeywordUtil.logInfo("✅ All NHOM entries are ‘Duoc pham’")
}