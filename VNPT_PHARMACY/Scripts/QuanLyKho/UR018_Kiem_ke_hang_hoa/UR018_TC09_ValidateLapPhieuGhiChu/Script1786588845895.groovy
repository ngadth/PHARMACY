import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.katalon.webui.keyword.assertion.AssertElementAttributeValueKeyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Kiểm kê hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Kiểm kê hàng hóa']), 3)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu kiểm kê']), 5)

//mac dinh
String value = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')

assert value.trim() == ''

//chu va so

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'ABC-234')

String value1 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')

assert value1.trim() == 'ABC-234'

//html

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), '<script>alert(document.cookie)</script>')

String value2 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')

assert value2.trim() == '<script>alert(document.cookie)</script>'

// ky tu dac biet

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), '# "-,/"')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.assertElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Có lỗi xảy ra, bạn vui lòng thử lại!']), 5)

////<21
//
//WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'AGASD-4564562-q52-GSDGSDGFSDF')
//
//String value3 = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), 'value')
//
//assert value3.trim().size() <= 20
