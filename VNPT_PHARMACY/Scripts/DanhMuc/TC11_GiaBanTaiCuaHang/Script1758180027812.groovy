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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Giá bán tại cửa hàng')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Quản lý giá bán']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm giá bán']), 5)

String tenGia = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 6)

GlobalVariable.maDonHang = ('GiaAuto_' + tenGia)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'CB9w4A9X5EO.']), GlobalVariable.maDonHang)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới thành công']), 3)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CB9w4O..']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CB9w4O..']), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật thông tin']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Cập nhật giá bán']), 3)

String inputValue = WebUI.getAttribute(findTestObject('Common/input_idDynamicLocators', [('idValue') : '4yXf53Ph6Etx5EnV6BPV5BPfTEHY']), 
    'value')

println('Giá trị của input là: ' + inputValue)

String tenGiaUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 6)

GlobalVariable.maDonHang = ('UDGiaAuto_' + tenGiaUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'CB9w4A9b5Ebw3yHY']), GlobalVariable.maDonHang)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 3)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '4yXf53Ph6Etx5EnV6BO.']), inputValue)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CB9w4O..']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CB9w4O..']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu chi tiết']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'CcXX4zAk5yLXDt9f5o..']), 
    'Duoc pham', false)

WebUI.setText(findTestObject('QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'CBtiCytfDzo.']), 'Aclovia')

WebUI.sendKeys(findTestObject('QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'CBtiCytfDzo.']), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.click(findTestObject('Common/checkbox_idDynamicLocators', [('idValue') : 'userchoice1']))

WebUI.setText(findTestObject('QuanLyKho/input_idDynamicLocators', [('idValue') : 'tien_1']), '9999')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cập nhật']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công!']), 3)

WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Cập nhật giá bán']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '4yXf53Ph6Etx5EnV6BO.']), inputValue)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CB9w4O..']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CB9w4O..']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

moTaCT = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '3']))

ID = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '2']))

WebUI.verifyEqual(moTaCT, GlobalVariable.maDonHang)

WebUI.verifyEqual(ID, inputValue)

