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

WebUI.sendKeys(findTestObject('Common/input_placeholderDynamicLocators',[('text'):'Tìm mặt hàng (F3)', ('index'):'1']), GlobalVariable.maSanPham)

//List<WebElement> list = WebUI.findWebElements(findTestObject('XuatKhoBanHang/div_tenThuoc'),5)
//
//for (WebElement element : list) {
//	String tenThuoc = element.getText().trim()
//    assert tenThuoc.toLowerCase().contains(GlobalVariable.maSanPham.toLowerCase())
//}

WebUI.delay(2)

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(dynamicObject)

    println('Đã click element có value = 0')
} else {
    println('Không tìm thấy element có value = 0 → bỏ qua')
}

String value = WebUI.getAttribute(findTestObject('XuatKhoBanHang/input_DonGia'), 'value')
String total = WebUI.getText(findTestObject('XuatKhoBanHang/td_ThanhTien'))

assert total.replace(',', '').toInteger() == value.replace(',', '').toInteger()

GlobalVariable.maKH = 'Auto_test01'

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'makh']), GlobalVariable.maKH)

WebUI.click(findTestObject('Common/titlePage_bDynamicLocators', [('text') : GlobalVariable.maKH]))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_kMTrucTiep'), '9999')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_khachThanhToan'))
WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_khachThanhToan'), '500,000')

WebUI.delay(2)

WebUI.click(findTestObject('Common/radio_labelDynamicIndexLocators',[('text'):'Tính vào công nợ', ('index'):'2']))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'txtGhichu']), 'Tái khám sau 1 tháng')

String currentTime = CustomKeywords.'libKeyWords.PageObject.getCurrentDateTimeFull'()

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']),  GlobalVariable.timeout)

WebUI.click(findTestObject('Common/dropdown_account'))

WebUI.click(findTestObject('QuanLyKho/li_aTextDynamicLocators',[('textValue'):'Tra cứu giao dịch bán hàng']))

String value1 = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators',[('index'):'50']))

Date expected = Date.parse('dd/MM/yyyy HH:mm:ss', currentTime)
Date actual = Date.parse('dd/MM/yyyy HH:mm:ss', value1)

assert actual >= expected

String tienHang = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators',[('index'):'47']))
assert tienHang == '1,800'

String thucThu = WebUI.getText(findTestObject('Common/cell_tdDynamicLocators',[('index'):'49']))
assert thucThu == '-8,199'
