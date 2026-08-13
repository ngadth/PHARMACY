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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

//WebUI.delay(5)
WebUI.click(findTestObject('Common/button_advanced'))

WebUI.click(findTestObject('Common/link_unsafe'))

// danh sách các case test
def testCases = [
[
username:'',
password:'',
error: findTestObject('Common/text_loi_username')
],

[
username:'             ',
password:'',
error: findTestObject('Common/text_loi_username')
],

[
username:'',
password:'              ',
error: findTestObject('Common/text_loi_password')
],
	
[
username:'',
password:GlobalVariable.passAdmin,
error: findTestObject('Common/text_loi_username')
],

[
username:GlobalVariable.userAdmin,
password:'',
error: findTestObject('Common/text_loi_password')
],

[
username:'saiuser',
password:GlobalVariable.passAdmin,
error: findTestObject('Common/text_tai_khoan_mat_khau_sai')
],

[
	username:GlobalVariable.userAdmin,
	password:'saipassword',
	error: findTestObject('Common/text_tai_khoan_mat_khau_sai')
]

]

for(def tc: testCases) {
	WebUI.comment("Running case: " + tc.username + " | " + tc.password)
	
	WebUI.setText(findTestObject('Common/input_username'), tc.username)
	
	WebUI.setText(findTestObject('Common/input_password'), tc.password)
	
	WebUI.click(findTestObject('Common/btn_DangNhap'))
	
	WebUI.delay(3)
	
	// verify lỗi
	WebUI.verifyElementVisible(tc.error)
	
	WebUI.delay(2)

	// reset form
	WebUI.refresh()
}

WebUI.closeBrowser()
