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

WebUI.delay(3)

WebUI.selectOptionByIndex(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang']), '0', FailureHandling.STOP_ON_FAILURE)

if (WebUI.waitForElementVisible(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']),
	10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']))

	println('Đã click nút Xác nhận chuyển')
} else {
	println('Không có nút Xác nhận chuyển → bỏ qua')
}

WebUI.sendKeys(findTestObject('Object Repository/Common/input_placeholderDynamicLocators', [('text') : 'Tìm mặt hàng (F3)', ('index') : '1']), 'Acemuc')

WebUI.delay(2)

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.sendKeys(findTestObject('Object Repository/Common/input_placeholderDynamicLocators', [('text') : 'Tìm khách hàng (F4)', ('index') : '2']), 'Auto_test01')

WebUI.click(findTestObject('Common/text_divDynamicLocators', [('text') : 'Auto_test01']))

WebUI.sendKeys(findTestObject('Object Repository/Common/input_tdTextDynamicLocators', [('text') : 'Tổng khuyến mại', ('index') : '2']), '9999')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_khachThanhToan'))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_khachThanhToan'), '500,000')

//mac dinh
String value = WebUI.getAttribute(findTestObject('QuanLyKho/textarea_GhiChu'), 'value')
assert value.trim() == ''

String ghiChu = '$#%@#$gvsdf435\n $#%@#$gvsdf435\n $#%@#$gvsdf435\n'

WebUI.setText(findTestObject('QuanLyKho/textarea_GhiChu'), ghiChu)

WebUI.sendKeys(findTestObject('QuanLyKho/textarea_GhiChu'), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('QuanLyKho/textarea_GhiChu'), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('QuanLyKho/textarea_GhiChu'), '')

WebUI.sendKeys(findTestObject('QuanLyKho/textarea_GhiChu'), Keys.chord(Keys.CONTROL, 'V'))

String value1 = WebUI.getAttribute(findTestObject('QuanLyKho/textarea_GhiChu'), 'value')
assert value1 == ghiChu

WebUI.setText(findTestObject('QuanLyKho/textarea_GhiChu'), '<script>alert(document.cookie)</script>')

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']), 20)
