import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 1) Declare and get value of parameters Tu_ngay, Den_ngay in body API Import documents report
def req = findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BangKePhieuNhap')

def reqJson = new JsonSlurper().parseText(req.getBodyContent().getText())

String sTu = reqJson.tu_ngay // e.g. "01/07/2024"

String sDen = reqJson.den_ngay // e.g. "03/07/2025"

// 2) Convert values date to LocalDate
DateTimeFormatter fmt = DateTimeFormatter.ofPattern('dd/MM/yyyy')

LocalDate start = LocalDate.parse(sTu, fmt)

LocalDate end = LocalDate.parse(sDen, fmt)

KeywordUtil.logInfo("Expect NGAYTHUCHIEN between $start and $end")

// ▶ Now fire your Import documents report request
ResponseObject response = WS.sendRequest(findTestObject('API/API_FOR_MOBILEAPP/BaoCao/BangKePhieuNhap', [('access_token') : GlobalVariable.access_token]))

// ▶ Verify status code & message
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'Thanh cong')

String body = response.getResponseBodyContent()

println('RESPONSE: ' + body)

def dateImport = new JsonSlurper().parseText(body).map.rs

// ▶ Verify that value of the variable NGAY NHAP is within the time period declared in the variables tu_ngay and den_ngay
def actualDates_Import = dateImport.findAll({ def entry ->
        LocalDate ngay = LocalDate.parse(entry.NGAYTHUCHIEN, fmt)

        ngay.isBefore(start) || ngay.isAfter(end)
    }).collect({ 
        it.NGAYTHUCHIEN
    })

// 6) Pass or fail with clear logging
if (actualDates_Import) {
    KeywordUtil.markFailedAndStop("⛔ Found NGAYTHUCHIEN outside [$sTu–$sDen]: $actualDates_Import")
} else {
    KeywordUtil.logInfo("✅ All NGAYTHUCHIEN values are within [$sTu–$sDen]")
}

