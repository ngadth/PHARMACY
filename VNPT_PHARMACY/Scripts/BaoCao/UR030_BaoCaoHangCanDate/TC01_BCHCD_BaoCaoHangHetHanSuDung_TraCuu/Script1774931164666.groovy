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

String columnTable = 'Tên sản phẩm;Ngày hết hạn;Lô SX;Ngày còn lại;Số lượng;Giá vốn;Số lượng bán/ngày;Số lượng bán/tuần;Số lượng bán/tháng'

//String tenSanPham = 'Paracetamol'
String tenSanPham =  'BIOCALCIUM'
WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_baoCao'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo hàng cận đát']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo hàng đã hết hạn và sắp hết hạn sử dụng']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Lựa chọn Kho']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'CH01-Của hàng 01']))
WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'SHOP2-Nhà thuốc Minh Lộc']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Lựa chọn nhóm SP']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))
WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'thuốc biệt dược']))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP',('index'):'1']), tenSanPham)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-loaibc-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Báo cáo hàng hết hạn sử dụng']))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'expire_range']), 'Hạn SD còn <= 6 tháng',false)

WebUI.delay(2)

String[] subStr = columnTable.split(';')

for (int i = 0; i < subStr.length; i++) {
    WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators', [('text') : subStr[i]]), 10)
}

value = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators', [('index') : '1']))

String input = value
String[] parts = input.split("\\)")
String tenSP = parts[1].trim().split("\\(")[0].trim()
println(tenSP) 

WebUI.verifyEqual(tenSP, tenSanPham)

