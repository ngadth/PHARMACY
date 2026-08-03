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

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Kiểm kê hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Kiểm kê hàng hóa']), 3)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu kiểm kê']), 5)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-TFXwQyXlRcXXDsba-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

String ghichu = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('ghiChu' + ghichu)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'TFXwPEbbCaTf4Ba.']), GlobalVariable.name_service)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUS1e43o.']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUS1e43o.']), currentDate)
WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXUS1e43o.']), Keys.chord(Keys.ENTER))

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

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-4yHlQyXlRcXXDo-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.click(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), date)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), hangHoa)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String soPhieu = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu', 0, 'tableCheckProduct')

String dienGiai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Diễn giải', 0, 'tableCheckProduct')

WebUI.verifyEqual(dienGiai, GlobalVariable.name_service)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu kiểm kê']), 5)

String ghichuUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('UDghiChu' + ghichuUD)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'TFXwPEbbCaTf4Ba.']), GlobalVariable.name_service)

WebUI.delay(0.5)

WebUI.click(findTestObject('QuanLyKho/tab_aTextDynamicLocators', [('tabValue') : 'Kiểm kê thêm hàng']))

WebUI.delay(0.5)

WebUI.click(findTestObject('QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'nhomhanghoa']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-4yHY3y1eCyxe6o-container']))

WebUI.setText(findTestObject('Common/input_search'), 'KD6')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'KD6']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Chọn']))

WebUI.delay(10)

WebUI.setText(findTestObject('QuanLyKho/input_soluongClass'), '2')

//WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'quantity_in_warehouse_207383_1']), '2')
WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Sửa thông tin phiếu kiểm kê thành công']), 
    5)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cân kho']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-4yHlQyXlRcXXDo-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.click(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), date)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), hangHoa)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'TFXwRBtM6Etm']), soPhieu)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String input = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Diễn giải', 0, 'tableCheckProduct')

String dienGiaiUD = input.split("\\(")[0]
println(dienGiaiUD)

WebUI.verifyEqual(dienGiaiUD, GlobalVariable.name_service)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa phiếu kiểm kê']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Xóa phiếu kiểm kê thành công']), 5)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'TFXwRBtM6Etm']), soPhieu)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

