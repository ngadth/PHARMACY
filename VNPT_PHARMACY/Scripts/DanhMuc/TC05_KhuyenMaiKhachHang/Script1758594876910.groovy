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

String status = 'Kích hoạt'

WebUI.callTestCase(findTestCase('DanhMuc/TC01_ThemMoiHangHoa'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'DANH MỤC']))

WebUI.waitForElementVisible(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Khuyến mại khách hàng']), 30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Khuyến mại khách hàng']))

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Khuyến mại khách hàng')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Chương trình khuyến mại khách hàng']), 
    5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm chương trình KM']), 5)

String maCT = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maDonHang = ('MaKMAuto_' + maCT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'kmcode']), GlobalVariable.maDonHang)

String tenCT = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maDonThuoc = ('TenKMAuto_' + tenCT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'kmname']), GlobalVariable.maDonThuoc)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + '23/09/2028'

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'trx_date_start']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'trx_date_start']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'trx_date_start']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'kmnote']), 'Ghi chú chương trình KM theo tháng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Tiếp tục']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 5)

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'KM theo giá trị đơn hàng']))

WebUI.delay(3)

WebUI.click(findTestObject('Admin/Common/button_divDynamicLocators', [('idValue') : 'amount', ('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm KM theo giá trị đơn hàng']), 
    5)

GlobalVariable.order_id = CustomKeywords.'libKeyWords.PageObject.randomString'('1234567890', 6)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'gtdh']), GlobalVariable.order_id)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'lsp_km_name']), 'Khuyến mãi 20/10')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'gtkm_fix']), '99999')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thêm mới thành công!']), 10)

WebUI.delay(3)

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'KM theo loại hàng hóa']))

WebUI.click(findTestObject('Admin/Common/button_divDynamicLocators', [('idValue') : 'productcat', ('buttonName') : 'Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm KM theo loại hàng hóa']), 
    10)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'id_lsp']), GlobalVariable.phieuban_id)

WebUI.delay(3)
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_indexFirst', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
	WebUI.click(dynamicObject)

	println('Đã click element có value = 0')
} else {
	println('Không tìm thấy element có value = 0 → bỏ qua')
}

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'soluong']), '2')

WebUI.delay(1)

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'gtkm_fix']), '9999')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'lsp_km_name']), 'Khuyến mãi 20/10')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 10)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cập nhật']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 10)

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'Cctj5Rs.']), GlobalVariable.maDonThuoc)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFH03yPXTEAVDzPXDdOn']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFH03yPXTEAVDzPXDdOn']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFH03yPXTEAVDzPXDdOn']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : '4y9a5Rs.']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : '4y9a5Rs.']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('CongNo/radio_idDynamicLocators', [('idValue') : 'sts_open']))

String ma = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('ID/Mã', 0, 'product')

String[] parts = ma.split('/')

// Lấy phần sau dấu "/"
String maID = parts[1]

println(maID)

String tenCTCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên chương trình', 0, 'product')

String trangThai = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Trạng thái', 0, 'product')

WebUI.verifyEqual(maID, GlobalVariable.maDonHang)

WebUI.verifyEqual(tenCTCell, GlobalVariable.maDonThuoc)

WebUI.verifyEqual(trangThai, status)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(3)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa đổi']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa chương trình KM']), 5)

GlobalVariable.maDonHang = ('UDMaAuto_' + maCT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'kmcode']), GlobalVariable.maDonHang)

GlobalVariable.maDonThuoc = ('UDTenKMAuto_' + tenCT)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'kmname']), GlobalVariable.maDonThuoc)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'trx_date_start']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'trx_date_start']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'trx_date_start']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'kmnote']), 'Update chương trình KM theo tháng')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Cập nhật']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Thực hiện thành công!']), 10)

WebUI.refresh()

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'Cctj5Rs.']), GlobalVariable.maDonThuoc)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFH03yPXTEAVDzPXDdOn']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFH03yPXTEAVDzPXDdOn']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFH03yPXTEAVDzPXDdOn']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : '4y9a5Rs.']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : '4y9a5Rs.']), Keys.chord(Keys.ENTER))

WebUI.delay(1)

String maCellUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('ID/Mã', 0, 'product')

String[] parts1 = maCellUD.split('/')

// Lấy phần sau dấu "/"
String maIDUD = parts1[1]

println(maIDUD)

String tenUDCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên chương trình', 0, 'product')

String trangThaiUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Trạng thái', 0, 'product')

WebUI.verifyEqual(maIDUD, GlobalVariable.maDonHang)

WebUI.verifyEqual(tenUDCell, GlobalVariable.maDonThuoc)

WebUI.verifyEqual(trangThaiUD, status)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

//WebUI.click(findTestObject('Admin/Common/btn_action'))

WebUI.delay(3)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa CTKM']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

