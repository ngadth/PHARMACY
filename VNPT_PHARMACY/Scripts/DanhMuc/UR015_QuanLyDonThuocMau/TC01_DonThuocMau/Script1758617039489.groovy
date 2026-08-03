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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.nio.file.*

String dateKT = '18/10/2028'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'DANH MỤC']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Đơn thuốc mẫu']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Đơn thuốc mẫu')
WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Đơn thuốc mẫu']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm đơn thuốc']), 5)

String tenDT = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('DThuocAuto_' + tenDT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TFXwSFHbDyLM4Bxb']), GlobalVariable.maKH)

WebUI.click(findTestObject('Common/button_spanDynamicLocators', [('buttonName') : 'Tất cả']))

WebUI.click(findTestObject('DanhMuc/checkbox_cuaHangDonThuoc', [('idValue') : '2']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'inputType']), 'Hoạt động', 
    false)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + '18/10/2028'

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSHs']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSHs']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSHs']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSjS']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSjS']), dateKT)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSjS']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TFXwPEbbCaTf4Ba.']), 'Thêm mới đơn thuốc mẫu')

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Danh sách thuốc']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFAh6E9X3yxl6B1e43o.']), 'Apitim')

WebUI.delay(3)

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(dynamicObject)

    println('Đã click element có value = 0')
} else {
    println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : '5Etw53HXCcTb']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : '5Etw53HXCcTb']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : '5Etw53HXCcTb']), Keys.chord(Keys.ENTER))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'selectorId']), 'Hoạt động', 
    false)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'tukhoa']), GlobalVariable.maKH)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'tukhoa']), Keys.chord(Keys.ENTER))

String tenDonThuoc = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên đơn thuốc', 0, 'inputtbl')

String ngayBD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày bắt đầu áp dụng', 0, 'inputtbl')

String ngayKT = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày kết thúc áp dụng', 0, 'inputtbl')

WebUI.verifyEqual(tenDonThuoc, GlobalVariable.maKH)

WebUI.verifyEqual(ngayBD, currentDate)

WebUI.verifyEqual(ngayKT, dateKT)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(3)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa đơn thuốc']), 5)

GlobalVariable.maKH = ('UDDThuocAuto_' + tenDT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TFXwSFHbDyLM4Bxb']), GlobalVariable.maKH)

//WebUI.click(findTestObject('Common/button_spanDynamicLocators', [('buttonName') : 'HUONG6787-Nguyễn Thanh Hương']))

//WebUI.click(findTestObject('DanhMuc/checkbox_cuaHangDonThuoc', [('idValue') : '2']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'inputType']), 'Hoạt động', 
    false)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSHs']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSHs']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSHs']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSjS']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSjS']), dateKT)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUSjS']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TFXwPEbbCaTf4Ba.']), 'Update đơn thuốc mẫu')

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Danh sách thuốc']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFAh6E9X3yxl6B1e43o.']), 'B1-B6-B12 USP')

WebUI.delay(3)

WebUI.click(findTestObject('XuatKhoBanHang/data_indexLast', [('value') : '0']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : '5Etw53HXCcTb']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : '5Etw53HXCcTb']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : '5Etw53HXCcTb']), Keys.chord(Keys.ENTER))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'selectorId']), 'Hoạt động', 
    false)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'tukhoa']), GlobalVariable.maKH)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'tukhoa']), Keys.chord(Keys.ENTER))

String tenDTUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên đơn thuốc', 0, 'inputtbl')

String ngayBD1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày bắt đầu áp dụng', 0, 'inputtbl')

String ngayKT1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày kết thúc áp dụng', 0, 'inputtbl')

WebUI.verifyEqual(tenDTUD, GlobalVariable.maKH)

WebUI.verifyEqual(ngayBD1, currentDate)

WebUI.verifyEqual(ngayKT1, dateKT)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa đơn mẫu']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

