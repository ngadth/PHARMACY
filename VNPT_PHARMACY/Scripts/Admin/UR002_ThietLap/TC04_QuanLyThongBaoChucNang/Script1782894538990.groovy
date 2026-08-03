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

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('THIẾT LẬP', 'Quản lý thông báo chức năng')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String tieude = 'Hoan thanh ke hoach quy ' + CustomKeywords.'libKeyWords.PageObject.randomString'('123456ABCDRFGLJH', 3)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb_add']), tieude)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'songayht_add']), '20')

WebUI.click(findTestObject('Admin/Common/button_divDynamicLocators', [('idValue') : 'modalAdd_thongbao', ('buttonName') : 'Lưu']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb']), tieude)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb']), Keys.chord(Keys.ENTER))

String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tiêu đề thông báo', 0, 'product')

WebUI.verifyEqual(value, tieude)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu']))

String tieude2 = 'Hoan thanh ke hoach quy update' + CustomKeywords.'libKeyWords.PageObject.randomString'('123456ABCDRFGLJH', 3)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb_e']), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb_e']), tieude2)

WebUI.click(findTestObject('Admin/Common/button_divDynamicLocators', [('idValue') : 'modalEdit_thongbao', ('buttonName') : 'Lưu']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb']), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb']), tieude2)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tieudetb']), Keys.chord(Keys.ENTER))

String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tiêu đề thông báo', 0, 'product')

WebUI.verifyEqual(value2, tieude2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu']), 0)

