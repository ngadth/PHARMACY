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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Kê đơn bán thuốc')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']))

GlobalVariable.maDonHang = 'ATORVASTATIN'

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFAh6E9X']), GlobalVariable.maDonHang)

WebUI.delay(2)

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(dynamicObject)

    println('Đã click element có value = 0')
} else {
    println('Không tìm thấy element có value = 0 → bỏ qua')
}

GlobalVariable.name_service = 'Auto_test01'

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Tìm khách hàng (F4)',('index'):'2']), GlobalVariable.name_service)

WebUI.click(findTestObject('Common/text_divDynamicLocators', [('text') : GlobalVariable.name_service]))

WebUI.setText(findTestObject('Common/input_tdTextDynamicLocators', [('text') : 'Tổng khuyến mại',('index'):'2']), '9999')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_khachThanhToan'))

WebUI.setText(findTestObject('XuatKhoBanHang/input_khachThanhToan'), '0')

WebUI.setText(findTestObject('QuanLyKho/textarea_GhiChu'), 'Nợ Kê đơn bán thuốc 30 ngày')

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']), 10)

String soPhieu = WebUI.getText(findTestObject('XuatKhoBanHang/get_bSoPhieu'))

WebUI.click(findTestObject('Common/icon_idDynamicLocators', [('idValue') : 'homepage']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('CÔNG NỢ', 'Lịch sử giao dịch với khách hàng')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'CÔNG NỢ']))

WebUI.waitForElementVisible(findTestObject('Common/menu_aDynamicLocators',[('text') : 'Lịch sử giao dịch với khách hàng']),30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Lịch sử giao dịch với khách hàng']))

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Tra cứu giao dịch của khách hàng']), 
    10)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'SHOP2-Nhà thuốc Minh Lộc', 
    false)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), GlobalVariable.maDonHang)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '6yXX4yXe4B1d']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '6yXX4yXe4B1d']), Keys.chord(Keys.ENTER))

WebUI.verifyElementChecked(findTestObject('CongNo/radio_idDynamicLocators', [('idValue') : 'chkPhieuPhaiThu']), 10)

String GDLQ = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '4']))

println(GDLQ)

// Lấy tất cả chữ số trong chuỗi
String giaoDich = GDLQ.replaceAll('\\D+', '')

println('Phần số là: ' + giaoDich)

WebUI.verifyEqual(giaoDich, soPhieu)

String ma = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '3']))

 //Tách chuỗi theo ký tự '-'
String[] parts = ma.split('-')

 //Lấy phần tử thứ 2 (index = 1)
String maKH = parts[1]

println('Giá trị cần lấy là: ' + maKH)

WebUI.verifyEqual(maKH, GlobalVariable.name_service)

