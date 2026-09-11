import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//String status = 'Chưa đồng bộ'
String status = 'Chưa LT'
WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('XuatKhoBanHang/TC01_BanThuocTheoDon'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Tra cứu giao dịch')
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Tra cứu giao dịch']))

WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Tra cứu giao dịch bán hàng']), 3)

//WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '5F5ZDA9f5o..']), 'HUONG6787-Nguyễn Thanh Hương', false)
// mac dinh
String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String value = WebUI.getAttribute(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),'value')
assert value.trim().contains(currentDate)

// khong dung dinh dang
def invalidForm = [
	'04/30/2026',
	'2026/30/04',
	'abcdefgh',
	'30',
	'30/01'
]

for (int i = 0; i < invalidForm.size(); i++) {

	String date1 = invalidForm[i] + ' - ' + invalidForm[i] 

	WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),date1)

	WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),Keys.chord(Keys.ENTER))
	WebUI.delay(0.5)
	WebUI.verifyElementVisible(findTestObject('Common/text_spanDynamicLocators',[('textValue'):'Tổng số bản ghi']))
	
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

	WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),date2)

	WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),Keys.chord(Keys.ENTER))
	WebUI.delay(0.5)
	WebUI.verifyElementVisible(findTestObject('Common/text_spanDynamicLocators',[('textValue'):'Tổng số bản ghi']))
}

// ngay thang hop le
def validDate = [
	'31/01/2026',
	'29/02/1980',
	'28/02/1983',
	'31/03/2026',
	'30/04/2026',
	'31/05/2026',
	'30/06/1999',
	'31/07/1999',
	'31/08/1999',
	'30/09/1999',
	'31/10/1999',
	'30/11/1999',
	'31/12/1999',
	'10/10/1983',
	'01/02/1000',
	'01/02/9999',
	//'20/02/2019'
]

for (int i = 0; i < validDate.size(); i++) {
	
	String date3 = validDate[i]  + ' - ' + validDate[i]

	WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),date3)
	
	WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Ngày bán',('index'):'1']),Keys.chord(Keys.ENTER))
	WebUI.delay(1)
	WebUI.verifyElementVisible(findTestObject('Common/text_tdDynamicLocators',[('text'):'Không có dữ liệu phù hợp thông tin tra cứu.']))
}
	
