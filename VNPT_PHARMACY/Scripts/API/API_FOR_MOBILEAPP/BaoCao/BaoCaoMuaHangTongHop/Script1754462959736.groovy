import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

//get value of kho_id in request
RequestObject req = findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoMuaHangTongHop')

String rawBody = req.getBodyContent().getText()

def json = new JsonSlurper().parseText(rawBody)

String expectedNccId = json.ncc_id.toString()

// ▶ Now fire your  expired request
ResponseObject response = WS.sendRequest(
	findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoMuaHangTongHop', [('access_token') : GlobalVariable.access_token])
)

// ▶ Verify
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'Thanh cong')

String body = response.getResponseBodyContent()

println "RESPONSE: " + body

String actualNccId = WS.getElementPropertyValue(response, 'map.rs[0].SUPPLIER_ID').toString()

WS.verifyEqual(actualNccId, expectedNccId)
