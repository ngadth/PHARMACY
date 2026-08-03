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

String loaiHDDT1 = 'HĐ máy tính tiền (Đã gửi CQ thuế)'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObjects.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Bán hàng đã nhập kho')

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFAh6E9X']), '000062')

WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.delay(2)

GlobalVariable.maKH = 'Auto_test01'

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'makh']), GlobalVariable.maKH)

WebUI.click(findTestObject('Common/titlePage_bDynamicLocators', [('text') : GlobalVariable.maKH]))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_kMTrucTiep'), '5')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_khachThanhToan'))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_khachThanhToan'), '10,000')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'txtGhichu']), 'Nước Aquafina')

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']), 
    10)

WebUI.click(findTestObject('Common/icon_idDynamicLocators', [('idValue') : 'homepage']))

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObjects.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Tra cứu giao dịch xuất hóa đơn điện tử')

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Cửa hàng (tất cả)']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'CH01-Của hàng 01']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_kh']), GlobalVariable.maKH)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_kh']), Keys.chord(Keys.ENTER))

String soPhieu = CustomKeywords.'libKeyWords.PageObjects.getValueInTableByColumnName'('Số phiếu', 0, 'table_tcgd')

println(soPhieu)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'phieuban_id']), soPhieu)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'phieuban_id']), Keys.chord(Keys.ENTER))

WebUI.delay(3)

WebUI.click(findTestObject('Common/cell_tdDynamicLocators', [('index') : '1']))

WebUI.click(findTestObject('XuatKhoBanHang/button_idXuatHDDT'))

WebUI.delay(3)

WebUI.click(findTestObject('Common/text_aDynamicLocators', [('text') : 'Mẫu số 1/001, ký hiệu C25MMT (loại HĐ máy tính tiền)']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận có xuất']))

WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Xuất hóa đơn điện tử thành công, số hóa đơn:']), 
    15)

WebUI.click(findTestObject('Common/cell_tdDynamicLocators', [('index') : '1']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Gửi CQ thuế']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận có gửi']))

WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Gửi CQ thuế thành công phiếu bán số']), 
    15)

//String soPhieu = CustomKeywords.'libKeyWords.PageObjects.getValueInTableByColumnName'('Số phiếu', 0, 'table_tcgd')
//println(soPhieu)
String soHDDT = CustomKeywords.'libKeyWords.PageObjects.getValueInTableByColumnName'('Số HĐĐT', 0, 'table_tcgd')

println(soHDDT)

GlobalVariable.soHDDT = soHDDT

String nguoiBan = CustomKeywords.'libKeyWords.PageObjects.getValueInTableByColumnName'('Người bán', 0, 'table_tcgd')

println(nguoiBan)

String khachHang = CustomKeywords.'libKeyWords.PageObjects.getValueInTableByColumnName'('Khách hàng', 0, 'table_tcgd')

println(nguoiBan)

String loai = CustomKeywords.'libKeyWords.PageObjects.getValueInTableByColumnName'('Loại HĐĐT', 0, 'table_tcgd')

// Chuẩn hóa: bỏ khoảng trắng thừa và xuống dòng
String loaiHDDT = loai.replaceAll('\\s+', ' ').trim()

println('Text sau chuẩn hóa: ' + loaiHDDT)

WebUI.verifyEqual(nguoiBan, GlobalVariable.username)

WebUI.verifyEqual(khachHang, GlobalVariable.maKH)

WebUI.verifyEqual(loaiHDDT, loaiHDDT1)

