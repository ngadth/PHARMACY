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

String soLuong = '2'

WebUI.callTestCase(findTestCase('QuanLyKho/UR016_Nhap_Kho_Hang_Hoa/TC00_NhapKho'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Xuất trả hàng NCC')

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Xuất trả hàng NCC']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu xuất trả nhà cung cấp']), 
    5)

WebUI.click(findTestObject('QuanLyKho/icon_searchClass', [('classValue') : 'fa fa-search']))

//WebUI.selectOptionByLabel(findTestObject('QuanLyKho/droplist_selectDynamicLast', [('idValue') : 'khoxuat']), 'HUONG6787-Nguyễn Thanh Hương',false)
WebUI.selectOptionByLabel(findTestObject('QuanLyKho/droplist_selectDynamicLast', [('idValue') : 'khoxuat']), 'SHOP2-Nhà thuốc Minh Lộc',false)
//WebUI.click(findTestObject('QuanLyKho/droplist_selectDynamicLast', [('idValue') : 'khoxuat']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'Dy9m6EbbTO..']), GlobalVariable.po_phieu_id)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'from_date']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'from_date']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'from_date']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsFirst', [('buttonName') : 'Chọn']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwPEbbCaTf4Ba.']), 'Trả hàng Nhà Cung Cấp')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Thông tin phiếu']))

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Danh sách hàng xuất trả nhà cung cấp']))

WebUI.delay(1)

WebUI.click(findTestObject('Common/checkbox_nameDynamicLocators', [('nameValue') : 'pcheck']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsFirst', [('buttonName') : 'Xuất trả NCC']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 10)

WebUI.delay(3)

String soPhieuID = WebUI.getText(findTestObject('QuanLyKho/get_labelDynamicLocators', [('labelValue') : 'Số phiếu']))

GlobalVariable.phieuban_id = soPhieuID

println(GlobalVariable.phieuban_id)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsFirst', [('buttonName') : 'Lưu thông tin']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ma_xuat']), GlobalVariable.phieuban_id)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-khoxuat-container']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'HUONG6787-Nguyễn Thanh Hương']))
WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP2-Nhà thuốc Minh Lộc']))

//WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-khoxuat-container']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-4yHlRaLr-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'MTV - Công ty TNHH MTV']))

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']), Keys.chord(Keys.ENTER))

String soPhieuXuat = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu xuất', 0, 'outputtbl')

String soLuongCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số lượng xuất', 0, 'outputtbl')

WebUI.verifyEqual(soPhieuXuat, GlobalVariable.phieuban_id)

WebUI.verifyEqual(soLuongCell, soLuong)

