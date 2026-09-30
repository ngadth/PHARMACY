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

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('CÔNG NỢ', 'Phải thu khách hàng')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'CÔNG NỢ']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Phải thu khách hàng']))

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Công nợ cần thu khách hàng']), 
    5)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-kho_id-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

GlobalVariable.name_service = 'Auto_test01'

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsFirst', [('idValue') : 'CBtV6yW.']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsFirst', [('idValue') : 'CBtV6yW.']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.click(findTestObject('CongNo/table_row', [('idValue') : 'balance']))

WebUI.click(findTestObject('CongNo/button_spaceTextDynamicLocators', [('buttonName') : 'Lập phiếu thu']))

WebUI.delay(5)

String KHTra = '10'

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsFirst', [('idValue') : 'TE9k5zPu4O..']), KHTra)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngaytt']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngaytt']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngaytt']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tgtt']), '11:00')

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'tgtt']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'TFXwPyXf4yXx']), 'Ghi chú lập phiếu thu')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật số dư thành công, phiếu:']), 
    5)

khachHangTra = WebUI.getText(findTestObject('QuanLyKho/cell_2table', [('idValue') : '5']))

WebUI.verifyEqual(khachHangTra, KHTra)

