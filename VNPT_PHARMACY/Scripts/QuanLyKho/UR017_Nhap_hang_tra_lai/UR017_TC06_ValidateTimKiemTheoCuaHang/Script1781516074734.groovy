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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Test Cases/QuanLyKho/UR017_Nhap_hang_tra_lai/UR017_TC01_NhapHangTraLai'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập hàng trả lại']))

WebUI.clearText(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-4yHlRcTxCybM6Etm-container']))

TestObject firstCuaHangOption = new TestObject('firstCuaHangOption')

firstCuaHangOption.addProperty('xpath', ConditionType.EQUALS, "(//ul[contains(@class,'select2-results__options')]//li[contains(@class,'select2-results__option') and not(contains(@class,'select2-results__message'))])[1]")

WebUI.click(firstCuaHangOption)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), Keys.chord(Keys.ENTER))

WebUI.verifyElementNotPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu']), 5)

String maPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')

WebUI.verifyNotEqual(maPhieuCell, '', FailureHandling.STOP_ON_FAILURE)
