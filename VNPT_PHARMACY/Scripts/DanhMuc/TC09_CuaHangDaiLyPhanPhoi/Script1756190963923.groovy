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

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Cửa hàng/Đại lý PP')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String code = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 4)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MA_CH_i']), code)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN_i']), 'Cua Hang Automation')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'SO_GT_i']), 'AUT' + code)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Thông tin liên thông']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'province']), 'Thành phố Cần Thơ', 
    false)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'district']), 'Huyện Cờ Đỏ', 
    false)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'commune']), 'Thị trấn Cờ Đỏ', 
    false)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI_CT_i']), '03 pham van bach')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

//WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Thêm mới cửa hàng thuốc']))

WebUI.delay(2)

WebUI.click(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Mã đơn vị/CH/đại lý']))

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Mã đơn vị/CH/đại lý']), code)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Mã đơn vị/CH/đại lý']), Keys.chord(Keys.ENTER))

String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã đơn vị', 0, 'table_phieu')

WebUI.verifyEqual(value, code)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

String name = 'auto' + CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 4)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN_e']), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN_e']), name)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

//WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Sửa thông tin cửa hàng thuốc']))

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Tên đơn vị/CH/đại lý']), Keys.chord(
        Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Tên đơn vị/CH/đại lý']), name)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Tên đơn vị/CH/đại lý']), Keys.chord(
        Keys.ENTER))

String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên đơn vị', 0, 'table_phieu')

WebUI.verifyEqual(value2, name)

//Dự án Dev báo bỏ chức năng xóa cửa hàng

//WebUI.delay(3)
//
//WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))
//
//WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))
//
//WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))
//
//WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không tìm thấy dữ liệu']), 0)

