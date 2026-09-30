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

/* ===== Case 1: Cho phép nhập chữ số => tạo mới thành công ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma1 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_ChuSo_' + ma1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten1 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_Auto_' + ten1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtTenQuayThu']), Keys.chord(Keys.ENTER))

String maQuay1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã quầy', 0, 'table_quaythu')

WebUI.verifyEqual(maQuay1, GlobalVariable.maDonHang)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.refresh()

WebUI.delay(3)


///* ===== Case 2: Nhập ký tự đặc biệt => vẫn cho thêm mới thành công ===== */
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
//GlobalVariable.maDonHang = ('Auto_KyDB_' + ma2 + '@#$%')
//
//WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)
//
//String ten2 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)
//
//GlobalVariable.name_service = ('Ten_Auto_' + ten2)
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
//String maQuay2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã quầy', 0, 'table_quaythu')
//
//WebUI.verifyEqual(maQuay2, GlobalVariable.maDonHang)
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


/* ===== Case 3: Không mã hóa khi nhập dữ liệu là thẻ html script => báo lỗi ===== */

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

GlobalVariable.maDonHang = '<script>alert(document.cookie)</script>'

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten3 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_Auto_' + ten3)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lỗi thực hiện!']), 5)

//WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Hủy']))

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 4: Nhập mã quầy thu đã tồn tại => vẫn cho thêm mới thành công ===== */

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma4 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_TonTai_' + ma4)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten4 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_Auto_' + ten4)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

/* Tạo bản ghi thứ 2 với cùng mã quầy thu */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten4b = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_Auto2_' + ten4b)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

/* Xóa cả 2 bản ghi đã tạo */
WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), Keys.chord(Keys.ENTER))

WebUI.delay(1)

for (int i = 0; i < 2; i++) {
	WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

	WebUI.delay(0.5)

	WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

	WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

	WebUI.delay(2)
}
