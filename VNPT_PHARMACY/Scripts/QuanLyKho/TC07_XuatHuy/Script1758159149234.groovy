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

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Xuất hủy')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lập phiếu']))

WebUI.delay(3)

//WebUI.selectOptionByLabel(findTestObject('QuanLyKho/droplist_selectDynamicLast', [('idValue') : 'khoxuat']), 'HUONG6787-Nguyễn Thanh Hương', false)
WebUI.selectOptionByLabel(findTestObject('QuanLyKho/droplist_selectDynamicLast', [('idValue') : 'khoxuat']), 'SHOP2-Nhà thuốc Minh Lộc', false)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'thukhoxuat']), 'Thai Bao')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'diengiai']), 'diengiai Xuat Huy')

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngayxuat']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngayxuat']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngayxuat']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 5)

//GlobalVariable.maDonHang = 'Apitim 5 v/10 h/30 t/6480'
GlobalVariable.maDonHang = 'Anphachoay2 500mg'
WebUI.setText(findTestObject('QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'kw']), GlobalVariable.maDonHang)

WebUI.delay(0.5)

WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tableDynamicLocators'), '2')

WebUI.setText(findTestObject('XuatKhoBanHang/input_lyDoHuyTable'), 'Lý do Xuất Hủy ')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Xuất hủy']))

WebUI.delay(0.5)

String soPhieu = WebUI.getText(findTestObject('QuanLyKho/get_labelDynamicLocators', [('labelValue') : 'Số phiếu']))

GlobalVariable.po_phieu_id = soPhieu

println(GlobalVariable.po_phieu_id)

WebUI.delay(3)

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Thêm hàng Xuất Hủy']))

WebUI.delay(0.5)

WebUI.setText(findTestObject('QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'kw']), GlobalVariable.maDonHang)

WebUI.delay(1)

WebUI.click(findTestObject('XuatKhoBanHang/data_indexLast', [('value') : '0']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tableDynamicLocators'), '2')

WebUI.setText(findTestObject('XuatKhoBanHang/input_lyDoHuyTable'), 'Lý do Xuất Hủy ')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Xuất hủy']))

WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Sửa phiếu xuất hủy']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), GlobalVariable.po_phieu_id)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), Keys.chord(Keys.ENTER))

//WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'HUONG6787-Nguyễn Thanh Hương', false)
WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'SHOP2-Nhà thuốc Minh Lộc', false)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), Keys.chord(Keys.ENTER))

String soPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu xuất', 0, 'outputtbl')

WebUI.verifyEqual(soPhieuCell, GlobalVariable.po_phieu_id)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Sửa phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu xuất hủy']), 5)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'thukhoxuat']), 'Hà Thái Bảo')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'diengiai']), 'UpDate diengiai Xuat Huy')

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngayxuat']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngayxuat']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngayxuat']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Thêm hàng Xuất Hủy']))

WebUI.delay(0.5)

WebUI.setText(findTestObject('QuanLyKho/input_idDivDynamicLocators', [('idValue') : 'kw']), GlobalVariable.maDonHang)

WebUI.delay(1)

WebUI.click(findTestObject('XuatKhoBanHang/data_indexLast', [('value') : '0']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tableDynamicLocators'), '2')

WebUI.setText(findTestObject('XuatKhoBanHang/input_lyDoHuyTable'), 'Lý do Xuất Hủy ')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocators', [('buttonName') : 'Lưu thông tin']))

WebUI.delay(5)

WebUI.acceptAlert()

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), GlobalVariable.po_phieu_id)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), Keys.chord(Keys.ENTER))

//WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'HUONG6787-Nguyễn Thanh Hương', false)
WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 'SHOP2-Nhà thuốc Minh Lộc', false)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']), date)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'ngay_xuat']), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), GlobalVariable.maDonHang)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'CE9X63Lm3zPbCW..']), Keys.chord(Keys.ENTER))

String soPhieuCell1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Số phiếu xuất', 0, 'outputtbl')

WebUI.verifyEqual(soPhieuCell1, GlobalVariable.po_phieu_id)

WebUI.delay(2)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(1)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa phiếu']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa phiếu xuất kho']), 
    3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), GlobalVariable.po_phieu_id)

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_tenKhachHang', [('idValue') : 'ma_xuat']), Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

