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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Common/dropdown_account'))

WebUI.click(findTestObject('Common/option_aDynamicLocators',[('optionName'):'Hướng dẫn sử dụng']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Hướng dẫn sử dụng bán lẻ']))

WebUI.verifyElementPresent(findTestObject('Common/menu_aDynamicLocators',[('text'):'Quản trị hệ thống']), 5)

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Khai báo các dữ liệu danh mục']))

WebUI.getText(findTestObject('Common/title')).contains('Khai báo các dữ liệu danh mục')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Quản lý kho']))

WebUI.getText(findTestObject('Common/title')).contains('Quản lý kho')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Xuất kho/Bán hàng']))

WebUI.getText(findTestObject('Common/title')).contains('Xuất kho/Bán hàng')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Tra cứu Công nợ']))

WebUI.getText(findTestObject('Common/title')).contains('Tra cứu Công nợ')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Hệ thống các Báo cáo quản trị']))

WebUI.getText(findTestObject('Common/title')).contains('Hệ thống các Báo cáo quản trị')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Chức năng Quản lý sổ Quỹ']))

WebUI.getText(findTestObject('Common/title')).contains('Chức năng Quản lý sổ Quỹ')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Hướng dẫn liên thông DQG thủ công']))

WebUI.getText(findTestObject('Common/title')).contains('Hướng dẫn liên thông DQG thủ công')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Hóa đơn điện tử máy tính tiền']))

WebUI.getText(findTestObject('Common/title')).contains('Hóa đơn điện tử máy tính tiền')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Thông báo']))

WebUI.getText(findTestObject('Common/title')).contains('Thông báo')

WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text'):'Hướng dẫn sử dụng bán buôn']))

WebUI.verifyElementPresent(findTestObject('Common/menu_aDynamicLocators',[('text'):'Quản trị hệ thống']), 5)

WebUI.click(findTestObject('Common/menu_aDynamicLocators2',[('text'):'Khai báo các dữ liệu danh mục']))

WebUI.getText(findTestObject('Common/title')).contains('Khai báo các dữ liệu danh mục')

WebUI.click(findTestObject('Common/menu_aDynamicLocators2',[('text'):'Quản lý kho']))

WebUI.getText(findTestObject('Common/title')).contains('Quản lý kho')

WebUI.click(findTestObject('Common/menu_aDynamicLocators2',[('text'):'Xuất kho/Bán hàng']))

WebUI.getText(findTestObject('Common/title')).contains('Xuất kho/Bán hàng')

WebUI.click(findTestObject('Common/menu_aDynamicLocators2',[('text'):'Tra cứu Công nợ']))

WebUI.getText(findTestObject('Common/title')).contains('Tra cứu Công nợ')

WebUI.click(findTestObject('Common/menu_aDynamicLocators2',[('text'):'Hệ thống các Báo cáo quản trị']))

WebUI.getText(findTestObject('Common/title')).contains('Hệ thống các Báo cáo quản trị')

WebUI.click(findTestObject('Common/menu_aDynamicLocators2',[('text'):'Chức năng Quản lý sổ Quỹ']))

WebUI.getText(findTestObject('Common/title')).contains('Chức năng Quản lý sổ Quỹ')