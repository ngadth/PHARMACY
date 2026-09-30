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
import com.kms.katalon.core.testobject.TestObject
import com.katalon.webui.keyword.action.image.WebUIAbstractImageActionKeyword
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

//mac dinh
String value = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'phuongtienvanchuyen']),'value')

assert value.trim() == ''

// khong bat buoc
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Common/label_Required',[('fieldName'):'Phương tiện V/C']), 3)

// hien thi danh sach

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-khoxuat-container']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'HUONG6787-Nguyễn Thanh Hương']))
WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP2-Nhà thuốc Minh Lộc']))
WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-khonhan-container']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'CH01-Của hàng 01']))
WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'CH123-Cửa hàng thuốc Hương']))
WebUI.clearText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'thukhoxuat']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'thukhoxuat']), 'admin_huong6787')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'nguoinhan']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'nguoinhan']), 'Shop5')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'diachinhanhang']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'diachinhanhang']), 'Đà nẵng')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'diengiai']), 'Xuất kho bán hàng')

WebUI.click(findTestObject('Common/checkbox_nameDynamicLocators', [('nameValue') : 'IytX4O..']))

WebUI.acceptAlert()

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'phuongtienvanchuyen']), 'Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Có lỗi trong quá trình cập nhật. Quý khách vui lòng thử lại sau!']), 3)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'phuongtienvanchuyen']), 'ABC-234')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'phuongtienvanchuyen']), '<script>alert(document.cookie)</script>')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 10)
