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
import com.kms.katalon.core.testobject.TestObject
import com.katalon.webui.keyword.action.image.WebUIAbstractImageActionKeyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Xuất kho']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Xuất kho')
WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Quản lý xuất kho']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm phiếu xuất kho']), 5)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

//mac dinh
String value = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),'value')

assert value.trim() == currentDate

// khong dung dinh dang
def invalidForm = [
	'04/30/2026',
	'2026/30/04',
	'abcdefgh',
	'30',
	'30/01'
]

for (int i = 0; i < invalidForm.size(); i++) {

	String date1 = invalidForm[i] 

	WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),date1)

	WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),Keys.chord(Keys.ENTER))

	String value1 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),'value')
	
	assert value1 != date1
	
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

	WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),date2)

	WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),Keys.chord(Keys.ENTER))

	String value2 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),'value')
	
	assert value2 != date2
}

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
	//'01/02/1000',
	//'01/02/9999',
	'12/02/2019'
]

for (int i = 0; i < validDate.size(); i++) {
	
	String date3 = validDate[i] 

	WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),date3)

	WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),Keys.chord(Keys.ENTER))
	
	String value3 = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ngayxuat']),'value')
	
	assert value3 == date3
}
	
