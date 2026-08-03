import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_TICHHOP_HKD/DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

// Declare and get value of parameter pageSize
def req = findTestObject('API/API_TICHHOP_HKD/DanhMucHangHoa')

String bodyRaw = req.getBodyContent()?.getText() ?: ''

Map bodyJson   = bodyRaw ? (Map) new JsonSlurper().parseText(bodyRaw) : [:]

int expected_pageSize = (bodyJson.pageSize ?: 0) as int

//send request of api get product cart
def resp = WS.sendRequest(findTestObject('API/API_TICHHOP_HKD/DanhMucHangHoa', [('access_token') : GlobalVariable.access_token]))

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

// === 3. Verify NAME, CODE and ID fields are not empty===
boolean allValid = items.every { it.ID && it.NAME && it.CODE }   // check all not null/empty

if (allValid) {
	KeywordUtil.logInfo("✅ All ${items.size()} records have valid ID, NAME and CODE values")
} else {
	def wrongItems = items.findAll { !it.ID || !it.NAME || !it.CODE }
	KeywordUtil.markFailed("❌ Found records with missing ID/NAME/CODE: " +
		wrongItems.collect { "ROW_STT=${it.ROW_STTT}, ID=${it.ID}, NAME=${it.NAME}, CODE=${it.CODE}" })
}