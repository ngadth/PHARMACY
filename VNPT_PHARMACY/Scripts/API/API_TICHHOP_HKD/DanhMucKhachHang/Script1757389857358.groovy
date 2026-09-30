import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_TICHHOP_HKD/DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

// Declare and get value of parameter pageSize
def req = findTestObject('API/API_TICHHOP_HKD/DanhMucKhachHang')

def reqJson = new JsonSlurper().parseText(req.getBodyContent().getText())

int expected_pageSize = (reqJson.pageSize ?: 0) as int

//send request of api get product cart
def resp = WS.sendRequest(findTestObject('API/API_TICHHOP_HKD/DanhMucKhachHang', [('access_token') : GlobalVariable.access_token]))

// Verify status code and message return
WS.verifyResponseStatusCode(resp, 200)

WS.verifyElementPropertyValue(resp, 'message', 'Thành công')

//Parse response JSON and count items
def json = new JsonSlurper().parseText(resp.getResponseBodyContent())
println(json)
def items = (json?.map?.rs instanceof List) ? json.map.rs : []
int actual_size = items.size()

//Compare value return and value in pageSize
if (actual_size == expected_pageSize) {
	KeywordUtil.logInfo("✅ Response size (${actual_size}) matches pageSize (${expected_pageSize})")
} else {
	KeywordUtil.markFailed("❌ Response size mismatch: expected ${expected_pageSize}, but got ${actual_size}")
}

// === 3. Verify MA and TEN fields are not empty===
boolean allValid = items.every { it.MA && it.TEN }   // check both not null/empty

if (allValid) {
	KeywordUtil.logInfo("✅ All ${items.size()} records have valid MA and TEN values")
} else {
	def wrongItems = items.findAll { !it.MA || !it.TEN }
	KeywordUtil.markFailed("❌ Found records with missing MA/TEN: " +
		wrongItems.collect { "ROW_STT=${it.ROW_STTT}, MA=${it.MA}, TEN=${it.TEN}" })
}