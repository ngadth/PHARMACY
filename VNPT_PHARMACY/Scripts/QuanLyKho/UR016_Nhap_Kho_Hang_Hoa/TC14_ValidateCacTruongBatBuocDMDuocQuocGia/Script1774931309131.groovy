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

// Định nghĩa các test case validation
def validateRequiredFields() {
    // Đăng nhập
    WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)
    
    WebUI.delay(3)
    
    // Setup phiếu nhập kho
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
        WebUI.setText(ghiChuField, 'Validate các trường bắt buộc')
    } catch (Exception ex) {
        def ghiChuElement = WebUI.findWebElement(ghiChuField, 10)
        WebUI.executeJavaScript('arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event("input", { bubbles: true })); arguments[0].dispatchEvent(new Event("change", { bubbles: true }));',
            Arrays.asList(ghiChuElement, 'Validate các trường bắt buộc'))
    }
    
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))
    WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)
    
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm từ danh mục dược quốc gia']), 5)
    WebUI.click(findTestObject('Object Repository/QuanLyKho/button_InsertFromDanhMucQuocGia'))
    
    // Tìm kiếm và chọn thuốc
    WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Nhập từ khóa tìm kiếm']), 'Harcotin')
    WebUI.waitForElementVisible(findTestObject('Object Repository/QuanLyKho/select_DQG_textDynamicLocators', [('nameValue') : 'Harcotin']), 5)
    WebUI.click(findTestObject('Object Repository/QuanLyKho/select_DQG_textDynamicLocators', [('nameValue') : 'Harcotin']))
    
    WebUI.delay(2)
    
    String dateHetHan = '19/02/2027'
    
    // ========== TEST 1: Validate Nhóm hàng hóa ==========
    WebUI.comment('=== TEST 1: Validate Nhóm hàng hóa - Không chọn ===')
    
    // Không chọn Nhóm hàng hóa
    WebUI.selectOptionByIndex(findTestObject('Object Repository/Common/dropdown_selectDynamicLocators', [('idValue') : 'nhom_hang_hoa']), 0)
    
    // Điền đầy đủ các trường khác
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap']), '2')
    
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo']), '1')
    
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']))
    WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']), dateHetHan)
    WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']), Keys.chord(Keys.ENTER))
    
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'vi_tri']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'vi_tri']), '749 LangHa HaNoi')
    
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Common/dropdown_selectDynamicLocators', [('idValue') : 'cbo_donvi_duocquocgia']), 'Viên', false)
    
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'tyle_vat']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'tyle_vat']), '2')
    
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap']), '1500')
    
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_ban']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_ban']), '1600')
    
    // Nhấn Thêm & đóng
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Thêm & đóng']))
    
    // Verify thông báo lỗi: "Bạn chưa chọn nhóm hàng hóa"
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa chọn Nhóm hàng hóa!']), 5)
    WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa chọn Nhóm hàng hóa!']))
    
    WebUI.comment('✓ TEST 1 PASSED: Nhóm hàng hóa validation successful')
    WebUI.delay(1)
    
    // ========== TEST 2: Validate Số lượng nhập ==========
    WebUI.comment('=== TEST 2: Validate Số lượng nhập ===')
    
    // Chọn Nhóm hàng hóa
    WebUI.selectOptionByIndex(findTestObject('Object Repository/Common/dropdown_selectDynamicLocators', [('idValue') : 'nhom_hang_hoa']), 1)
    
    // Xóa Số lượng nhập
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap']))
    WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap']))
    
    // Nhấn Thêm & đóng
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Thêm & đóng']))
    
    // Verify thông báo lỗi: "Bạn chưa nhập Số lượng!"
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Số lượng!']), 5)
    WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Số lượng!']))
    
    WebUI.comment('✓ TEST 2 PASSED: Số lượng nhập validation successful')
    WebUI.delay(1)
    
    // ========== TEST 3: Validate Số lô ==========
    WebUI.comment('=== TEST 3: Validate Số lô ===')
    
    // Điền lại Số lượng nhập
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_luong_nhap']), '2')
    
    // Xóa Số lô
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo']))
    WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo']))
    
    // Nhấn Thêm & đóng
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Thêm & đóng']))
    
    // Verify thông báo lỗi: "Bạn chưa nhập Số lô!"
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Số lô!']), 5)
    WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Số lô!']))
    
    WebUI.comment('✓ TEST 3 PASSED: Số lô validation successful')
    WebUI.delay(1)
    
    // ========== TEST 4: Validate Hạn sử dụng ==========
    WebUI.comment('=== TEST 4: Validate Hạn sử dụng ===')
    
    // Điền lại Số lô
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'so_lo']), '1')
    
    // Xóa Hạn sử dụng
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']))
    WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']))
    
    // Nhấn Thêm & đóng
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Thêm & đóng']))
    
    // Verify thông báo lỗi: "Bạn chưa nhập Hạn sử dụng!"
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Hạn sử dụng!']), 5)
    WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Hạn sử dụng!']))
    
    WebUI.comment('✓ TEST 4 PASSED: Hạn sử dụng validation successful')
    WebUI.delay(1)
    
    // ========== TEST 5: Validate Gía nhập ==========
    WebUI.comment('=== TEST 5: Validate Gía nhập ===')
    
    // Điền lại Hạn sử dụng
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']))
    WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']), dateHetHan)
    WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'han_su_dung']), Keys.chord(Keys.ENTER))
    
    // Xóa Gía nhập
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap']))
    WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap']))
    
    // Nhấn Thêm & đóng
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Thêm & đóng']))
    
    // Verify thông báo lỗi: "Bạn chưa nhập Gía nhập!"
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Giá nhập!']), 5)
    WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Giá nhập!']))
    
    WebUI.comment('✓ TEST 5 PASSED: Gía nhập validation successful')
    WebUI.delay(1)
    
    // ========== TEST 6: Validate Gía bán ==========
    WebUI.comment('=== TEST 6: Validate Gía bán ===')
    
    // Điền lại Gía nhập
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap']))
    WebUI.setText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_nhap']), '1500')
    
    // Xóa Gía bán
    WebUI.click(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_ban']))
    WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'gia_ban']))
    
    // Nhấn Thêm & đóng
    WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Thêm & đóng']))
    
    // Verify thông báo lỗi: "Bạn chưa nhập Gía bán!"
    WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Giá bán!']), 5)
    WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Bạn chưa nhập Giá bán!']))
    
    WebUI.comment('✓ TEST 6 PASSED: Gía bán validation successful')
    WebUI.delay(1)
    
    WebUI.comment('=== ALL VALIDATION TESTS PASSED ===')
}

// Thực thi test
try {
    validateRequiredFields()
    WebUI.closeBrowser()
} catch (Exception e) {
    WebUI.comment('Test failed with error: ' + e.message)
    WebUI.closeBrowser()
    throw e
}
