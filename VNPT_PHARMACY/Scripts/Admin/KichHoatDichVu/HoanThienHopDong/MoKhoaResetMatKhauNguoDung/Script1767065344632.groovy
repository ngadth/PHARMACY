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

//import org.openqa.selenium.Keys
WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

//WebUI.delay(5)
WebUI.click(findTestObject('Common/button_advanced'))

WebUI.click(findTestObject('Common/link_unsafe'))

WebUI.setText(findTestObject('Common/input_username'), GlobalVariable.userAdmin)

WebUI.setText(findTestObject('Common/input_password'), GlobalVariable.passAdmin)

WebUI.click(findTestObject('Common/btn_DangNhap'))

WebUI.waitForElementVisible(findTestObject('Common/logo_vnpt'), GlobalVariable.timeout)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kích hoạt dịch vụ']))

WebUI.delay(2)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Mở khóa, reset mật khẩu người dùng']))

WebUI.verifyElementVisible(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Mở khóa, reset mật khẩu người dùng']))

WebUI.setText(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Tên khách hàng']), 'erp test Pharmacy')

// Nhấn phím Enter tại ô input đó
WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators', [('text') : 'Tên khách hàng']), Keys.chord(Keys.ENTER))

WebUI.mouseOver(findTestObject('Admin/KichHoatDichVu/MoKhoaReSet/hover_trangThai'))

WebUI.waitForElementVisible(findTestObject('Admin/KichHoatDichVu/MoKhoaReSet/reset_matKhau'), 10)

WebUI.mouseOver(findTestObject('Admin/KichHoatDichVu/MoKhoaReSet/reset_matKhau'))

WebUI.click(findTestObject('Admin/KichHoatDichVu/MoKhoaReSet/reset_matKhau'))

WebUI.waitForElementVisible(findTestObject('Admin/KichHoatDichVu/MoKhoaReSet/btn_xacNhan'), 20)

WebUI.click(findTestObject('Admin/KichHoatDichVu/MoKhoaReSet/btn_xacNhan'))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 30)

WebUI.verifyElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']))

