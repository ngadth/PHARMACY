import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.katalon.webui.keyword.assertion.AssertElementAttributeValueKeyword
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Kiểm kê hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Kiểm kê hàng hóa']), 3)

//mac dinh
String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String value =  WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), 'value')

assert value.contains(currentDate)

// khong dung dinh dang

def invalidForm = [
	'04/30/2026',
	'2026/30/04',
	'abcdefgh',
]

for (int i = 0; i < invalidForm.size(); i++) {

	String date1 = invalidForm[i] + '-' + invalidForm[i]

	WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),date1)

	WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),Keys.chord(Keys.ENTER))

	String value1 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),'value')

	assert !value1.contains(invalidForm[i]) 
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
	'1/2/0999',
	'1/2/99999'
]

for (int i = 0; i < invalidDate.size(); i++) {

	String date2 = invalidDate[i] + '-' + invalidDate[i]

	WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),date2)

	WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),Keys.chord(Keys.ENTER))

	String value2 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),'value')

	assert !value2.contains(invalidDate[i])
}

// ngay thang hop le
def validDate = [
	'31/01',
	'29/02/1980',
	'28/02/1983',
	'31/03',
	'30/04',
	'31/05',
	'30/06',
	'31/07',
	'31/08',
	'30/09',
	'31/10',
	'30/11',
	'31/12',
	'10/10/1983',
	'01/02/1000',
	'01/02/9999',
	'12/02/2019'
]

for (int i = 0; i < validDate.size(); i++) {
	
		String date3 = validDate[i] + '-' + validDate[i]
	
		WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),date3)
	
		WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),Keys.chord(Keys.ENTER))
	
		String value3 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),'value')
	
		assert value3.contains(validDate[i])
	}
	
// bat dau > ket thuc
	
String date4 = '12/02/2019 - 01/02/2019'

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),date4)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),Keys.chord(Keys.ENTER))

String value4 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']),'value')

assert !value4.contains(date4)
	