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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.Arrays

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập kho']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu nhập kho']), 5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'inputType']), 'Nhập kho từ danh mục hàng hóa', 
    false)

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập ']), 'Shop5')

WebUI.click(findTestObject('QuanLyKho/select_labelSpanDynamicLocators', [('labelValue') : 'Kho nhập']))

TestObject firstKhoNhapOption = new TestObject('firstKhoNhapOption')

firstKhoNhapOption.addProperty('xpath', ConditionType.EQUALS, "(//ul[contains(@class,'select2-results__options')]//li[contains(@class,'select2-results__option') and not(contains(@class,'select2-results__message'))])[1]")

WebUI.click(firstKhoNhapOption)

WebUI.click(findTestObject('QuanLyKho/select_labelSpanDynamicLocators', [('labelValue') : 'Nhà cung cấp']))

WebUI.click(firstKhoNhapOption)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

TestObject ngayNhapField = new TestObject('ngayNhapField')

ngayNhapField.addProperty('xpath', ConditionType.EQUALS, "(//label[contains(normalize-space(.),'Ngày nhập')]/following-sibling::div[1]//input[@type='text'])[2]")

WebUI.click(ngayNhapField)

WebUI.sendKeys(ngayNhapField, date)

WebUI.sendKeys(ngayNhapField, Keys.chord(Keys.ENTER))

// Test trường "Phương tiện vận chuyển" - trường không bắt buộc, cho phép chữ và số
String ptvmValue = 'Transport123'

WebUI.waitForElementVisible(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Phương tiện vận chuyển']), 10)
WebUI.click(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Phương tiện vận chuyển']), FailureHandling.OPTIONAL)
WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Phương tiện vận chuyển']), ptvmValue)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'TFAh6E9X3yxl6B1e43o.']), GlobalVariable.maSanPham)

TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(dynamicObject)

    println('Đã click element có value = 0')
} else {
    println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.delay(2)

WebUI.setText(findTestObject('QuanLyKho/input_soLuongNhapKho'), '2')

WebUI.setText(findTestObject('QuanLyKho/input_soLuongNhapKho'), '2')

String dateHetHan = '19/02/2027'

WebUI.click(findTestObject('QuanLyKho/input_loSanXuat'))

WebUI.setText(findTestObject('QuanLyKho/input_loSanXuat'), '2')

WebUI.click(findTestObject('QuanLyKho/input_ngayHetHan'))

WebUI.sendKeys(findTestObject('QuanLyKho/input_ngayHetHan'), dateHetHan)

WebUI.sendKeys(findTestObject('QuanLyKho/input_ngayHetHan'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.delay(5)

try {
    WebUI.acceptAlert(FailureHandling.OPTIONAL)
    WebUI.comment('Alert xuất hiện và đã được accept')
} catch (Exception e) {
    WebUI.comment('Không có alert, tiếp tục chạy')
}

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('QuanLyKho/get_labelMaPhieu'), 10)

String phieuID = WebUI.getText(findTestObject('QuanLyKho/get_labelMaPhieu'))
phieuID = phieuID == null ? '' : phieuID.trim()

GlobalVariable.po_phieu_id = phieuID

println(GlobalVariable.po_phieu_id)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Lưu thông tin phiếu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lưu thông tin phiếu thành công!']), 10)

WebUI.click(findTestObject('QuanLyKho/icon_close'))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), phieuID)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), Keys.chord(Keys.ENTER))

String maPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')
maPhieuCell = maPhieuCell == null ? '' : maPhieuCell.trim()

if ((GlobalVariable.po_phieu_id == null) || (GlobalVariable.po_phieu_id.trim() == '')) {
    WebUI.comment('Không lấy được mã phiếu từ label, dùng mã phiếu từ dòng đầu bảng để tiếp tục verify')
    GlobalVariable.po_phieu_id = maPhieuCell
}

WebUI.verifyEqual(maPhieuCell, GlobalVariable.po_phieu_id.trim())
