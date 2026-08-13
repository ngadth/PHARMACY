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
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Kiểm kê hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Kiểm kê hàng hóa']), 3)

//mac dinh
String value =  WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), 'value')

assert value.trim() == ''

// copy paste

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), 'cảm xuyên hương')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), '')
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), Keys.chord(Keys.CONTROL, 'V'))

String value1 =  WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), 'value')
assert value1.trim() == 'cảm xuyên hương'

// >20
WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), 'cảm xuyên hương cảm xuyên hương cảm xuyên hương')
String value2 =  WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), 'value')
assert value2.size() > 20 
