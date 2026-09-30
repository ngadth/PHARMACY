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

import java.awt.RenderingHints.Key
import java.util.concurrent.ConcurrentHashMap.KeySetView

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
String value = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), 'value')
assert value.trim() == ''

// copy paste

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), 'Mạnh Thường Quân')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), Keys.chord(Keys.CONTROL, 'A'))
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), Keys.chord(Keys.CONTROL, 'C'))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), '')
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), Keys.chord(Keys.CONTROL, 'V'))

String value1 =  WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), 'value')
assert value1.trim() == 'Mạnh Thường Quân'

// < 100
WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), 'Mạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường QuânMạnh Thường Quân')
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo khách hàng',('index'):'1']), Keys.ENTER.toString())
WebUI.verifyElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Khách hàng phải có độ dài nằm trong khoảng 0-100']))

