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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonSlurper

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_FOR_MOBILEAPP/Login'), [:], FailureHandling.STOP_ON_FAILURE)

//get value of kho_id in request
RequestObject req = (RequestObject)findTestObject('API/API_FOR_MOBILEAPP/Dashboard/DanhSachHangSapHetHan')

String rawBody = req.getBodyContent().getText()

// parse it as JSON
def json = new JsonSlurper().parseText(rawBody)

// read kho_id
String bodyKhoId = json.kho_id.toString()

// ▶ Now fire your ListProduct expired request
ResponseObject response = WS.sendRequest(
	findTestObject('API/API_FOR_MOBILEAPP/Dashboard/DanhSachHangSapHetHan', [('access_token') : GlobalVariable.access_token])
)

// ▶ Verify
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'message', 'ok')

String body = response.getResponseBodyContent()

println "RESPONSE: " + body

def actualKhoId = WS.getElementPropertyValue(response, 'map.rs[0].IN_WAREHOUSE_ID').toString()

println(actualKhoId)

WS.verifyEqual(actualKhoId, bodyKhoId)

