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


String dirName = RunConfiguration.getProjectDir()

String downloadPath = dirName + '\\Data Files' // Thư mục tải file

String pathFileDownload = downloadPath.replaceAll('/', '\\\\')

String startName = 'BaoCaoBHTHNHH'

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

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

//ban hang chi tiet
WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

WebUI.setText(findTestObject('Common/input_search'),'Báo cáo doanh thu theo khách hàng')

WebUI.click(findTestObject('Object Repository/Common/option_liDynamicLocators',[('optionName'):'Báo cáo doanh thu theo khách hàng']))

// mac dinh
String value = WebUI.getAttribute(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),'value')
assert value.trim().contains(currentDate)

//khong dung dinh dang

def invalidForm = [
	'04/30/2026',
	'2026/30/04',
	'abcdefgh',
	'04',
	'04/08'
]

for (int i = 0; i < invalidForm.size(); i++) {

	String date1 = invalidForm[i] +' - ' +invalidForm[i]

	WebUI.setText(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),date1)

	WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),Keys.chord(Keys.ENTER))

	WebUI.verifyElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng ngày tháng không hợp lệ!']))
}

// ngay thang khong hop le
def invalidDate = [
	'32/04/2009',
	'12/14/2009',
	'31/04/1983',
	'31/06/1983',
	'31/09/1983',
	'31/11/1983',
	'30/02/1983',
	'29/02/1983',
	//'1/2/0999',
	'1/2/99999'
]

for (int i = 0; i < invalidDate.size(); i++) {

	String date2 = invalidDate[i] + ' - ' + invalidDate[i]

	WebUI.setText(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),date2)

	WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),Keys.chord(Keys.ENTER))

	WebUI.verifyElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng ngày tháng không hợp lệ!']))
	
}

WebUI.delay(2)

// ngay thang hop le
def validDate = [
	'31/01/2026',
	'29/02/1980',
	'28/02/1983',
	'31/03/2026',
	'30/04/2026',
	'31/05/2026',
	'30/06/2026',
	'31/07/2026',
	'31/08/2026',
	'30/09/2026',
	'31/10/2026',
	'30/11/2026',
	'31/12/2026',
	'10/10/1983',
	'12/02/2019'
]

for (int i = 0; i < validDate.size(); i++) {
	
	String date3 = validDate[i] +' - ' + validDate[i] 

	WebUI.setText(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),date3)

	WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),Keys.chord(Keys.ENTER))

	WebUI.verifyElementNotPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng ngày tháng không hợp lệ!']), 3)
	
}

WebUI.setText(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),'12/02/2019 - 01/02/2019')

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators',[('idValue'):'searchDate']),Keys.chord(Keys.ENTER))

WebUI.verifyElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Ngày bắt đầu không được lớn hơn ngày kết thúc!']))
