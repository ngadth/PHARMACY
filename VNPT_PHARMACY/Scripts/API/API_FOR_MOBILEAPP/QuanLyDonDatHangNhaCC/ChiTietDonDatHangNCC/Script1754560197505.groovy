import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNhaCC/ThemMoiDonDatHangNCC'), [:], FailureHandling.STOP_ON_FAILURE)

response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNCC/ChiTietDonDatHangNCC'))

// Kiểm tra status code
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// In ra nội dung phản hồi (body)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Kiểm tra nội dung message
assert jsonResponse.message == 'Thanh cong' : "Message không đúng, nhận được: ${jsonResponse.message}"