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

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Quản lý danh mục bác sĩ')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Danh sách Bác Sĩ']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm mới Bác Sĩ']), 5)

String bacSi = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('MaBSAuto_' + bacSi)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtmabacsi_add']), GlobalVariable.maKH)

String tenBS = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('TenBSAuto_' + tenBS)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txttenbacsi_add']), GlobalVariable.name_service)

String date = '12/03/1994'

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'textngaysinh_add']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'textngaysinh_add']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'textngaysinh_add']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'chuyenkhoa_add']), 'Tai - Mũi - Họng')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'trinhdo_add']), 'Tiến Sĩ')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'diachi_add']), 'Đà Nẵng')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'noicongtac_add']), 'Bệnh Viện Đa Khoa')

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbotrangthai_add']), 'Kích hoạt', 
    false)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Thêm & Đóng']))

WebUI.delay(2)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtmabacsi']), GlobalVariable.maKH)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txttenbacsi']), GlobalVariable.name_service)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbotrangthai']), 'Kích hoạt', 
    false)

WebUI.sendKeys(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbotrangthai']), Keys.chord(Keys.ENTER))

String maBSCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã BS', 0, 'product')

String tenBSCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên BS', 0, 'product')

WebUI.verifyEqual(maBSCell, GlobalVariable.maKH)

WebUI.verifyEqual(tenBSCell, GlobalVariable.name_service)

WebUI.delay(2)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Cập nhật thông tin Bác Sĩ']), 
    5)

String tenBSUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('UDTenBSAuto_' + tenBSUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txttenbacsi_edit']), GlobalVariable.name_service)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'textngaysinh_edit']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'textngaysinh_edit']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'textngaysinh_edit']), Keys.chord(Keys.ENTER))

String chuyenKhoa = 'Khoa Nhi'

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'chuyenkhoa_edit']), chuyenKhoa)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'trinhdo_edit']), 'Tiến Sĩ')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'diachi_edit']), 'Đà Nẵng')

String noiCT = 'Khoa Nhi'

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'noicongtac_edit']), noiCT)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbotrangthai_edit']), 
    'Kích hoạt', false)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cập nhật']))

WebUI.delay(2)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtmabacsi']), GlobalVariable.maKH)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txttenbacsi']), GlobalVariable.name_service)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbotrangthai']), 'Kích hoạt', 
    false)

WebUI.sendKeys(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbotrangthai']), Keys.chord(Keys.ENTER))

String tenBSCellUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên BS', 0, 'product')

String chuyenKhoaCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Chuyên khoa', 0, 'product')

String noiCTCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Nơi công tác', 0, 'product')

WebUI.verifyEqual(maBSCell, GlobalVariable.maKH)

WebUI.verifyEqual(chuyenKhoaCell, chuyenKhoa)

WebUI.verifyEqual(noiCTCell, noiCT)

WebUI.delay(2)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa thông tin Bác Sĩ']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

