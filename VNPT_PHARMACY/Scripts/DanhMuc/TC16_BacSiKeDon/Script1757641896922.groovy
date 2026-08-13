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

String status = 'Chưa bán'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Bác sĩ kê đơn')
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'DANH MỤC']))

WebUI.waitForElementVisible(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bác sĩ kê đơn']), 30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bác sĩ kê đơn']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

GlobalVariable.maKH = 'Auto_test01'

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'patientName']), GlobalVariable.maKH)

WebUI.delay(3)

WebUI.click(findTestObject('Common/text_pDynamicLocators', [('text') : GlobalVariable.maKH]))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN_BAC_SY_HN']), 'Nguyen Quang Tuan')

WebUI.delay(3)

WebUI.click(findTestObject('Common/text_pDynamicLocators', [('text') : 'Nguyễn Quang Tuấn']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang']), 'HUONG6787-Nguyễn Thanh Hương', 
    false)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Danh sách thuốc']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFAh6E9X3yxl6B1e43o.']), GlobalVariable.sanPham)

WebUI.delay(5)

TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_indexFirst', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

//WebUI.click(findTestObject('XuatKhoBanHang/data_indexFirst', [('value') : '0']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'instruction']), 'Uống trước ăn')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.delay(3)

String value2 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã đơn thuốc', 0, 'inputtbl')

GlobalVariable.maDonThuoc = value2

println(GlobalVariable.maDonThuoc)

String trangThai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Trạng thái', 0, 'inputtbl')

WebUI.verifyEqual(trangThai, status)

