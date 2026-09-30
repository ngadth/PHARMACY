import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper

WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/BanHangDaNhapKho/TraCuuGiaoDichBanHang_STT35'), [:], FailureHandling.STOP_ON_FAILURE)

response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/TraCuuGiaoDich/LayDSHangTrongPhieuBanHang'))

// Kiểm tra status code
WS.verifyResponseStatusCode(response, 200)

// In ra nội dung phản hồi (body)
println('Response Body:\n' + response.getResponseText())

// Parse JSON từ body
def response = new JsonSlurper().parseText(response.getResponseBodyContent())

// Kiểm tra nội dung message
assert response.message == 'Thành công'

