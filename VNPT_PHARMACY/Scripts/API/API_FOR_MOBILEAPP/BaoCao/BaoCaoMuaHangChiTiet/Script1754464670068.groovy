import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 1) Declare and get value of parameters Tu_ngay, Den_ngay in body API purchase detail report
def req = findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoMuaHangChiTiet')
def reqJson = new JsonSlurper().parseText(req.getBodyContent().getText())

String sTu    = reqJson.tu_ngay        // e.g. "01/07/2024"
String sDen   = reqJson.den_ngay       // e.g. "03/07/2025"

// 2) Convert values date to LocalDate
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy")
LocalDate start = LocalDate.parse(sTu,  fmt)
LocalDate end   = LocalDate.parse(sDen, fmt)
KeywordUtil.logInfo("Expect NGAY_NHAP between ${start} and ${end}")

// ▶ Now fire your purchase detail report request
ResponseObject response = WS.sendRequest(
	findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BaoCaoMuaHangChiTiet', [('access_token') : GlobalVariable.access_token])
)

// ▶ Verify status code & message
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'Thanh cong')

String body = response.getResponseBodyContent()

println "RESPONSE: " + body

def datePurchase = new groovy.json.JsonSlurper().parseText(body).map.rs

// ▶ Verify that value of the variable NGAY NHAP is within the time period declared in the variables tu_ngay and den_ngay
def actualDates_Purchase = datePurchase.findAll { entry ->
	LocalDate ngay = LocalDate.parse(entry.NGAY_NHAP, fmt)
	(ngay.isBefore(start) || ngay.isAfter(end))
}.collect { it.NGAY_NHAP }

// 6) Pass or fail with clear logging
if (actualDates_Purchase) {
	KeywordUtil.markFailedAndStop(
	  "⛔ Found NGAY_NHAP outside [${sTu}–${sDen}]: ${actualDates_Purchase}"
	)
} else {
	KeywordUtil.logInfo(
	  "✅ All NGAY_NHAP values are within [${sTu}–${sDen}]"
	)
}