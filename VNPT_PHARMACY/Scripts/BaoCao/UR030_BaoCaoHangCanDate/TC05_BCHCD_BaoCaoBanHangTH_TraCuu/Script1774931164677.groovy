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

String columnTable = 'Nhóm hàng hoá;Mã hàng;Tên hàng;Đơn vị tính;Số lượng;Thành tiền;Số lượng trả;Tổng tiền trả lại;Doanh thu;Khuyến mại;Giá vốn;Lợi nhuận'

//String date = ('29/05/2023' + ' - ') + '29/05/2023'

//String loaiSanPham = 'Penaciline'
String loaiSanPham = 'Harcotin'
WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_baoCao'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo hàng cận đát']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo hàng đã hết hạn và sắp hết hạn sử dụng']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Lựa chọn Kho']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'SHOP2-Nhà thuốc Minh Lộc']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Lựa chọn nhóm SP']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'thuốc biệt dược']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-loaibc-container']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Báo cáo Bán hàng TH']))

WebUI.delay(2)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = ('29/05/2023' + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), Keys.chord(Keys.ENTER))

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbo_httt_id']), 'Tiền mặt',false)

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP', ('index'):'1']), loaiSanPham)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP', ('index'):'1']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String[] subStr = columnTable.split(';')

for (int i = 0; i < subStr.length; i++) {
    WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators', [('text') : subStr[i]]), 10)
}

loaiSP = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators', [('index') : '3']))

WebUI.verifyEqual(loaiSP, loaiSanPham)

