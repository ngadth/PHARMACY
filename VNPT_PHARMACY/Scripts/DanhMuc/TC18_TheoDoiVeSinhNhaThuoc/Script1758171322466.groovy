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

WebUI.delay(5)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Theo dõi vệ sinh nhà thuốc')

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'DANH MỤC']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Theo dõi vệ sinh nhà thuốc']))

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Quản lý vệ sinh nhà thuốc']), 
    10)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm mới vệ sinh nhà thuốc']), 
    5)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngaythuchien_add']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngaythuchien_add']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngaythuchien_add']), Keys.chord(Keys.ENTER))

String tenThucHien = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('tenTTAuto_' + tenThucHien)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'nguoithuchien_add']), GlobalVariable.maKH)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang_add']), 'HUONG6787-Nguyễn Thanh Hương', 
    false)

WebUI.click(findTestObject('Common/checkbox_nameDynamicLocators', [('nameValue') : 'pcheck']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang_tk']), 'HUONG6787-Nguyễn Thanh Hương', 
    false)

String nguoiTH = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Người thực hiện', 0, 'product_vsqt')

String ngayThucHien = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày thực hiện', 0, 'product_vsqt')

WebUI.verifyEqual(nguoiTH, GlobalVariable.maKH)

WebUI.verifyEqual(ngayThucHien, currentDate)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Cập nhật dữ liệu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Cập nhật vệ sinh nhà thuốc']), 
    5)

String tenUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('tenUDAuto_' + tenUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'nguoithuchien_edit']), GlobalVariable.maKH)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.delay(5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang_tk']), 'HUONG6787-Nguyễn Thanh Hương', 
    false)

String nguoiTHUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Người thực hiện', 0, 'product_vsqt')

String ngayUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày thực hiện', 0, 'product_vsqt')

WebUI.verifyEqual(nguoiTHUD, GlobalVariable.maKH)

WebUI.verifyEqual(ngayUD, currentDate)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa vệ sinh nhà thuốc']), 
    3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

