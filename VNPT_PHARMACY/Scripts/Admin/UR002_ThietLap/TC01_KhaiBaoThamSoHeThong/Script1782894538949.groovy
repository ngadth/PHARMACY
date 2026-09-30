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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('THIẾT LẬP', 'Khai báo tham số hệ thống')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Khai báo tham số hệ thống']), 
    5)

WebUI.scrollToElement(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbbPROMOTION_VAT_INPUT44']), 
    5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbbPROMOTION_VAT_INPUT44']), 
    'Có', false)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cập nhật']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 10)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Nhập kho')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu nhập kho']), 5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'inputType']), 'Nhập kho từ danh mục hàng hóa', 
    false)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwAEXxQyXl']), 'Shop5')

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-TFXwQyXlRcXXDsba-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-4yHlRaLr-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : '1122 - Tường Vy']))

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUS1e43o.']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUS1e43o.']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUS1e43o.']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu nhập kho']), 5)

WebUI.delay(3)

// Danh sách cột mong muốn
List<String> expectedColumns = ['Tỷ lệ CK %', 'Tổng tiền CK', 'Tỷ lệ VAT %', 'Tổng tiền VAT']

// Lấy danh sách tất cả header thực tế trong table
List<WebElement> actualHeaders = WebUiCommonHelper.findWebElements(findTestObject('DanhMuc/table_headers'), 10)

// Lưu text header thực tế vào List
List<String> actualColumnNames = actualHeaders.collect({ 
        it.getText().trim()
    })

// In ra để kiểm tra
println('Actual headers: ' + actualColumnNames)

// So sánh 2 danh sách
if (actualColumnNames.containsAll(expectedColumns)) {
    println('✅ Table hiển thị đầy đủ các cột mong muốn.')
} else {
    println('❌ Table bị thiếu hoặc sai cột!')

    println('Thiếu: ' + (expectedColumns - actualColumnNames))
}

