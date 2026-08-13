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

String columnTable = 'Nhóm hàng hóa;SL bán;Doanh thu;Giá vốn;SL trả;Tiền trả lại;Doanh thu thuần'

String date = '22/06/2025'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'BÁO CÁO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo bán hàng']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('BÁO CÁO', 'Báo cáo bán hàng')

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo Bán hàng TH']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Báo cáo Bán hàng TH']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Báo cáo Bán hàng tổng hợp theo nhóm hàng hóa']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo Bán hàng tổng hợp theo nhóm hàng hóa']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Kho hàng']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : GlobalVariable.kho]))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Nhóm hàng (tất cả)']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Theo từ khóa loại SP']), 'HAPACOL')

WebUI.click(findTestObject('Common/input_theoKhoangThoiGian'))

WebUI.setText(findTestObject('BaoCao/BaoCaoBanHang/input_date', [('date') : 'daterangepicker_start']), date)

WebUI.setText(findTestObject('BaoCao/BaoCaoBanHang/input_date', [('date') : 'daterangepicker_end']), date)

WebUI.click(findTestObject('BaoCao/BaoCaoBanHang/button_chonXong'))

WebUI.delay(2)

String[] subStr = columnTable.split(';')

for (int i = 0; i < subStr.length; i++) {
    WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators', [('text') : subStr[i]]), 10)
}

nhomHangHoa = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators', [('index') : '1']))

WebUI.verifyEqual(nhomHangHoa, 'Duoc pham')

