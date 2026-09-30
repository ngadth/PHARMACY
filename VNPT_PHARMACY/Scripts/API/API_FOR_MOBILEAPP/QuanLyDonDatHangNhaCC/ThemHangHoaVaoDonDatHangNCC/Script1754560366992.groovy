import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

String status = 'TRUE'

WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNhaCC/ThemMoiDonDatHangNCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Gửi request
response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNCC/ThemHangHoaVaoDonDatHangNCC'))

// Kiểm tra kết quả
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// In ra nội dung phản hồi (body)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body
def response = new JsonSlurper().parseText(response.getResponseBodyContent())

// Lấy chuỗi return_value, ví dụ: "TRUE"
def returnValue = response.map.return_value

println(returnValue)

WebUI.verifyMatch(returnValue, status, true)

// Kiểm tra nội dung message
assert response.message == 'Thanh cong'