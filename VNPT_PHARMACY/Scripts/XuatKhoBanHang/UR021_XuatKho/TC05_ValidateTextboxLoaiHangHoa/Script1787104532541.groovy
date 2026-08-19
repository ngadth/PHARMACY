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
import com.kms.katalon.core.testobject.TestObject
import com.katalon.webui.keyword.action.image.WebUIAbstractImageActionKeyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Xuất kho']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Xuất kho')
WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Quản lý xuất kho']), 5)
//mac dinh
String value = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']),'value')
assert value.trim() == ''

// copy paste
WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']), 'cảm xuyên hương')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']), '')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']), Keys.chord(Keys.CONTROL, 'V'))

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']), Keys.ENTER.toString())

String value1 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Loại hàng hóa', ('index'):'1']),'value')
assert value1.trim() == 'cảm xuyên hương'


