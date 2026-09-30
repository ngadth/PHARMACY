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

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Khách hàng')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN']), 'Autotest_KhongSoDT')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), '01/10/2000')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mst = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mst)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), 'Đà Nẵng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới khách hàng thành công']), 5)

WebUI.delay(1)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

StringBuilder sbKyTuDB = new StringBuilder()
sbKyTuDB.append('@#$%^&*()')
WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MOBILE']), sbKyTuDB.toString())

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN']), 'Autotest_SoDiDong')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), '01/10/2000')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mstDB = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mstDB)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), 'Đà Nẵng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/text_pDynamicLocators', [('text') : 'Số điện thoại không hợp lệ']), 5)

WebUI.delay(1)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Hủy']))

WebUI.delay(1)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

StringBuilder sb12So = new StringBuilder()
for (int i = 0; i < 12; i++) {
    sb12So.append('9')
}
WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MOBILE']), sb12So.toString())

String mobileValue = WebUI.getAttribute(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MOBILE']), 'value')

WebUI.verifyEqual(mobileValue.length(), 12)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN']), 'Autotest_12So')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), '01/10/2000')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mst12 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mst12)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), 'Đà Nẵng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới khách hàng thành công']), 5)

WebUI.delay(1)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

StringBuilder sb10So = new StringBuilder()
for (int i = 0; i < 10; i++) {
    sb10So.append('9')
}
WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MOBILE']), sb10So.toString())

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN']), 'Autotest_10So')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), '01/10/2000')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mst10 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mst10)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), 'Đà Nẵng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới khách hàng thành công']), 5)

WebUI.delay(1)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

StringBuilder sb11So = new StringBuilder()
for (int i = 0; i < 11; i++) {
    sb11So.append('9')
}
WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MOBILE']), sb11So.toString())

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'TEN']), 'Autotest_11So')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), '01/10/2000')

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtNgaySinh']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'title']), 'AutoTest')

String mst11 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 9)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'MS_THUE']), mst11)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'DIACHI']), 'Đà Nẵng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới khách hàng thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), 'Autotest_12So')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa khách hàng']), 3)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), 'Autotest_10So')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa khách hàng']), 3)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), 'Autotest_11So')

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ten']), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa khách hàng']), 3)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.delay(1)