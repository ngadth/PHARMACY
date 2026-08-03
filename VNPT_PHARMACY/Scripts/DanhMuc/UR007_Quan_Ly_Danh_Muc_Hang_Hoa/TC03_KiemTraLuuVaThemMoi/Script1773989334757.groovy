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

String filePath = projectDir + '/Data Files/image.png'

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('DANH MỤC', 'Hàng hóa')

WebUI.waitForElementVisible(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Hàng hóa']), 5)

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Thêm mới thuốc ']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm hàng hóa']), 5)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-unit-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Viên')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Viên']))

String tenHH1 = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('TenHHAuto_' + tenHH1)

String tenVTHang1 = tenHH1

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'name']), GlobalVariable.maKH)

String tenVT1 = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('TenVTAuto_' + tenVT1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'short_name']), GlobalVariable.name_service)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-pg_id-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'sp']), '5000')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'bp']), '4000')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'waranty_month']), '12')

String sdk1 = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.order_id = ('DK_' + sdk1)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'specification']), GlobalVariable.order_id)

WebUI.setText(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'note']), 'Ghi chú thêm mới hàng hóa round 1')

WebUI.uploadFile(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'fileUpload']), filePath)

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/tab_aTextDynamicLocators', [('tabValue') : 'Thuộc tính']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_1']), 'Berberin (5,6-dihydro-9, 10-dimethoxy benzo')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_2']), '10mg')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_3']), 'phan loai')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_4']), 'Viên nén bao đường')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_5']), 'NADYPHAR')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_6']), 'Việt Nam')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_7']), 'Viên')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_8']), 'Sử dụng đúng cách')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu & Thêm mới']))

WebUI.delay(1)

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 10)

WebUI.verifyElementPresent(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thêm hàng hóa']), 5)

GlobalVariable.maKH = ('TenHHAuto_' + tenHH1)

WebUI.delay(2)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-unit-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Viên')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Viên']))

String tenHH2 = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.maKH = ('TenHHAuto_' + tenHH2)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'name']), GlobalVariable.maKH)

String tenVT2 = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.name_service = ('TenVTAuto_' + tenVT2)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'short_name']), GlobalVariable.name_service)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-pg_id-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'sp']), '6000')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'bp']), '5000')

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'waranty_month']), '24')

String sdk2 = CustomKeywords.'libKeyWords.PageObject.randomString'('QWERTYUIASDFGHJKLZXCVBNM1234567890', 5)

GlobalVariable.order_id = ('DK_' + sdk2)

WebUI.setText(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'specification']), GlobalVariable.order_id)

WebUI.setText(findTestObject('XuatKhoBanHang/textarea_idDynamicLocators', [('idValue') : 'note']), 'Ghi chú thêm mới hàng hóa round 2')

WebUI.uploadFile(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'fileUpload']), filePath)

WebUI.delay(2)

WebUI.click(findTestObject('QuanLyKho/tab_aTextDynamicLocators', [('tabValue') : 'Thuộc tính']))

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_1']), 'Berberin (5,6-dihydro-9, 10-dimethoxy benzo')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_2']), '10mg')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_3']), 'phan loai')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_4']), 'Viên nén bao đường')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_5']), 'NADYPHAR')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_6']), 'Việt Nam')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_7']), 'Viên')

WebUI.setText(findTestObject('XuatKhoBanHang/input_idDynamicLocatorsLast', [('idValue') : 'attribute_8']), 'Sử dụng đúng cách')

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu & Đóng lại']))

WebUI.delay(1)

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 10)

String maHHRound2 = WebUI.getAttribute(findTestObject('DanhMuc/get_labelInputDynamicLocators', [('labelValue') : 'Mã HH']), 
    'value')

println('Mã HH round 2: ' + maHHRound2)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa hàng hóa']), 5)

WebUI.delay(10)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Lưu']))

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật thành công']), 10)

int maHHRound2Int = Integer.parseInt(maHHRound2)
int maHHRound1Int = maHHRound2Int - 1
String maHHRound1 = maHHRound1Int.toString()

println('Debug - maHHRound1 (calculated): >' + maHHRound1 + '<')
println('Debug - maHHRound2: >' + maHHRound2 + '<')

WebUI.verifyElementPresent(findTestObject('XuatKhoBanHang/text_bDynamicLocators', [('text') : 'Hàng hóa']), 5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'rdTK']), 'Danh mục', false)

WebUI.click(findTestObject('XuatKhoBanHang/span_idDynamicLocators', [('idValue') : 'select2-5zHlT3pVDFHl5FAZTo-container']))

WebUI.setText(findTestObject('Common/input_search'), 'Duoc pham')

WebUI.click(findTestObject('Common/option_liDynamicLocators', [('optionName') : 'Duoc pham']))

WebUI.setText(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'CBtVCFLm']), maHHRound1)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'CBtVCFLm']), Keys.chord(Keys.ENTER))

WebUI.delay(1)

String maLoaiHang1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã loại hàng', 0, 'product')

String tenLoaiHang1 = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên loại hàng', 0, 'product')

println('Verify round 1 - maHHRound1: ' + maHHRound1 + ', maLoaiHang1: ' + maLoaiHang1)

WebUI.verifyEqual(maLoaiHang1, maHHRound1)

WebUI.verifyEqual(tenLoaiHang1, 'TenHHAuto_' + tenVTHang1)

println('Verify round 2 - maHHRound2: ' + maHHRound2 + ', tenHH2: ' + tenHH2)