import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNhaCC/ThemHangHoaVaoDonDatHangNCC'), [:], FailureHandling.STOP_ON_FAILURE)

// Gửi request
response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/QuanLyDonDatHangNCC/LayDanhSachHangTrongDonDatHangNCC'))

// Kiểm tra kết quả
WS.verifyResponseStatusCode(response, GlobalVariable.successCode)

// In ra nội dung phản hồi (body)
println('Response Body:\n' + response.getResponseText())


// Parse JSON từ response
def parsedJson = new JsonSlurper().parseText(response.getResponseBodyContent())

// Kiểm tra dữ liệu tồn tại
if (parsedJson?.map?.rs && parsedJson.map.rs.size() > 0) {
	// Lấy CODE đầu tiên
	String fullCode = parsedJson.map.rs[0].CODE
	println("✅ CODE đầy đủ: " + fullCode)

	// Tách 3 số cuối cùng
	String last3Digits = fullCode.find(/\d{3}$/)  // Regex: 3 chữ số cuối
	println("🔎 3 số cuối: " + last3Digits)

	// So sánh với GlobalVariable.order_id
	WebUI.verifyMatch(last3Digits, GlobalVariable.order_id, true)
	println("✅ Giá trị khớp với GlobalVariable.order_id: " + GlobalVariable.order_id)

} else {
	KeywordUtil.markFailed("❌ Không tìm thấy dữ liệu CODE.")
}

// Kiểm tra nội dung message
assert parsedJson.message == 'Thanh cong' : "Message không đúng, nhận được: ${response.message}"