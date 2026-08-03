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

String value = '1'

// Gọi test case báng Hàng đã nhập kho Tìm mặt hàng 
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/BanHangDaNhapKho/TraCuuGiaoDichBanHang_STT35'), [:], FailureHandling.STOP_ON_FAILURE)

println(GlobalVariable.phieuban_id)

def response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/TraCuuGiaoDich/XoaPhieuBanHang'))

// In response raw (nếu cần)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body response
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// ✅ Lấy return_value từ map
String returnValue = jsonResponse.map.return_value?.toString()
println('📦 return_value: ' + returnValue)

// ✅ Kiểm tra code và message = null
assert jsonResponse.code == null : "❌ code không null! Giá trị nhận được: ${jsonResponse.code}"
assert jsonResponse.message == null : "❌ message không null! Giá trị nhận được: ${jsonResponse.message}"

println("✅ code và message đều null")

WebUI.verifyMatch(returnValue, value, true)
