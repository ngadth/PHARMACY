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

String date = '13/08/2024'

String dirName = RunConfiguration.getProjectDir()

String downloadPath = dirName + '\\Data Files' // Thư mục tải file

String pathFileDownload = downloadPath.replaceAll('/', '\\\\')

String startName = 'BAOCAOBANTHUOCTHEODON'

String endName = '.xls'

//// Cấu hình Chrome Options để tải file mà không hiển thị popups
Map<String, Object> prefs = new HashMap()

prefs.put('download.default_directory', pathFileDownload)

prefs.put('download.prompt_for_download', false)

prefs.put('profile.default_content_settings.popups', 0)

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('prefs', prefs)

// Khởi tạo ChromeDriver thủ công với cấu hình
ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

// Gán driver cho Katalon
WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

//WebUI.delay(5)
WebUI.click(findTestObject('Common/button_advanced'))

WebUI.click(findTestObject('Common/link_unsafe'))

WebUI.setText(findTestObject('Common/input_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Common/input_password'), GlobalVariable.password)

WebUI.click(findTestObject('Common/btn_DangNhap'))

WebUI.waitForElementVisible(findTestObject('Common/logo_vnpt'), GlobalVariable.timeout)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'BÁO CÁO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo GPP']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo bán thuốc theo đơn']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Lựa chọn Kho']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):GlobalVariable.kho]))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Lựa chọn nhóm SP']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'Duoc pham']))

WebUI.setText(findTestObject('BaoCao/BaoCaoGPP/input_theoTuKhoaLoaiSP'), 'ong tiem 5 ml')

WebUI.click(findTestObject('Common/input_theoKhoangThoiGian'))

WebUI.setText(findTestObject('Common/input_date',[('date'):'daterangepicker_start']), date)

WebUI.setText(findTestObject('Common/input_date',[('date'):'daterangepicker_end']), date)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators',[('buttonName'):'Chọn xong']))

//Xóa file
CustomKeywords.'libKeyWords.PageObject.deleteFilesWithPrefixStartEnd'(pathFileDownload, startName, endName)

// Tải file
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xuất Excel']))

WebUI.delay(10)

// Kiểm tra file đã được tải về
CustomKeywords.'libKeyWords.PageObject.checkFileDownloadedStartEnd'(pathFileDownload, startName, endName)

