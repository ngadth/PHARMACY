import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

String status = 'TRUE'

WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNhaCC/ThemHangHoaVaoDonDatHangNCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Gửi request
response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNCC/XoaHangHoaTrongDonDatHangNCC'))

// Kiểm tra kết quả
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// In ra nội dung phản hồi (body)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Kiểm tra nội dung message
assert jsonResponse.message == 'Thanh cong'