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

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Quản lý chương trình tích điểm')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String code = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 3)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'tenctkm_add']), code)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'searchDate_add']), date)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'searchDate_add']), Keys.chord(Keys.ENTER))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'tienquydoi_add']), '1000000')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'diemquydoi_add']), '1000')

WebUI.click(findTestObject('DanhMuc/iconThemMucTieuDiem'))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'tenmuc_add_id1']), 'aaa')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'diem_add_id1']), '20')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'tienck_add_id1']), '20000')

WebUI.click(findTestObject('DanhMuc/btnThemMoi'))

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ten_ctkm_id']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ten_ctkm_id']), code)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ten_ctkm_id']), Keys.chord(Keys.ENTER))

String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên CTKM', 0, 'product_vsqt')

WebUI.verifyEqual(value, code)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu']))

String code2 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 3)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'tenctkm_edit']), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'tenctkm_edit']), code2)

WebUI.click(findTestObject('DanhMuc/btnCapNhat'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ten_ctkm_id']), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ten_ctkm_id']), code2)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ten_ctkm_id']), Keys.chord(Keys.ENTER))

String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên CTKM', 0, 'product_vsqt')

WebUI.verifyEqual(value2, code2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 0)

