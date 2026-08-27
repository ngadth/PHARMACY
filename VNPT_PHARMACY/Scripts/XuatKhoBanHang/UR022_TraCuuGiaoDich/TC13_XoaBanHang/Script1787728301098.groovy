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

//String status = 'Chưa đồng bộ'
String status = 'Chưa LT'
//WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('XuatKhoBanHang/TC01_BanThuocTheoDon'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Tra cứu giao dịch')
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Tra cứu giao dịch']))

WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Tra cứu giao dịch bán hàng']), 
    3)

//WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '5F5ZDA9f5o..']), 'HUONG6787-Nguyễn Thanh Hương', false)
WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '5F5ZDA9f5o..']), 'SHOP2-Nhà thuốc Minh Lộc', false)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CBtaCy1w6FAl4m..']), GlobalVariable.maDonThuoc)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CBtaCy1w6FAl4m..']), Keys.chord(Keys.ENTER))

WebUI.delay(5)

String value4 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã đơn thuốc', 0, 'table_phieu')

println(value4)

String tenKH = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên khách hàng', 0, 'table_phieu')

println(tenKH)

String nguoiBan = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Người bán', 0, 'table_phieu')

println(nguoiBan)

String trangThai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Trạng thái liên thông DQG', 0, 'table_phieu')

println(trangThai)

WebUI.verifyEqual(value4, GlobalVariable.maDonThuoc)

WebUI.verifyEqual(tenKH, GlobalVariable.maKH)

WebUI.verifyEqual(nguoiBan, GlobalVariable.userAdmin)

WebUI.verifyEqual(trangThai, status)

WebUI.executeJavaScript("jQuery(document.evaluate(\"(//a[contains(@class,'dropdown-toggle') and @data-hover='dropdown'])[2]\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).dropdown('toggle')", null)

WebUI.delay(2)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.delay(2)

WebUI.acceptAlert()

WebUI.delay(2)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CBtaCy1w6FAl4m..']), GlobalVariable.maDonThuoc)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CBtaCy1w6FAl4m..']), Keys.chord(Keys.ENTER))

WebUI.verifyTextPresent('Không có dữ liệu phù hợp thông tin tra cứu.', false)

