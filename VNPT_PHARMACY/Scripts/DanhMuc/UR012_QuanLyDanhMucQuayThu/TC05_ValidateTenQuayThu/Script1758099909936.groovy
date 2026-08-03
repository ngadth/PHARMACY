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

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Quầy thu/kho')

/* ===== Case 1: Cho phép nhập tiếng việt có dấu => tạo mới thành công ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma1 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_TVCD_' + ma1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten1 = CustomKeywords.'libKeyWords.PageObject.randomString'('ABCDEFGHIJKLMNOPQRSTUVWXYZ', 5)

GlobalVariable.name_service = ('Quầy Thu Tiếng Việt_' + ten1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), Keys.chord(Keys.ENTER))

String tenQuay1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên quầy', 0, 'table_quaythu')

WebUI.verifyEqual(tenQuay1, GlobalVariable.name_service)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.refresh()

WebUI.delay(3)


///* ===== Case 2: Cho phép nhập ký tự đặc biệt => vẫn cho thêm mới thành công ===== */
//WebUI.delay(2)
//
//WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))
//
//WebUI.delay(1)
//
//WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))
//
//WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)
//
//String ma2 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)
//
//GlobalVariable.maDonHang = ('Auto_KytDB_' + ma2)
//
//WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)
//
//String ten2 = CustomKeywords.'libKeyWords.PageObject.randomString'('ABCDEFGHIJKLMNOPQRSTUVWXYZ', 5)
//
//GlobalVariable.name_service = ('Ten_@#$%^&*_' + ten2)
//
//WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))
//
//WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)
//
//WebUI.delay(1)
//
//WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)
//
//WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), GlobalVariable.name_service)
//
//WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), Keys.chord(Keys.ENTER))
//
//String tenQuay2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên quầy', 0, 'table_quaythu')
//
//WebUI.verifyEqual(tenQuay2, GlobalVariable.name_service)
//
//WebUI.delay(1)
//
//WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))
//
//WebUI.delay(0.5)
//
//WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))
//
//WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))
//
//WebUI.refresh()
//
//WebUI.delay(3)


/* ===== Case 3: Cho phép nhập chữ số => tạo mới thành công ===== */

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma3 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_ChuSo_' + ma3)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten3 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_ChuSo_123_' + ten3)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), Keys.chord(Keys.ENTER))

String tenQuay3 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên quầy', 0, 'table_quaythu')

WebUI.verifyEqual(tenQuay3, GlobalVariable.name_service)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 4: Không cho phép nhập quá 50 ký tự => báo lỗi ===== */

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma4 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_50Kytu_' + ma4)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

GlobalVariable.name_service = 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABCDE'

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lỗi thực hiện!']), 5)

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 5: Không mã hóa khi nhập dữ liệu là thẻ html script => báo lỗi ===== */

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma5 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_XSS_' + ma5)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

GlobalVariable.name_service = '<script>alert(document.cookie)</script>'

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lỗi thực hiện!']), 5)

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 6: Cho phép nhập Tên quầy thu đã tồn tại => vẫn tạo mới thành công ===== */

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma6 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_TonTai_' + ma6)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten6 = CustomKeywords.'libKeyWords.PageObject.randomString'('ABCDEFGHIJKLMNOPQRSTUVWXYZ', 5)

GlobalVariable.name_service = ('Ten_Exist_' + ten6)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

/* Tạo bản ghi thứ 2 với cùng tên quầy thu */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma6b = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_TonTai2_' + ma6b)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

/* Xóa cả 2 bản ghi đã tạo */
WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

for (int i = 0; i < 2; i++) {
	WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

	WebUI.delay(0.5)

	WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

	WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

	WebUI.delay(2)
}
