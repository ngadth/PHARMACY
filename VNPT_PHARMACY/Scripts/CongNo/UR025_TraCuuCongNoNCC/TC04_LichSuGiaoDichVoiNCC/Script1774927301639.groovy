import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

GlobalVariable.maDonHang = '1KDA001'

//WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CongNo/UR026_CapNhatCongNoNCC/TC05_PhaiTraNoNhaCungCap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('CÔNG NỢ', 'Lịch sử giao dịch với NCC')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'CÔNG NỢ']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Lịch sử giao dịch với NCC']))

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Tra cứu giao dịch với nhà cung cấp']), 
    5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'SHOP6-CH 6', 
    false)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), GlobalVariable.maDonHang)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '6yXX4yXe4B1d']), '1122')

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '6yXX4yXe4B1d']), GlobalVariable.name_service)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : '6yXX4yXe4B1d']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String valueKt = WebUI.getText(findTestObject('QuanLyKho/cell_table', [('idValue') : '7']))

int number = Integer.parseInt(valueKt)

int cHKT = Math.abs(number)

println(cHKT)

WebUI.verifyEqual(cHKT, GlobalVariable.soHDDT)