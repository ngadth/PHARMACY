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

WebUI.delay(3)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('CÔNG NỢ', 'Lịch sử giao dịch với khách hàng')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'CÔNG NỢ']))

WebUI.waitForElementVisible(findTestObject('Common/menu_aDynamicLocators',[('text') : 'Lịch sử giao dịch với khách hàng']),30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Lịch sử giao dịch với khách hàng']))

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Tra cứu giao dịch của khách hàng']), 
    10)

// mac dinh
String value = WebUI.executeJavaScript("return document.querySelector('#khoxuat option:checked').textContent", null)
assert value.trim() != ''
// chu cai dau

WebUI.click(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']))
WebUI.sendKeys(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'a')
WebUI.sendKeys(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), Keys.ENTER.toString())
String value1 = WebUI.executeJavaScript("return document.querySelector('#khoxuat option:checked').textContent", null)
assert value1.toLowerCase().startsWith('a')

