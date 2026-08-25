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

WebUI.callTestCase(findTestCase('QuanLyKho/UR016_Nhap_Kho_Hang_Hoa/TC25_NhapKhoTheoPhieuXuatKho'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']), FailureHandling.OPTIONAL) ? WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more'])) : null

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Xuất kho']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('XUẤT KHO/BÁN HÀNG', 'Xuất kho')
WebUI.verifyElementPresent(findTestObject('Common/titlePage_bDynamicLocators', [('text') : 'Quản lý xuất kho']), 5)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), GlobalVariable.soPhieuXuat)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(2)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa phiếu']))

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu xuất kho']), 5)

WebUI.click(findTestObject('QuanLyKho/li_aTextDynamicLocators',[('textValue'):'Hàng đã xuất kho']))

WebUI.click(findTestObject('Common/dropdown_spanDynamicLocators',[('text'):'Xóa']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.assertElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Có lỗi xảy ra: Sản phẩm đã được nhập kho trở lại từ một phiếu nhập, không thể hủy xuất sản phẩm!']), 5)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Hủy']))

WebUI.delay(2)

WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(2)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa phiếu']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.delay(2)

WebUI.assertElementVisible(findTestObject('Common/noti_h4ThanhCong',[('text'):'Có lỗi xảy ra: Đã có phiếu nhập thực hiện nhập kho từ phiếu xuất này, bạn không thể xóa!']), 5)