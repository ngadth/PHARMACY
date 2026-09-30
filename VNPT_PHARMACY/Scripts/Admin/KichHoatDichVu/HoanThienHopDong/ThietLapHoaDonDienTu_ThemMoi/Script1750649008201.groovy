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
//import org.openqa.selenium.Keys

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

//WebUI.delay(5)
WebUI.click(findTestObject('Common/button_advanced'))

WebUI.click(findTestObject('Common/link_unsafe'))

WebUI.setText(findTestObject('Common/input_username'), GlobalVariable.userAdmin)

WebUI.setText(findTestObject('Common/input_password'), GlobalVariable.passAdmin)

WebUI.click(findTestObject('Common/btn_DangNhap'))

WebUI.waitForElementVisible(findTestObject('Common/logo_vnpt'), GlobalVariable.timeout)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('Kích hoạt dịch vụ', 'Hoàn thiện hợp đồng')

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Hợp đồng sử dụng dịch vụ']))

// Nhập text vào ô input
WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã hợp đồng',('index'):'1']), 'CLOUD_003635')

// Nhấn phím Enter tại ô input đó
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã hợp đồng',('index'):'1']), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.click(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/icon_more'))

WebUI.click(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/text_xuLyHopDong'))

WebUI.verifyElementVisible(findTestObject('Admin/Common/text_hDynamicLocators',[('text'):'Xử lý hợp đồng']))

WebUI.click(findTestObject('Common/text_aDynamicLocators',[('text'):'Thiết lập hóa đơn điện tử']))

WebUI.click(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/dropdown_loaiChuKySo'))

WebUI.click(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/option_textDynamicLocators',[('text'):'Sử dụng HSM']))

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'account']), 'pharmacyadmin')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'acpass']), '87654321aA@')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'username']), 'pharmacyservice')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'password']), '87654321aA@')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'p']), '1/001')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'s']), 'C23MTQ')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'serialcert']), '54010101A1CD749EF1AB7D515B739C7F')

WebUI.setText(findTestObject('Admin/KichHoatDichVu/HoanThienHopDong/input_idDynamicLocators',[('idValue'):'urlbussiness']), 'https://0105762069-033-tt78democadmin.vnpt-invoice.com.vn/BusinessService.asmx')

WebUI.click(findTestObject('Admin/Common/button_idDynamicLocators',[('idValue'):'cmdCapNhat']))

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators',[('text'):'Cập nhật thành công']), GlobalVariable.timeout)

