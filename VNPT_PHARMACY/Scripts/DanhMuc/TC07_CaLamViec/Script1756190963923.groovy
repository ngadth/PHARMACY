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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Ca làm việc')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String code = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 3)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'wsname']), code)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'wsstart']), '07:57')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'wsend']), '12:07')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'wsname']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'wsname']), code)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'wsname']), Keys.chord(Keys.ENTER))

String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên ca', 0, 'wstbl')

WebUI.verifyEqual(value, code)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

String code2 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 3)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'wsname']), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'wsname']), code2)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'wsname']), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'wsname']), code2)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'wsname']), Keys.chord(Keys.ENTER))

String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên ca', 0, 'wstbl')

WebUI.verifyEqual(value2, code2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 0)

