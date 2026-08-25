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

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Xuất kho']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Xuất kho')
WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Quản lý xuất kho']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm phiếu xuất kho']), 5)

WebUI.clearText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'nguoinhan']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'nguoinhan']), 'Shop5')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'diachinhanhang']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'diachinhanhang']), 'Đà nẵng')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'diengiai']), 'Xuất kho bán hàng')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 10)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu xuất kho']), 5)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'TFAh6E9X3yxl6B1e43o.']), 'MA341')

TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_indexFirst', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.delay(2)


WebUI.click(findTestObject('QuanLyKho/select_phieuNhap'))

WebUI.click(findTestObject('QuanLyKho/select_phieuNhapLast'))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tableDynamicLocators'), '1')

WebUI.delay(5)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Xuất kho']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 10)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu thông tin phiếu']))

//WebUI.acceptAlert()
WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lưu thông tin phiếu thành công!']), 10)

String soPhieuXuat = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu xuất', 0, 'outputtbl')

GlobalVariable.soPhieuXuat = soPhieuXuat