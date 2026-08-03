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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent

// Gọi test case báng Hàng đã nhập kho Tìm mặt hàng 
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/BanHangDaNhapKho/BanHangDaNhapKho_TimMatHang_STT06'), [:], FailureHandling.STOP_ON_FAILURE)

def response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/BanHangDaNhapKho/BanHangDaNhapKho_ThanhToan_STT09'))

// Kiểm tra status code
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// In response raw (nếu cần)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body response
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Kiểm tra message phản hồi
assert jsonResponse.message == 'Thanh cong'

// Lấy PO_ID từ map
String phieuid = jsonResponse.map.PO_PHIEUBAN_ID.toString()

println("📦 PO_PHIEUBAN_ID: " + phieuid)

// Gán vào biến toàn cục
GlobalVariable.po_phieu_id = phieuid

