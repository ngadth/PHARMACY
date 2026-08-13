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

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Nhà cung cấp')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String code = "CODE" + CustomKeywords.'libKeyWords.PageObject.randomString'('123456ABCDRFGLJH', 3)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtCode1']), code)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtName1']), 'automation nha cung cap')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'org_code']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'org_code']), code)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'org_code']), Keys.chord(Keys.ENTER))

String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã NCC', 0, 'searchUnitTable')

WebUI.verifyEqual(value, code)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi ']))

String code2 = "CODE" + CustomKeywords.'libKeyWords.PageObject.randomString'('123456ABCDRFGLJH', 3)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtCode1_e']), Keys.chord(
        Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtCode1_e']), code2)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'org_code']), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'org_code']), code2)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'org_code']), Keys.chord(Keys.ENTER))

String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã NCC', 0, 'searchUnitTable')

WebUI.verifyEqual(value2, code2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa ']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không tìm thấy dữ liệu']), 0)

