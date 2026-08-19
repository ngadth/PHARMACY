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

WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.waitForElementClickable(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']), 30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Tìm mặt hàng (F3)', ('index'):'1']),'Akiaphan')

WebUI.delay(2)

TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

BigDecimal slTon = new BigDecimal(WebUI.getText(findTestObject('XuatKhoBanHang/td_tonKho')).trim())

WebUI.selectOptionByLabel(findTestObject('XuatKhoBanHang/select_expDates'),'Lô SX: 113 - NHH: 30/03/2027',false)

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']), GlobalVariable.timeout)

WebUI.delay(2)

WebUI.refresh()

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Tìm mặt hàng (F3)', ('index'):'1']),'Akiaphan')

WebUI.delay(2)

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject2 = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject2, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject2)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.selectOptionByLabel(findTestObject('XuatKhoBanHang/select_expDates'),'Lô SX: 113 - NHH: 30/03/2027',false)

BigDecimal slTon2 = new BigDecimal(WebUI.getText(findTestObject('XuatKhoBanHang/td_tonKho')).trim())

assert slTon2 == slTon - 1