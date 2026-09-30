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

WebUI.delay(2)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Bán hàng đã nhập kho')
WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Bán hàng đã nhập kho']))

WebUI.delay(2)

WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))

//khong hop le
WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'Trịnh trần phương tuấn')

WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')

invalidEmail =[
	'testtesst.vn',
	'#@%^%#$@#$@#.com',
	'@domain.vn',
	'email<email@domain.com>',
	'email@domain@domain.vn',
	'….email@domain.vn',
	'email@domain.vn(test)',
	'email@domain'
	]
	
for(int i=0; i< invalidEmail.size();i++) {
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),invalidEmail[i])
	
	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
	
	WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 5)
	
}

////gia tri dac biet
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'#@%^%#$@#$@#.com')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)
//
//// khong ten
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'@domain.vn')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)
//
//// html
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'email<email@domain.com>')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)
//
//// 2 @
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'email@domain@domain.vn')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)

//// dau .
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'trịnh trần phương tuấn')
//
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')
//
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'.email@domain.vn')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)

//// nhieu .
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'….email@domain.vn')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)
//
//// sau email
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'email@domain.vn(test)')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)
//
//// thieu duoi
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'email@domain')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)

//// gach ngang
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'trịnh trần phương tuấn')
//
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')
//
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'email@-domain.com')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)

//// ip ko hop le
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'trịnh trần phương tuấn')
//
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')
//
//WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),'email@111.222.333.44444')
//
//WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
//
//WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Định dạng email không đúng. Vui lòng nhập lại!']), 3)

// khong hop le
// hop le
validEmail =[
	'email@domain.com',
	'first.name@domain.com',
	'email@subdomain.domain.vn',
	//'email@[10.168.3.96]',
	//'"email"@domain.vn',
	'1212432@domain.com',
	'______@domain.com',
	'firstname-lastname@domain.com'
	]
	
for(int i=0; i< validEmail.size();i++) {
	WebUI.refresh()
	
	WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators', [('text') : 'Thêm khách hàng']))
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Tên KH ']),'Trịnh trần phương tuấn')
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Địa chỉ']),'bến tre')
	
	WebUI.setText(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Email']),validEmail[i])
	
	WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Lưu']))
	
	if (WebUI.verifyElementPresent(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Email đã tồn tại. Vui lòng thực hiện lại!']),3,FailureHandling.OPTIONAL)
	) {
		WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Hủy']))
		continue
	}
	
	WebUI.assertElementPresent(findTestObject('Common/noti_h4ThanhCong',[('text'):'Đã cập nhật thành công']), 5)
	
	WebUI.click(findTestObject('Common/dropdown_spanlastDynamicLocators',[('text'):'Xóa khách hàng']))
	
	
}
