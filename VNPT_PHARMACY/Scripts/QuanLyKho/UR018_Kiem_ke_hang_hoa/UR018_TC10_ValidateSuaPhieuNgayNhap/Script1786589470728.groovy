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

WebUI.click(findTestObject('QuanLyKho/select_labelSpanDynamicLocators', [('labelValue') : 'Kho']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

String ghichu = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('ghiChu' + ghichu)

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Ghi chú', ('index') : 1]), GlobalVariable.name_service)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Ngày nhập']))

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Ngày nhập']), currentDate)
WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Ngày nhập']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

String hangHoa = 'MA316'

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'search_product']), hangHoa)

WebUI.delay(3)

WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.setText(findTestObject('QuanLyKho/input_soluongClass'), '2')

//WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'quantity_in_warehouse_205966_1']),  '2')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện kiểm kê thành công']), 5)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cân kho']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators', [('text') : 'Kho nhập (tất cả)']))

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'SHOP6-CH 6']))

WebUI.click(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), date)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'checkDateRange']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), hangHoa)

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Loại hàng hóa', ('index') : '1']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

String soPhieu = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu', 0, 'tableCheckProduct')

String dienGiai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Diễn giải', 0, 'tableCheckProduct')

WebUI.verifyEqual(dienGiai, GlobalVariable.name_service)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu kiểm kê']), 5)

//mac dinh

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
	