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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.waitForElementClickable(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']), 30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']))

WebUI.delay(3)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

//khong hop le
WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Tên KH ', ('index') : '2']),'Trịnh trần phương tuấn')

WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Địa chỉ', ('index') : '5']),'bến tre')

invalidEmail =[
	'testtesst.vn',
	'#@%^%#$@#$@#.com',
	'@domain.vn',
	'email<email@domain.com>',
	'email@domain@domain.vn',
	'.email@domain.vn',
	'….email@domain.vn',
	'email@domain.vn(test)',
	'email@domain',
	'email@-domain.com',
	'email@111.222.333.44444'
	]
	
for(int i=0; i< invalidEmail.size();i++) {
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Email', ('index') : '5']),invalidEmail[i])
	
	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
	
	WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Email không hợp lệ']), 5)
	
}


// khong hop le
// hop le
validEmail =[
	'email@domain.com',
	'first.name@domain.com',
	'email@subdomain.domain.vn',
	//'email@10.168.3.96',
	//'email@[10.168.3.96]',
	//'"email"@domain.vn',
	'1212432@domain.com',
	'______@domain.com',
	'firstname-lastname@domain.com'
	]
	
for(int i=0; i< validEmail.size();i++) {
	WebUI.refresh()
	
	WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Tên KH', ('index') : '2']),'Trịnh trần phương tuấn')
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Địa chỉ', ('index') : '5']),'bến tre')
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Email', ('index') : '5']),validEmail[i])
	
	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
	
	if (WebUI.verifyElementPresent(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Email đã tồn tại. Vui lòng thực hiện lại!']),3,FailureHandling.OPTIONAL)
	) {
		WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Hủy']))
		continue
	}
	
	WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 5)
	
	WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators',[('text'):'Xóa khách hàng']))
	
	
}

