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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.util.regex.Pattern as Pattern

String projectDir = RunConfiguration.getProjectDir()

String filePath1 = projectDir + '/Data Files/imageThuoc.png'

WebUI.callTestCase(findTestCase('DanhMuc/TC01_ThemMoiHangHoa'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('DanhMuc/table_row1', [('idValue') : 'product']))

WebUI.click(findTestObject('CongNo/button_spaceTextDynamicLocators', [('buttonName') : 'Sửa thông tin']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa hàng hóa']), 5)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-unit-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Viên')

//WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Viên']))
WebUI.delay(0.5)
WebUI.click(findTestObject('Common/li_idDynamicLocatorsContains', [('idValue') : 'select2-unit-result']))

String tenHHUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('UDTenHHAuto_' + tenHHUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'name']), GlobalVariable.maKH)

String tenVTUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('UDTenVTAuto_' + tenVTUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'short_name']), GlobalVariable.name_service)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-pg_id-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'waranty_month']), '12')

String sdkUD = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.order_id = ('DK_' + sdkUD)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'specification']), GlobalVariable.order_id)

WebUI.setText(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'note']), 'Ghi chú chỉnh sửa hàng hóa')

WebUI.uploadFile(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'fileUpload']), filePath1)

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/tab_aTextDynamicLocators', [('tabValue') : 'Thuộc tính']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_1']), 'UD-Berberin (5,6-dihydro-9, 10-dimethoxy benzo')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_2']), 'UD-10mg')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_3']), 'UD-phan loai')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_4']), 'UD-Viên nén bao đường')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_5']), 'UD-NADYPHAR')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_6']), 'Việt Nam')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_7']), 'UD-Viên')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_8']), 'UD-Sử dụng đúng cách')

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.acceptAlert()

WebUI.acceptAlert()


WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 10)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'rdTK']), 'Danh mục', false)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-5zHlT3pVDFHl5FAZTo-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'CBtVCFLm']), GlobalVariable.phieuban_id)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'CBtVCFLm']), Keys.chord(Keys.ENTER))

String maLoaiHangUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã loại hàng', 0, 'product')

String tenLoaiHangUD = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên loại hàng', 0, 'product')

WebUI.verifyEqual(maLoaiHangUD, GlobalVariable.phieuban_id)

WebUI.verifyEqual(tenLoaiHangUD, GlobalVariable.maKH)

WebUI.delay(5)

WebUI.click(findTestObject('DanhMuc/table_row1', [('idValue') : 'product']))

WebUI.click(findTestObject('DanhMuc/button_spaceDynamicLocatorsLast', [('buttonName') : 'Xóa']))

WebUI.delay(10)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Xác nhận xóa loại hàng hóa']), 10)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 5)

