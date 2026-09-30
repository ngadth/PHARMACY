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

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu kiểm kê']), 5)

//mac dinh
String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String value = WebUI.getAttribute(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),'value')

assert value.trim() == currentDate

//khong dung dinh dang

def invalidForm = [
	'04/30/2026',
	'2026/30/04',
	'abcdefgh',
]

for (int i = 0; i < invalidForm.size(); i++) {

	String date1 = invalidForm[i] 

	WebUI.setText(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),date1)

	WebUI.sendKeys(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),Keys.chord(Keys.ENTER))

	String value1 = WebUI.getAttribute(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),'value')

	assert !value1.contains(date1)
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

	String date2 = invalidDate[i]

	WebUI.setText(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),date2)

	WebUI.sendKeys(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),Keys.chord(Keys.ENTER))

	String value2 = WebUI.getAttribute(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),'value')

	assert !value2.contains(date2)
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
	'20/02/2019'
]

for (int i = 0; i < validDate.size(); i++) {
	
		String date3 = validDate[i] 
	
		WebUI.setText(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),date3)
	
		WebUI.sendKeys(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),Keys.chord(Keys.ENTER))
	
		String value3 = WebUI.getAttribute(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Ngày nhập']),'value')
	
		assert value3.contains(date3)
	}
	