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
import org.openqa.selenium.support.ui.Select as Select

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Quầy thu/kho')

/* ===== Case 1: Không phải là trường bắt buộc => lưu thành công với giá trị mặc định ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

String ma1 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.maDonHang = ('Auto_MayIn_' + ma1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtMaQuay_i']), GlobalVariable.maDonHang)

String ten1 = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890ABCDRFGLJH', 5)

GlobalVariable.name_service = ('Ten_MayIn_' + ten1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'txtTenQuay_i']), GlobalVariable.name_service)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công']), 5)

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'txtMaQuayThu']), Keys.chord(Keys.ENTER))

String maQuay1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã quầy', 0, 'table_quaythu')

WebUI.verifyEqual(maQuay1, GlobalVariable.maDonHang)

WebUI.delay(1)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xóa quầy thu']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 2: Có giá trị mặc định là "Máy in nhiệt khổ 80mm" ===== */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebElement selectElement = WebUiCommonHelper.findWebElement(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlCBt16B1V6O..']), 5)

Select select = new Select(selectElement)

String defaultValue = select.getFirstSelectedOption().getText()

WebUI.verifyEqual(defaultValue, 'Máy in nhiệt khổ 80mm')

WebUI.refresh()

WebUI.delay(3)


/* ===== Case 3: Droplist có 2 lựa chọn: "Máy in nhiệt khổ 80mm", "Máy in nhiệt khổ 50mm" ===== */
/* === Thứ 1: Kiểm tra droplist có đúng 2 option === */
WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/DanhMuc/select_cuahang_themquaythu'))

WebUI.selectOptionByIndex(findTestObject('DanhMuc/select_cuahang_themquaythu'), 1)

WebElement selectElement2 = WebUiCommonHelper.findWebElement(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlCBt16B1V6O..']), 5)

Select select2 = new Select(selectElement2)

List<WebElement> options = select2.getOptions()

WebUI.verifyEqual(options.size(), 2)

WebUI.verifyEqual(options.get(0).getText(), 'Máy in nhiệt khổ 80mm')

WebUI.verifyEqual(options.get(1).getText(), 'Máy in nhiệt khổ 50mm')

/* === Thứ 2: Có thể chọn "Máy in nhiệt khổ 50mm" === */
WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlCBt16B1V6O..']), 'Máy in nhiệt khổ 50mm', false)

WebElement selectElement3 = WebUiCommonHelper.findWebElement(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlCBt16B1V6O..']), 5)

Select select3 = new Select(selectElement3)

String selectedValue1 = select3.getFirstSelectedOption().getText()

WebUI.verifyEqual(selectedValue1, 'Máy in nhiệt khổ 50mm')

/* === Thứ 3: Có thể chọn lại "Máy in nhiệt khổ 80mm" === */
WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlCBt16B1V6O..']), 'Máy in nhiệt khổ 80mm', false)

WebElement selectElement4 = WebUiCommonHelper.findWebElement(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlCBt16B1V6O..']), 5)

Select select4 = new Select(selectElement4)

String selectedValue2 = select4.getFirstSelectedOption().getText()

WebUI.verifyEqual(selectedValue2, 'Máy in nhiệt khổ 80mm')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Hủy']))

WebUI.delay(1)
