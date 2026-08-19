import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Bán hàng đã nhập kho')
WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bán hàng đã nhập kho']))

WebUI.delay(2)

// mac dinh
String value = WebUI.getAttribute(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), 'value')
assert value.trim() == '0'

// ky tu
WebUI.setText(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), '#!dfgsfd')

String value1 = WebUI.getAttribute(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), 'value')
assert value1.trim() == ''

// <16 
WebUI.setText(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), '324,123,423,123412')

String value2 = WebUI.getAttribute(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), 'value')
assert value2.size()<16


// copy paste
WebUI.setText(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), '11')

WebUI.sendKeys(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), '')

WebUI.sendKeys(findTestObject('Common/input_tdTextDynamicLocators',[('text'):'KM trực tiếp', ('index'):'2']), Keys.chord(Keys.CONTROL, 'V'))

