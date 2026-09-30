import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Khách hàng')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mst = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mst)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), 'Đà Nẵng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/text_pDynamicLocators', [('text') : 'Tên khách hàng là trường bắt buộc']), 5)