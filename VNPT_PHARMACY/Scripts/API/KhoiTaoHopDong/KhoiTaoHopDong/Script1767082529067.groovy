import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

WebUI.callTestCase(findTestCase('API/KhoiTaoHopDong/Login'), [:], FailureHandling.STOP_ON_FAILURE)

def uuid = UUID.randomUUID().toString()

response = WS.sendRequest(findTestObject('API/API_CungCapCho_OneBSS/KhoiTaoHopDong/New Postman Request',[('randomUUID') : uuid]))
print(response)
// Kiểm tra status code
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// Verify field code trong body
WS.verifyElementPropertyValue(response, 'code', '200')

// Lấy message
def message = WS.getElementPropertyValue(response, 'message')

// Verify message theo REGEX
assert message.matches('Thanh cong\\. Ma HD la CLOUD_\\d+')

// Tách mã hợp đồng để dùng tiếp nếu cần
def contractCode = message.split('la ')[1]
assert contractCode ==~ /CLOUD_\d+/

println "Contract Code = ${contractCode}"

//  Log PASS
KeywordUtil.markPassed("API thành công – Contract Code: ${contractCode}")
