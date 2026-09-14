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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.nio.file.*
import org.openqa.selenium.WebElement

String columnTable 	= "Nhóm hàng hoá;Mã hàng;Tên hàng;Đơn vị tính;Số lượng;Thành tiền;Số lượng trả;Tổng tiền trả lại;Doanh thu;Khuyến mại;Giá vốn;Lợi nhuận";
//String date			='19/06/2025'
String date			='08/09/2026'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('BÁO CÁO', 'Báo cáo bán hàng')

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

// mac dinh
String value = WebUI.getText(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

assert value == 'Báo cáo Bán hàng TH'

// hien thi danh sach chu cai dau
WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

WebUI.setText(findTestObject('Common/input_search'),'k')

List<WebElement> lst = WebUI.findWebElements(findTestObject('QuanLyKho/ul_selectOptions'), 3)

for (WebElement e : lst) {
	assert e.getText().toLowerCase().contains('k')
}