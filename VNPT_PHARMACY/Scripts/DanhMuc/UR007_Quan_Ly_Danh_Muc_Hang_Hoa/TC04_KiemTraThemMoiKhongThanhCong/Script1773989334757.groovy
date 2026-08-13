import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.util.regex.Pattern as Pattern

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Hàng hóa']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Thêm mới thuốc ']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm hàng hóa']), 5)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-unit-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Viên')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Viên']))

String tenHH = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('TenHHAuto_' + tenHH)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'name']), GlobalVariable.maKH)

String tenVT = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('TenVTAuto_' + tenVT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'short_name']), GlobalVariable.name_service)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-pg_id-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'sp']), '5000')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'bp']), '4000')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'waranty_month']), '12')

String sdk = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.order_id = ('DK_' + sdk)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'specification']), GlobalVariable.order_id)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Hủy']))

WebUI.verifyElementNotPresent(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 5)

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Hàng hóa']), 5)

String tenLoaiHang = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên loại hàng', 0, 'product')
WebUI.verifyNotEqual(tenLoaiHang, GlobalVariable.maKH)

WebUI.delay(2)