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

String columnTable 	= "Nhóm hàng hoá;Mã hàng;Tên hàng;Đơn vị tính;Số lượng;Thành tiền;Số lượng trả;Tổng tiền trả lại;Doanh thu;Khuyến mại;Giá vốn;Lợi nhuận";
//String date			='19/06/2025'
String date			='08/09/2026'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('BÁO CÁO', 'Báo cáo bán hàng')

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Kho hàng']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'CH01-Của hàng 01']))
WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'SHOP2-Nhà thuốc Minh Lộc']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Nhóm hàng (tất cả)']))

WebUI.setText(findTestObject('Common/input_search'), 'thuoc')

WebUI.delay(0.5)

//WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'thuoc']))
WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'thuốc biệt dược']))

//WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP']), 'Bom tiem')
WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP',('index'):'1']), 'LEANPROTHYROLID')

WebUI.click(findTestObject('Common/input_theoKhoangThoiGian'))

WebUI.setText(findTestObject('BaoCao/BaoCaoBanHang/input_date',[('date'):'daterangepicker_start']), date)

WebUI.setText(findTestObject('BaoCao/BaoCaoBanHang/input_date',[('date'):'daterangepicker_end']), currentDate)

WebUI.click(findTestObject('BaoCao/BaoCaoBanHang/button_chonXong'))

WebUI.click(findTestObject('BaoCao/BaoCaoBanHang/dropdown_hinhThucThanhToan'))

WebUI.click(findTestObject('BaoCao/BaoCaoBanHang/option_tienMat'))

WebUI.delay(2)

String[] subStr = columnTable.split(';');
for (int i = 0; i < subStr.length; i++){
	WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators',[('text'):subStr[i]]), 10)
	}

nhomHangHoa=WebUI.getText(findTestObject('Common/cell_tdDynamicLocators',[('index'):'1']))

WebUI.verifyEqual(nhomHangHoa, 'thuốc biệt dược')

