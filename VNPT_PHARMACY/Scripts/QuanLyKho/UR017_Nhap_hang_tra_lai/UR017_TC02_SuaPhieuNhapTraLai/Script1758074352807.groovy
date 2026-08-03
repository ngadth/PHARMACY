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

WebUI.callTestCase(findTestCase('QuanLyKho/UR017_Nhap_hang_tra_lai/UR017_TC01_NhapHangTraLai'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu nhập kho trả hàng']), 
    5)

WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập']))

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập']), 'Thái Bảo')

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Object Repository/QuanLyKho/input_ngayNhapKhoTraLai'))

WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_ngayNhapKhoTraLai'))

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_ngayNhapKhoTraLai'), currentDate)

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_ngayNhapKhoTraLai'), Keys.chord(Keys.ENTER))

String ghiNhoUD = 'Update Lập phiếu nhập kho trả hàng'

WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Ghi chú', ('index') : '2']))

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_labelIndexDynamicLocators', [('labelValue') : 'Ghi chú', ('index') : '2']), ghiNhoUD)

WebUI.clearText(findTestObject('Object Repository/QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Phương tiện vận chuyển']))

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Phương tiện vận chuyển']), 'Update Hàng không')

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Lưu thông tin phiếu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Lưu thông tin phiếu thành công!']), 10)

WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Sửa phiếu nhập kho trả hàng']))

WebUI.click(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']))

WebUI.clearText(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), GlobalVariable.order_id)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']))

WebUI.clearText(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']), currentDate)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']), Keys.chord(Keys.ENTER))

String maPhieu1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')

String ghiChu = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ghi chú', 0, 'inputtbl')

WebUI.verifyEqual(maPhieu1, GlobalVariable.order_id)

WebUI.verifyEqual(ghiChu, ghiNhoUD)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa phiếu nhập kho']), 
    10)

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Xác nhận']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

