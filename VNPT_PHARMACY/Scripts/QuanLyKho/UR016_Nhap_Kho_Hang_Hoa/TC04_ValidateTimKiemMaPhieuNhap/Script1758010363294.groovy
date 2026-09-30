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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập kho']))

TestObject maPhieuInput = findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập'])

String invalidInput = 'ABC123'
WebUI.clearText(maPhieuInput)
WebUI.sendKeys(maPhieuInput, invalidInput)
WebUI.sendKeys(maPhieuInput, Keys.chord(Keys.ENTER))
WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Phiếu nhập ID không đúng kiểu số']), 5)
WebUI.delay(3)

String overLengthInput = '12345678901'
WebUI.clearText(maPhieuInput)
WebUI.sendKeys(maPhieuInput, overLengthInput)
WebUI.sendKeys(maPhieuInput, Keys.chord(Keys.ENTER))
WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Phiếu nhập ID phải có độ dài nằm trong khoảng 0-10']), 5)
WebUI.delay(3)

WebUI.clearText(maPhieuInput)
WebUI.sendKeys(maPhieuInput, Keys.chord(Keys.ENTER))

WebUI.verifyElementNotPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu']), 5)

String firstReceiptId = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')
WebUI.verifyNotEqual(firstReceiptId, '', FailureHandling.STOP_ON_FAILURE)