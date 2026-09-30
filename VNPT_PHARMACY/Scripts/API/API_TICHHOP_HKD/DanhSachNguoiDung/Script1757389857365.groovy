import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_TICHHOP_HKD/DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

//send request of api get user list
def resp = WS.sendRequest(findTestObject('API/API_TICHHOP_HKD/DanhSachNguoiDung', [('access_token') : GlobalVariable.access_token]))

// Verify status code and message return
WS.verifyResponseStatusCode(resp, 200)

WS.verifyElementPropertyValue(resp, 'message', 'Thành công')

//Parse response JSON and count items
def json = new JsonSlurper().parseText(resp.getResponseBodyContent())

println(json)

def items = json?.map?.rs instanceof List ? json.map.rs : []

int actual_size = items.size()

// === 3. Verify MA and TEN fields are not empty===
boolean allValid = items.every({ 
        it.MA // check MA not null/empty
    })

if (allValid) {
    KeywordUtil.logInfo("✅ All $items.size() records have valid MA values")
} else {
    def wrongItems = items.findAll({ 
            !(it.MA)
        })

    KeywordUtil.markFailed('❌ Found records with missing MA: ' + wrongItems.collect({ 
                "MA=$it.MA"
            }))
}