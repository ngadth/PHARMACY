import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.katalon.webui.keyword.assertion.AssertElementAttributeValueKeyword
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Kiểm kê hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Kiểm kê hàng hóa']), 3)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu kiểm kê']), 5)

WebUI.click(findTestObject('QuanLyKho/select_labelSpanDynamicLocators', [('labelValue') : 'Kho']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

String ghichu = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('ghiChu' + ghichu)

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), GlobalVariable.name_service)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Ngày nhập']))

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Ngày nhập']), currentDate)
WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Ngày nhập']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

String hangHoa = 'MA316'

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'search_product']), hangHoa)

WebUI.delay(3)

WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.setText(findTestObject('QuanLyKho/input_soluongClass'), '2')

//WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'quantity_in_warehouse_205966_1']),  '2')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện kiểm kê thành công']), 5)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cân kho']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Kho nhập (tất cả)']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.click(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), date)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), hangHoa)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String soPhieu = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu', 0, 'tableCheckProduct')

String dienGiai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Diễn giải', 0, 'tableCheckProduct')

WebUI.verifyEqual(dienGiai, GlobalVariable.name_service)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu kiểm kê']), 5)


//mac dinh
String value = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')

assert value.trim() == GlobalVariable.name_service

//chu va so

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'ABC-234')

String value1 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')

assert value1.trim() == 'ABC-234'

//html

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), '<script>alert(document.cookie)</script>')

String value2 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')

assert value2.trim() == '<script>alert(document.cookie)</script>'

// ky tu dac biet

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), '# "-,/"')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.assertElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Có lỗi xảy ra, bạn vui lòng thử lại!']), 5)

////<21
//
//WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'AGASD-4564562-q52-GSDGSDGFSDF')
//
//String value3 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')
//
//assert value3.trim().size() <= 20
