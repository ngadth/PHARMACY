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

// ngay ban > hien tai
WebUI.setText(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),'25/08/2067 - 27/08/2067')

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']), Keys.ENTER.toString())

WebUI.assertElementVisible(findTestObject('Common/text_tdDynamicLocators',[('text'):'Không có dữ liệu...']), 3)

// tu khoa sp ko ton tai
WebUI.refresh()

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP',('index'):'1']), 'Mạnh Thường Quân')

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Theo từ khóa loại SP',('index'):'1']), Keys.ENTER.toString())

WebUI.assertElementVisible(findTestObject('Common/text_tdDynamicLocators',[('text'):'Không có dữ liệu...']), 3)

//nhom san pham chua ban duoc san pham
WebUI.refresh()

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Nhóm hàng (tất cả)']))

WebUI.setText(findTestObject('Common/input_search'),'nhóm giảm đau')

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'nhóm giảm đau']))

WebUI.assertElementVisible(findTestObject('Common/text_tdDynamicLocators',[('text'):'Không có dữ liệu...']), 3)

//cua hang chua ban duoc san pham
WebUI.refresh()

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Kho hàng']))

WebUI.setText(findTestObject('Common/input_search'),'SHOP3-VNPT Bà Rịa Vũng Tàu')

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'SHOP3-VNPT Bà Rịa Vũng Tàu']))

WebUI.assertElementVisible(findTestObject('Common/text_tdDynamicLocators',[('text'):'Không có dữ liệu...']), 3)
