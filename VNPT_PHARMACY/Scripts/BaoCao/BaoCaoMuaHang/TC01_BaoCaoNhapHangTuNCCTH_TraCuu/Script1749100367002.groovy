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

String columnTable 	= "Nhà cung cấp;Kho;Phiếu nhập;Ngày nhập;Người nhập;Diễn giải;Tổng sản phẩm;Tiền hàng";
String date			='29/05/2023'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)
WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

WebUI.click(findTestObject('Common/menu_baoCao'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo mua hàng']))

WebUI.delay(2)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('BÁO CÁO', 'Báo cáo mua hàng')
WebUI.waitForElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Báo cáo nhập hàng từ Nhà cung cấp TH']),10)

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Báo cáo nhập hàng từ Nhà cung cấp TH']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Lựa chọn Kho']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'CH01-Của hàng 01']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Lựa chọn NCC']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'HUONG6787 - Nguyễn Thanh Hương']))

WebUI.click(findTestObject('Common/input_theoKhoangThoiGian'))

WebUI.setText(findTestObject('Common/input_date',[('date'):'daterangepicker_start']), date)

WebUI.setText(findTestObject('Common/input_date',[('date'):'daterangepicker_end']), date)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators',[('buttonName'):'Chọn xong']))

WebUI.delay(2)

String[] subStr = columnTable.split(';');
for (int i = 0; i < subStr.length; i++){
	WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators',[('text'):subStr[i]]), 10)
	}

dateSearch=WebUI.getText(findTestObject('Common/cell_tdDynamicLocators',[('index'):'4']))

WebUI.verifyEqual(dateSearch, date)

