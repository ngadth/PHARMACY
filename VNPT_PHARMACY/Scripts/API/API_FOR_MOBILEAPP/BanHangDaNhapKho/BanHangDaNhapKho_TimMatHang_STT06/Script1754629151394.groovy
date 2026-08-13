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

// Gọi test case đăng nhập nếu cần
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Gửi request API
def rawResponse = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/BanHangDaNhapKho/BanHangDaNhapKho_TimMatHang_STT06'))

// Kiểm tra status code
WS.verifyResponseStatusCode(rawResponse, GlobalVariable.successCode)

// In response raw (nếu cần)
println('Response Body:\n' + rawResponse.getResponseText())

// Parse JSON từ body response
def jsonResponse = new JsonSlurper().parseText(rawResponse.getResponseBodyContent())

// Kiểm tra message phản hồi
assert jsonResponse.message == 'Thành công' : "Message không đúng, nhận được: ${jsonResponse.message}"

// Lấy danh sách sản phẩm
def items = jsonResponse.map.rs

// Tìm item có SOLUONG lớn nhất
def maxItem = items.max { it.SOLUONG }

// Lấy PRODUCT_CAT_ID và DS_PHIEUNHAP
def maxProductCatId = maxItem.PRODUCT_CAT_ID.toString()

def dsPhieuNhap = maxItem.DS_PHIEUNHAP

// Tách ngày dd/mm/yyyy đầu tiên
def firstDate = dsPhieuNhap.split("\\|")
                          .find { it ==~ /\d{2}\/\d{2}\/\d{4}.*/ }  // tìm phần bắt đầu bằng ngày
                          ?.split(";")[0] // lấy phần trước dấu ';'

// In ra thông tin để debug/log
println("✅ PRODUCT_CAT_ID có SOLUONG lớn nhất: " + maxProductCatId)

println("✅ SOLUONG tương ứng: " + maxItem.SOLUONG)

println("✅ DS_PHIEUNHAP tương ứng: " + dsPhieuNhap)

println("✅ Ngày đầu tiên: " + firstDate)

// Gán vào biến toàn cục
GlobalVariable.product_cat_id = maxProductCatId

GlobalVariable.ds_phieunhap = firstDate

println(maxProductCatId)

println(firstDate)