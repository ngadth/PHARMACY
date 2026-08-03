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

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Nhập kho')
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

TestObject ghiChuField = new TestObject('ghiChuField')

ghiChuField.addProperty('xpath', ConditionType.EQUALS, "(//label[contains(normalize-space(.),'Ghi chú')]/following-sibling::div[1]//input[@type='text'])[2]")

WebUI.waitForElementVisible(ghiChuField, 10)
WebUI.scrollToElement(ghiChuField, 5)
WebUI.click(ghiChuField, FailureHandling.OPTIONAL)

try {
    WebUI.setText(ghiChuField, 'Nhập kho hàng hóa')
} catch (Exception ex) {
    def ghiChuElement = WebUI.findWebElement(ghiChuField, 10)
    WebUI.executeJavaScript('arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event("input", { bubbles: true })); arguments[0].dispatchEvent(new Event("change", { bubbles: true }));', 
        Arrays.asList(ghiChuElement, 'Nhập kho hàng hóa'))
}

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu nhập kho']), 5)

WebUI.sendKeys(findTestObject('Object Repository/Common/input_placeholderDynamicLocators', [('text') : 'Tìm loại hàng theo mã, tên, từ khóa (F3)', ('index') : '1']), GlobalVariable.maSanPham)

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

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Nhập kho thành công!']), 20)

WebUI.delay(2)

String phieuID = WebUI.getText(findTestObject('QuanLyKho/get_labelMaPhieu'))

GlobalVariable.po_phieu_id = phieuID

println(GlobalVariable.po_phieu_id)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Lưu thông tin phiếu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lưu thông tin phiếu thành công!']), 10)

WebUI.click(findTestObject('QuanLyKho/icon_close'))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), phieuID)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), Keys.chord(Keys.ENTER))

String maPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')

WebUI.verifyEqual(maPhieuCell, GlobalVariable.po_phieu_id)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa phiếu nhập kho']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận']))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

