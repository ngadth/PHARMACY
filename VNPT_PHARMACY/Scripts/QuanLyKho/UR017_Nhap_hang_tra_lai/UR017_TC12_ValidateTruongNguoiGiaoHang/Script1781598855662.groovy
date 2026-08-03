import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('XuatKhoBanHang/UR020_KeDonBanThuoc/TC01_KeDonBanThuoc'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Common/icon_idDynamicLocators', [('idValue') : 'homepage']))

WebUI.delay(3)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập hàng trả lại']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Tra cứu giao dịch cần nhập kho trả hàng']),
	5)

WebUI.click(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']))
WebUI.selectOptionByIndex(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 0)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsFirst', [('buttonName') : 'Chọn']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu nhập kho trả hàng']),
	5)

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập']), 'Hà Thái Bảo')

// Test trường "Người giao hàng" - trường không bắt buộc, cho phép chữ và số
String nghValue = 'Giao123'

WebUI.waitForElementVisible(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Người giao hàng']), 10)
WebUI.click(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Người giao hàng']), FailureHandling.OPTIONAL)
WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Người giao hàng']), nghValue)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

soPhieu = WebUI.getText(findTestObject('QuanLyKho/get_labelMaPhieu'))

println('Số phiếu: ' + soPhieu)

GlobalVariable.order_id = soPhieu

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Hàng trong phiếu bán chưa được nhập kho']))

WebUI.delay(2)

WebUI.click(findTestObject('Common/checkbox_nameDynamicLocators', [('nameValue') : 'pcheck']))

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Nhập kho thành công!']), 5)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu nhập kho trả hàng']), 5)

WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Sửa phiếu nhập kho trả hàng']))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), GlobalVariable.order_id)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']), date)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']), Keys.chord(Keys.ENTER))

WebUI.delay(3)

String maPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')

String ngayNhap = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày nhập', 0, 'inputtbl')

WebUI.verifyEqual(maPhieuCell, GlobalVariable.order_id)

WebUI.verifyEqual(ngayNhap, currentDate)

//WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))
//
//WebUI.delay(0.5)
//
//WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))
//
//WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa phiếu nhập kho']), 3)
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận']))
//
//WebUI.delay(2)
//
//WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

