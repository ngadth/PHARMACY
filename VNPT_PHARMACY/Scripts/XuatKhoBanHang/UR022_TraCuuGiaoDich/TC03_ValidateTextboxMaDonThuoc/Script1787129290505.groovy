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
//WebUI.callTestCase(findTestCase('XuatKhoBanHang/TC01_BanThuocTheoDon'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Tra cứu giao dịch')
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Tra cứu giao dịch']))

WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Tra cứu giao dịch bán hàng']), 3)

//WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '5F5ZDA9f5o..']), 'HUONG6787-Nguyễn Thanh Hương', false)
// mac dinh
String value = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), 'value')
assert value.trim() == ''

// copy paste
WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), '112')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), '')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), Keys.chord(Keys.CONTROL, 'V'))
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), Keys.ENTER.toString())

String value1 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), 'value')
assert value1.trim() == '112'

//// < 12
//WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), 'cảm xuyên hươngcảm xuyên hươngcảm xuyên hươngcảm xuyên hươngcảm xuyên ')
//
//WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), Keys.ENTER.toString())
//
//String value1 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Mã đơn thuốc', ('index'):'2']), 'value')
//assert value1.trim().size() <= 11
