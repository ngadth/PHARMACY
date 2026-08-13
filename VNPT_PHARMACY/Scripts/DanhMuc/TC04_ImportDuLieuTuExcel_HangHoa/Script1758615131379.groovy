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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.util.regex.Pattern as Pattern

String MaLH = '000055'

String tenLH = 'Paracetamol'

String projectDir = RunConfiguration.getProjectDir()

String filePath = projectDir + '/Data Files/pharmacy_import_danhmuc.xls'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Hàng hóa']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Import']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Nhập hàng hóa từ file dữ liệu']), 
    5)

WebUI.verifyElementChecked(findTestObject('CongNo/radio_idDynamicLocators', [('idValue') : 'rdo_dm_ngoai']), 3)

WebUI.uploadFile(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'fileUpload_impdm']), filePath)

WebUI.delay(2)

WebUI.click(findTestObject('DanhMuc/button_aIDDynamicLocatorsLast', [('idValue') : 'cmdSave']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Import']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Import dữ liệu thành công!']), 10)

WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Nhập hàng hóa từ file dữ liệu']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'rdTK']), 'Danh mục', false)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-5zHlT3pVDFHl5FAZTo-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'CBtVCFLm']), '000055')

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'CBtVCFLm']), Keys.chord(Keys.ENTER))

String maLoaiHang = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã loại hàng', 0, 'product')

String tenLoaiHang = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên loại hàng', 0, 'product')

WebUI.verifyEqual(maLoaiHang, MaLH)

WebUI.verifyEqual(tenLoaiHang, tenLH)

