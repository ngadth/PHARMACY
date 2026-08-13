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

String overLimitValue = '987,654,387,6541'
String expectedCutValue = '987,654,387,654'

void setTextAndTriggerFormat(TestObject input, String value) {
    WebUI.click(input)
    WebUI.clearText(input)
    WebUI.setText(input, value)
    WebUI.sendKeys(input, Keys.chord(Keys.TAB))
    WebUI.delay(1)
}

void verifyAutoCutTo15Chars(TestObject input, String fieldName, String expectedValue) {
    String actualValue = WebUI.getAttribute(input, 'value')
    String normalizedActual = (actualValue ?: '').trim()

    WebUI.comment(fieldName + ' - Actual value after auto-cut: ' + normalizedActual)
    WebUI.verifyEqual(normalizedActual, expectedValue)
    WebUI.verifyEqual(normalizedActual.length(), 15)
}

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập kho']))
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu nhập kho']), 5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'inputType']), 'Nhập kho từ danh mục hàng hóa', false)

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
    WebUI.setText(ghiChuField, 'Validate 15 ky tu truong so tu DQG')
} catch (Exception ex) {
    def ghiChuElement = WebUI.findWebElement(ghiChuField, 10)
    WebUI.executeJavaScript('arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event("input", { bubbles: true })); arguments[0].dispatchEvent(new Event("change", { bubbles: true }));',
        Arrays.asList(ghiChuElement, 'Validate 15 ky tu truong so tu DQG'))
}

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))
WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm từ danh mục dược quốc gia']), 5)
WebUI.click(findTestObject('Object Repository/QuanLyKho/button_InsertFromDanhMucQuocGia'))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Nhập từ khóa tìm kiếm']), 'Harcotin')
WebUI.waitForElementVisible(findTestObject('Object Repository/QuanLyKho/select_DQG_textDynamicLocators', [('nameValue') : 'Harcotin']), 5)
WebUI.click(findTestObject('Object Repository/QuanLyKho/select_DQG_textDynamicLocators', [('nameValue') : 'Harcotin']))

WebUI.delay(2)

TestObject nhomHangHoa = findTestObject('Object Repository/Common/dropdown_selectDynamicLocators', [('idValue') : 'nhom_hang_hoa'])
TestObject soLuongNhap = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap'])
TestObject soLo = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo'])
TestObject hanSuDung = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung'])
TestObject viTri = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'vi_tri'])
TestObject donViNhap = findTestObject('Object Repository/Common/dropdown_selectDynamicLocators', [('idValue') : 'cbo_donvi_duocquocgia'])
TestObject tyLeVat = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'tyle_vat'])
TestObject giaNhap = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap'])
TestObject giaBan = findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_ban'])

String dateHetHan = '19/02/2027'

// Điền dữ liệu hợp lệ cho các trường khác
WebUI.selectOptionByIndex(nhomHangHoa, 1)
setTextAndTriggerFormat(soLuongNhap, '2')
setTextAndTriggerFormat(soLo, '1')
setTextAndTriggerFormat(hanSuDung, dateHetHan)
WebUI.sendKeys(hanSuDung, Keys.chord(Keys.ENTER))
setTextAndTriggerFormat(viTri, '749 LangHa HaNoi')
WebUI.selectOptionByIndex(donViNhap, 1)
setTextAndTriggerFormat(tyLeVat, '2')
setTextAndTriggerFormat(giaNhap, '1500')
setTextAndTriggerFormat(giaBan, '1600')

// Test 1: Số lượng nhập không được vượt quá 15 ký tự
setTextAndTriggerFormat(soLuongNhap, overLimitValue)
verifyAutoCutTo15Chars(soLuongNhap, 'Số lượng nhập', expectedCutValue)

// Trả về giá trị hợp lệ trước khi test trường tiếp theo
setTextAndTriggerFormat(soLuongNhap, '2')

// Test 2: Giá nhập không được vượt quá 15 ký tự
setTextAndTriggerFormat(giaNhap, overLimitValue)
verifyAutoCutTo15Chars(giaNhap, 'Giá nhập', expectedCutValue)

// Trả về giá trị hợp lệ trước khi test trường tiếp theo
setTextAndTriggerFormat(giaNhap, '1500')

// Test 3: Giá bán không được vượt quá 15 ký tự
setTextAndTriggerFormat(giaBan, overLimitValue)
verifyAutoCutTo15Chars(giaBan, 'Giá bán', expectedCutValue)

WebUI.comment('All numeric fields have been validated for max 15 chars')
