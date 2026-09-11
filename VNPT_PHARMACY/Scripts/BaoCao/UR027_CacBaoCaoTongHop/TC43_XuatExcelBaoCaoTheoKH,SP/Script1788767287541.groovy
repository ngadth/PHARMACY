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
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.FileInputStream


String dirName = RunConfiguration.getProjectDir()

String downloadPath = dirName + '\\Data Files\\BaoCao' // Thư mục tải file

String pathFileDownload = downloadPath.replaceAll('/', '\\\\')

String startName = 'Baocaobanhang'

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
WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

WebUI.click(findTestObject('Common/menu_baoCao'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Các báo cáo tổng hợp']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Báo cáo thống']))

//ban hang chi tiet
WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

WebUI.setText(findTestObject('Common/input_search'),'Báo cáo bán hàng theo khách hàng')

WebUI.click(findTestObject('Object Repository/Common/option_liDynamicLocators',[('optionName'):'Báo cáo bán hàng theo khách hàng']))

// kho va khoang thoi gian

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Lựa chọn Kho']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : '9481-auto4574']))

WebUI.delay(2)

String date = '26/08/2026 - 30/08/2026'

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'searchDate']), Keys.chord(Keys.ENTER))

WebUI.assertElementPresent(findTestObject('Common/text_tdDynamicLocators',[('text'):'Saphiazcica']), 3)

//Xóa file
CustomKeywords.'libKeyWords.PageObject.deleteFilesWithPrefixStartEnd'(pathFileDownload, startName, endName)

// Tải file
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xuất Excel']))

WebUI.delay(10)

// Kiểm tra file đã được tải về
CustomKeywords.'libKeyWords.PageObject.checkFileDownloadedStartEnd'(pathFileDownload, startName, endName)

def latestFile = new File(pathFileDownload).listFiles()
.findAll { it.name.startsWith(startName) && it.name.endsWith(endName) }
.max { it.lastModified() }

def workbook

if (latestFile.name.toLowerCase().endsWith('.xls')) {
    workbook = new HSSFWorkbook(new FileInputStream(latestFile))
} else {
    workbook = new XSSFWorkbook(new FileInputStream(latestFile))
}

def sheet = workbook.getSheetAt(0)

def valueH7 = sheet.getRow(6).getCell(7).toString()
def valueJ7 = sheet.getRow(6).getCell(9).toString()

WebUI.verifyMatch(valueH7, '2.0', false)
WebUI.verifyMatch(valueJ7, '600.0', false)

workbook.close()
