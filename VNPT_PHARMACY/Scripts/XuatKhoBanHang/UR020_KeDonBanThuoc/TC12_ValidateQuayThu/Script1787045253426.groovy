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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.waitForElementClickable(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']), 30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']))

WebUI.delay(2)

WebUI.delay(2)

String cuaHangvalue ='6'
// xac nhan chuyen
String value = WebUI.getAttribute(findTestObject('QuanLyKho/droplist_selectDynamicLast',[('idValue'):'cboCuaHang']),'value')
if(value.trim() == '6') {
	cuaHangvalue = '12'
}

WebUI.selectOptionByValue(findTestObject('QuanLyKho/droplist_selectDynamicLast',[('idValue') : 'cboCuaHang']),cuaHangvalue,false)
WebUI.delay(2)
WebUI.verifyTextPresent('Việc chuyển đổi cửa hàng sẽ thực hiện xóa dữ liệu các hóa đơn đang bán. Bạn có chắc chắn muốn chuyển đổi không?', false)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators',[('buttonName'):'Xác nhận chuyển']))

WebUI.delay(2)

String value1 = WebUI.getAttribute(findTestObject('QuanLyKho/droplist_selectDynamicLast',[('idValue'):'cboCuaHang']),'value')

assert value1.trim() == cuaHangvalue

if(value1.trim()!= '6') {
	WebUI.selectOptionByValue(findTestObject('QuanLyKho/droplist_selectDynamicLast',[('idValue') : 'cboCuaHang']),'6',false)
	WebUI.delay(2)
	WebUI.verifyTextPresent('Việc chuyển đổi cửa hàng sẽ thực hiện xóa dữ liệu các hóa đơn đang bán. Bạn có chắc chắn muốn chuyển đổi không?', false)
	
	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators',[('buttonName'):'Xác nhận chuyển']))
}