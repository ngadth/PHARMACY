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

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'inputType']), 'Nhập kho từ đơn đặt hàng NCC',false)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Tra cứu Đơn đặt hàng tới nhà cung cấp']), 5)

WebUI.click(findTestObject('Object Repository/QuanLyKho/button_textDynamicLocatorsFirst', [('buttonName') : 'Chọn']))

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập ']), 'Shop5')

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

String dateHetHan = '19/02/2027'

WebUI.click(findTestObject('QuanLyKho/input_ngayHetHan'))

WebUI.sendKeys(findTestObject('QuanLyKho/input_ngayHetHan'), dateHetHan)

WebUI.sendKeys(findTestObject('QuanLyKho/input_ngayHetHan'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/QuanLyKho/input_pcheck'))

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

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Công nợ']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Cập nhật công nợ NCC']), 5)
