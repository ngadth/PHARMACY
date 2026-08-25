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

WebUI.delay(2)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Bán hàng đã nhập kho')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bán hàng đã nhập kho']))

WebUI.delay(2)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

// mac dinh
String value = WebUI.getAttribute(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'value')

assert value.trim() == ''

// truong bat buoc
WebUI.assertElementVisible(findTestObject('Common/label_Required',[('fieldName'):'Tên KH']), 3)

// tieng viet co dau
WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'trịnh trần phương tuấn')

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 3)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators',[('text'):'Xóa khách hàng']))

// ki tu dac biet
WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'@#$')

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 3)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators',[('text'):'Xóa khách hàng']))

// chu so
WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'123456789')

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 3)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators',[('text'):'Xóa khách hàng']))

// copy paste
WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), 'trịnh trân phương tuấn')

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), '')

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), Keys.chord(Keys.CONTROL, 'V'))

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 3)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators',[('text'):'Xóa khách hàng']))

//<html>
WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), '<script>alert(document.cookie)</script>')

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Vui lòng nhập tên không chứa thẻ html!']), 3)

// <50 | <300
WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']), 'Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5Shop5')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Có lỗi xảy ra. Vui lòng thực hiện lại!']), 3)

