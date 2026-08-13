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

TestObject soTTInput = findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtSoTT_i'])
final int MAX_MA_QUAY_LENGTH = 20

def generateMaQuay = { String prefix ->
	String chars = '1234567890ABCDRFGLJH'
	String safePrefix = prefix

	if (safePrefix.length() >= MAX_MA_QUAY_LENGTH) {
		return safePrefix.substring(0, MAX_MA_QUAY_LENGTH)
	}

	int remainLength = MAX_MA_QUAY_LENGTH - safePrefix.length()
	String randomPart = CustomKeywords.'libKeyWords.PageObject.randomString'(chars, remainLength)

	return (safePrefix + randomPart)
}

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Quầy thu/kho')

/* ===== Case 1: Số TT trong quyển không phải là trường bắt buộc => tạo mới thành công ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebUI.waitForElementVisible(soTTInput, 5)

GlobalVariable.maDonHang = generateMaQuay('STTOP_')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten1 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_SoTT_Optional_' + ten1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), Keys.chord(Keys.ENTER))

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


/* ===== Case 2: Không cho phép nhập ký tự đặc biệt cho Số TT trong quyển => báo lỗi ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebUI.waitForElementVisible(soTTInput, 5)

GlobalVariable.maDonHang = generateMaQuay('STTSP_')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten2 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_SoTT_Special_' + ten2)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.setText(soTTInput, '@#$%^&*')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lỗi thực hiện!']), 5)

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 3: Nhập thẻ html/script cho Số TT trong quyển => báo lỗi, không mã hóa khi lưu ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebUI.waitForElementVisible(soTTInput, 5)

GlobalVariable.maDonHang = generateMaQuay('STTXS_')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten3 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_SoTT_XSS_' + ten3)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.setText(soTTInput, '<script>alert(document.cookie)</script>')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lỗi thực hiện!']), 5)

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 4: Số TT trong quyển cho phép nhập chữ số, tối đa 10 ký tự => tạo mới thành công ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebUI.waitForElementVisible(soTTInput, 5)

GlobalVariable.maDonHang = generateMaQuay('STTNB_')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten4 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_SoTT_Number_' + ten4)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.setText(soTTInput, '1234567890')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), Keys.chord(Keys.ENTER))

String maQuay4 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã quầy', 0, 'table_quaythu')

WebUI.verifyEqual(maQuay4, GlobalVariable.maDonHang)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 5: Số TT trong quyển không cho phép nhập ký tự chữ => báo lỗi ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebUI.waitForElementVisible(soTTInput, 5)

GlobalVariable.maDonHang = generateMaQuay('STTAN_')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten5 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_SoTT_AlphaNum_' + ten5)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.setText(soTTInput, 'A12B34C5')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lỗi thực hiện!']), 5)

WebUI.refresh()

WebUI.delay(2)
