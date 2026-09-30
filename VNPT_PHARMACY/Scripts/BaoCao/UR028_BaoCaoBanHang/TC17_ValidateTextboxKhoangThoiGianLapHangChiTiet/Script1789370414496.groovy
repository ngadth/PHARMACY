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


String columnTable 	= "Ngày BC;Kho;Cửa hàng;Quầy bán;Người bán;Mặt hàng;Đơn vị tính;Số lượng bán;Giá bán;Tổng tiền bán;Số lượng trả lại;Tiền trả lại;Doanh thu;Khuyến mại;Giá vốn;Lợi nhuận";
//String date			='22/06/2025'
String date			='08/09/2026'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)


WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'BÁO CÁO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Báo cáo bán hàng']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('BÁO CÁO', 'Báo cáo bán hàng')

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Báo cáo Bán hàng TH']))

WebUI.click(findTestObject('Common/option_liDynamicLocators',[('optionName'):'Báo cáo Bán hàng chi tiết']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators',[('text'):'Báo cáo Bán hàng chi tiết']))

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

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
