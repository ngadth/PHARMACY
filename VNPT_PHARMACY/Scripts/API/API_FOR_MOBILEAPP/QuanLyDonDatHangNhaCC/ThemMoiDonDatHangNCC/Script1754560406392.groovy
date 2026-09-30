import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String status = 'TRUE'

WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNCC/ThemMoiDonDatHangNCC', [('access_token') : GlobalVariable.access_token]))

// Kiểm tra status code
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// In ra nội dung phản hồi (body)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body
def response = new JsonSlurper().parseText(response.getResponseBodyContent())

// Lấy chuỗi return_value, ví dụ: "TRUE77"
def returnValue = response.map.return_value

// Tách phần chữ (TRUE)
def textTRUE = returnValue.find('[A-Za-z]+')

ID = returnValue.find('\\d+$')

println('Phần chữ là: ' + textTRUE)

println('Phần số là: ' + ID)

GlobalVariable.order_id = ID

WebUI.verifyMatch(textTRUE, status, true)

// Kiểm tra nội dung message
assert response.message == 'Thanh cong'

