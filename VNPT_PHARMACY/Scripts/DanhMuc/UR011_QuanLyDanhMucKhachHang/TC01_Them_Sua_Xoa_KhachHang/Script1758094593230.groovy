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

String diaChi = 'Đà Nẵng'

String diaChiUD = 'Quảng Nam'

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Khách hàng')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String ten = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Autotest_' + ten)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN']), GlobalVariable.name_service)

String ngaySinh = '01/10/2000'

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), ngaySinh)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mst = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mst)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), diaChi)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới khách hàng thành công']), 5)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), GlobalVariable.name_service)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ms_thue']), mst)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ms_thue']), Keys.chord(Keys.ENTER))

String tenKHCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên KH', 0, 'table_phieu')

String maKH = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã KH', 0, 'table_phieu')

String diaChiCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Địa chỉ', 0, 'table_phieu')

WebUI.verifyEqual(tenKHCell, GlobalVariable.name_service)

WebUI.verifyEqual(diaChiCell, diaChi)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(2)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Cập nhật khách hàng']), 5)

String tenUD = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('UDAutotest_' + tenUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN_E']), GlobalVariable.name_service)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh_e']), '01/10/2002')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh_e']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title_e']), 'AutoTest')

String mstUD = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE_E']), mstUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI_E']), diaChiUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'debt_limit_e']), '5000000')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật công nợ thành công']), 5)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), GlobalVariable.name_service)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ms_thue']), mstUD)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ms_thue']), Keys.chord(Keys.ENTER))

String tenKHUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên KH', 0, 'table_phieu')

String maKHUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã KH', 0, 'table_phieu')

String diaChiCelUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Địa chỉ', 0, 'table_phieu')

WebUI.verifyEqual(tenKHUD, GlobalVariable.name_service)

WebUI.verifyEqual(diaChiCelUD, diaChiUD)

WebUI.verifyEqual(maKH, maKHUD)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa khách hàng']), 3)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không tìm thấy dữ liệu...']), 2)

