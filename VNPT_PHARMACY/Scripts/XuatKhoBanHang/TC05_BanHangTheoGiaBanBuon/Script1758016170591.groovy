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

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Bán hàng theo giá bán buôn')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bán hàng theo giá bán buôn']))

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFAh6E9X']), '002929')

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(dynamicObject)

    println('Đã click element có value = 0')
} else {
    println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.delay(2)

GlobalVariable.maKH = 'Auto_test01'

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'makh']), GlobalVariable.maKH)

WebUI.click(findTestObject('Common/titlePage_bDynamicLocators', [('text') : GlobalVariable.maKH]))

WebUI.click(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'TE9k5x9hCO..']))

WebUI.delay(2)

WebUI.clearText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'TE9k5x9hCO..']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'TE9k5x9hCO..']), '5000')

WebUI.click(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'TE9k5zPu4O..']))

WebUI.clearText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'TE9k5zPu4O..']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'TE9k5zPu4O..']), '10000')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'TFXwPyXf4yXx']), 'Bán Buôn Nước Aquafina')

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']), 
    10)

soPhieu = WebUI.getText(findTestObject('XuatKhoBanHang/get_bSoPhieu'))

WebUI.click(findTestObject('Common/icon_idDynamicLocators', [('idValue') : 'homepage']))

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Tra cứu giao dịch')

WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Tra cứu giao dịch bán hàng']), 
    3)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'DEXf53AY4B1V6BO.']), soPhieu)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CBtaCy1w6FAl4m..']), Keys.chord(Keys.ENTER))

WebUI.delay(3)

String soPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu', 0, 'table_phieu')

WebUI.verifyEqual(soPhieuCell, soPhieu)

