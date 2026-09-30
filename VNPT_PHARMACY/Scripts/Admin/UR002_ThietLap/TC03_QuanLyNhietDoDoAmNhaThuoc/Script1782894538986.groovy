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

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('THIẾT LẬP', 'Quản lý nhiệt độ, độ ẩm của nhà thuốc')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String nhietdo = '28'

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'nhietdo_add']), nhietdo)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'doam_add']), '30')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Khoảng thời gian tạo',('index'):'1']))

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Khoảng thời gian tạo',('index'):'1']), date)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Khoảng thời gian tạo',('index'):'1']), Keys.chord(
        Keys.ENTER))

value = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '4']))

//String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Nhiệt độ (°C)', 0, 'temhum_tbl')
WebUI.verifyEqual(value, nhietdo)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu']))

String nhietdo2 = '32'

WebUI.click(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'nhietdo_edit']))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'nhietdo_edit']), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'nhietdo_edit']), nhietdo2)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

value2 = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '4']))

//String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Nhiệt độ (°C)', 0, 'temhum_tbl')
WebUI.verifyEqual(value2, nhietdo2)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'checkboxExample2']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xóa các dòng đã chọn']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu']), 0)

