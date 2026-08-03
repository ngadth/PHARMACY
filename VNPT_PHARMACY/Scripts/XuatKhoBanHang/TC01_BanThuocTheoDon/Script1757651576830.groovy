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

String status = 'Đã bán'

WebUI.callTestCase(findTestCase('DanhMuc/TC16_BacSiKeDon'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bán thuốc theo đơn']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Bán thuốc theo đơn')
WebUI.click(findTestObject('XuatKhoBanHang/label_forDynamicLocators', [('idValue') : 'presc_type2']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang']), 'HUONG6787-Nguyễn Thanh Hương', 
    false)

//WebUI.waitForElementClickable(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']),30)

//WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'presc_code']), GlobalVariable.maDonThuoc)

TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Bắt đầu bán theo đơn này']))

WebUI.delay(3)

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.click(findTestObject('Common/icon_idDynamicLocators', [('idValue') : 'homepage']))

WebUI.delay(3)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'DANH MỤC']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bác sĩ kê đơn']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Bác sĩ kê đơn')

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'prescKeyword']))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'prescKeyword']), GlobalVariable.maDonThuoc)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'prescKeyword']), Keys.chord(Keys.ENTER))

WebUI.delay(3)

String value3 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã đơn thuốc', 0, 'inputtbl')

String trangThai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Trạng thái', 0, 'inputtbl')

WebUI.verifyEqual(value3, GlobalVariable.maDonThuoc)

WebUI.verifyEqual(trangThai, status)

