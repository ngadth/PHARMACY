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

WebUI.delay(3)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

// mac dinh
String value = WebUI.getAttribute(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']),'value')

assert value.trim() == ''

// truong khong bat buoc
WebUI.assertElementNotPresent(findTestObject('Common/label_Required',[('fieldName'):'Mã số thuế']), 3)

// ky tu chu
WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Tên KH', ('index') : '2']),'trịnh trần phương tuấn')

WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Địa chỉ', ('index') : '5']),'bến tre')

WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']),'dsga')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Mã số thuế không đúng kiểu số']), 3)

// html
WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']),'<script>alert(document.cookie)</script>')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Mã số thuế không đúng kiểu số']), 3)

// copy paste
String soDidong = CustomKeywords.'libKeyWords.PageObject.getCurrentDateTime'()

WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']), '0'+soDidong)

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']), '')

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Mã số thuế', ('index') : '2']), Keys.chord(Keys.CONTROL, 'V'))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))

WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 3)