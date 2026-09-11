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

String columnTable = 'Tên thuốc;Số đăng ký;Đơn vị tính;Số tồn'

String tenThuoc1 = 'Amlorus'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_baoCao'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo tồn kho tổng chuỗi']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo tồn kho tổng chuỗi']))

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-CcXX4zAk5yLXDt9f5o-container']))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

//WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Lựa chọn nhóm HH']))

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'CE9X63Lm3zPbCW..']), tenThuoc1)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'CE9X63Lm3zPbCW..']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String[] subStr = columnTable.split(';')

for (int i = 0; i < subStr.length; i++) {
    WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators', [('text') : subStr[i]]), 10)
}

String thuoc = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators', [('index') : '1']))

String tenThuoc = thuoc.split("-")[1].trim()
println(tenThuoc)  

WebUI.verifyEqual(tenThuoc, tenThuoc1)

