
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
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import java.nio.file.*

String dirName = RunConfiguration.getProjectDir()

String downloadPath = dirName + '\\Data Files' // Thư mục tải file

String pathFileDownload = downloadPath.replaceAll('/', '\\\\')

String startName = 'PhieuNhap'

String endName = '.xls'

//// Cấu hình Chrome Options để tải file mà không hiển thị popups
Map<String, Object> prefs = new HashMap()

prefs.put('download.default_directory', pathFileDownload)

prefs.put('download.prompt_for_download', false)

prefs.put('profile.default_content_settings.popups', 0)

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('prefs', prefs)

// Khởi tạo ChromeDriver thủ công với cấu hình
ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

// Gán driver cho Katalon
WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

//Login
WebUI.click(findTestObject('Common/button_advanced'))

WebUI.click(findTestObject('Common/link_unsafe'))

WebUI.setText(findTestObject('Common/input_username'), GlobalVariable.userAdmin)

WebUI.setText(findTestObject('Common/input_password'), GlobalVariable.passAdmin)

WebUI.click(findTestObject('Common/btn_DangNhap'))

WebUI.waitForElementVisible(findTestObject('Common/logo_vnpt'), GlobalVariable.timeout)

WebUI.delay(3)

//KÊ ĐƠN BÁN THUỐC
//WebUI.delay(5)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'XUẤT KHO/BÁN HÀNG']))

WebUI.waitForElementClickable(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']), 30)

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Kê đơn bán thuốc']))

WebUI.delay(3)

WebUI.selectOptionByIndex(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cboCuaHang']), '0', FailureHandling.STOP_ON_FAILURE)

if (WebUI.waitForElementVisible(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']), 
    10, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']))

    println('Đã click nút Xác nhận chuyển')
} else {
    println('Không có nút Xác nhận chuyển → bỏ qua')
}

//WebUI.waitForElementClickable(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']),30)
//
//WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận chuyển']))
//WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/Common/input_placeholderDynamicLocators', [('text') : 'Tìm mặt hàng (F3)', ('index') : '1']), 'Acemuc')

WebUI.delay(2)

//WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))
TestObject dynamicObject = findTestObject('XuatKhoBanHang/data_index', [('value') : '0'])

if (WebUI.verifyElementPresent(dynamicObject, 5, FailureHandling.OPTIONAL)) {
    WebUI.click(dynamicObject)

    println('Đã click element có value = 0')
} else {
    println('Không tìm thấy element có value = 0 → bỏ qua')
}

WebUI.sendKeys(findTestObject('Object Repository/Common/input_placeholderDynamicLocators', [('text') : 'Tìm khách hàng (F4)', ('index') : '2']), 'Auto_test01')

WebUI.click(findTestObject('Common/text_divDynamicLocators', [('text') : 'Auto_test01']))

WebUI.sendKeys(findTestObject('Object Repository/Common/input_tdTextDynamicLocators', [('text') : 'Tổng khuyến mại', ('index') : '2']), '9999')

WebUI.clearText(findTestObject('XuatKhoBanHang/input_khachThanhToan'))

WebUI.sendKeys(findTestObject('XuatKhoBanHang/input_khachThanhToan'), '500,000')

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/textarea_GhiChu'), 'Kê đơn bán thuốc 30 ngày')

WebUI.click(findTestObject('XuatKhoBanHang/button_thanhToan'))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Thanh toán thành công, số phiếu: ']), 
    20)

WebUI.click(findTestObject('Common/icon_idDynamicLocators', [('idValue') : 'homepage']))

WebUI.delay(3)

//NHẬP HÀNG TRẢ LẠI
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập hàng trả lại']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Tra cứu giao dịch cần nhập kho trả hàng']),
	5)

WebUI.click(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']))
WebUI.selectOptionByIndex(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'khoxuat']), 0)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsFirst', [('buttonName') : 'Chọn']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu nhập kho trả hàng']),
	5)

WebUI.sendKeys(findTestObject('Object Repository/QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập']), 'Hà Thái Bảo')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

//soPhieu = WebUI.getText(findTestObject('QuanLyKho/get_labelMaPhieu'))
//
//println('Số phiếu: ' + soPhieu)
//
//GlobalVariable.order_id = soPhieu

WebUI.click(findTestObject('QuanLyKho/tab_aDynamicLocators', [('tabValue') : 'Hàng trong phiếu bán chưa được nhập kho']))

WebUI.delay(2)

WebUI.click(findTestObject('Common/checkbox_nameDynamicLocators', [('nameValue') : 'pcheck']))

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.delay(5)

try {
	WebUI.acceptAlert(FailureHandling.OPTIONAL)
	WebUI.comment('Alert xuất hiện và đã được accept')
} catch (Exception e) {
	WebUI.comment('Không có alert, tiếp tục chạy')
}

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Nhập kho thành công!']), 5)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu nhập kho trả hàng']), 5)

soPhieu = WebUI.getText(findTestObject('QuanLyKho/get_labelMaPhieu'))

println('Số phiếu: ' + soPhieu)

GlobalVariable.order_id = soPhieu


//Xóa file
CustomKeywords.'libKeyWords.PageObject.deleteFilesWithPrefixStartEnd'(pathFileDownload, startName, endName)

//Xuất file
WebUI.click(findTestObject('Object Repository/Common/button_buttonDynamicLocators', [('buttonName') : 'Xuất Excel']))

WebUI.click(findTestObject('Object Repository/QuanLyKho/li_aTextDynamicLocators', [('textValue') : 'Xuất phiếu nhập kho']))

WebUI.delay(5)

String capturedDownloadUrl = null

// Nếu mở tab download trung gian thì bắt URL để replay ở tab mới cùng session
try {
	String mainWindow = driver.getWindowHandle()
	Set<String> handles = driver.getWindowHandles()

	if (handles.size() > 1) {
		for (String h : handles) {
			if (h != mainWindow) {
				driver.switchTo().window(h)
				WebUI.delay(2)
				String curUrl = driver.getCurrentUrl()
				WebUI.comment("Download tab URL: " + curUrl)
				if (curUrl != null && curUrl.contains('sample_file_download.jsp')) {
					capturedDownloadUrl = curUrl
				}
				driver.close()
			}
		}
		driver.switchTo().window(mainWindow)
	}
} catch (Exception ex) {
	WebUI.comment("Lỗi khi xử lý tab download: " + ex.getMessage())
}

if (capturedDownloadUrl != null) {
	WebUI.comment('Thử tải file bằng cách mở URL download ở tab mới trong cùng session')
	try {
		String mainWindow = driver.getWindowHandle()
		driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB)
		driver.get(capturedDownloadUrl)
		WebUI.delay(8)
		driver.close()
		driver.switchTo().window(mainWindow)
	} catch (Exception replayEx) {
		WebUI.comment('Replay URL bằng tab mới thất bại: ' + replayEx.getMessage())
	}
} else {
	WebUI.comment('Không bắt được URL download trung gian, tiếp tục chờ file theo cách mặc định')
}

// Chờ file tải xong hẳn (tránh check quá sớm khi còn file .crdownload)
boolean downloadCompleted = false
for (int i = 0; i < 90; i++) {
	File folder = new File(pathFileDownload)
	File[] exportedFiles = folder.listFiles({ f ->
		f.isFile() && f.getName().startsWith(startName) && f.getName().endsWith(endName)
	} as FileFilter)
	File[] partialFiles = folder.listFiles({ f ->
		f.isFile() && f.getName().toLowerCase().endsWith('.crdownload')
	} as FileFilter)

	if (exportedFiles != null && exportedFiles.length > 0 && (partialFiles == null || partialFiles.length == 0)) {
		downloadCompleted = true
		WebUI.comment('Download completed: ' + exportedFiles[0].getName())
		break
	}

	WebUI.delay(1)
}

if (!downloadCompleted) {
	WebUI.comment('Hết thời gian chờ, chuyển sang bước check keyword để log chi tiết')
}

// Kiểm tra file đã được tải về
CustomKeywords.'libKeyWords.PageObject.checkFileDownloadedStartEnd'(pathFileDownload, startName, endName, 60)

WebUI.delay(2)


//Xóa phiếu sau khi test
WebUI.click(findTestObject('QuanLyKho/icon_closeDynamicLocators', [('titleName') : 'Sửa phiếu nhập kho trả hàng']))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), GlobalVariable.order_id)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Mã phiếu nhập']), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']))

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']), date)

WebUI.sendKeys(findTestObject('QuanLyKho/search_placeholderDynamicLocators', [('placeholderValue') : 'Khoảng thời gian lập']), Keys.chord(Keys.ENTER))

WebUI.delay(3)

String maPhieuCell = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Mã phiếu', 0, 'inputtbl')

String ngayNhap = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Ngày nhập', 0, 'inputtbl')

WebUI.verifyEqual(maPhieuCell, GlobalVariable.order_id)

WebUI.verifyEqual(ngayNhap, currentDate)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.delay(0.5)

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Xác nhận xóa phiếu nhập kho']), 3)

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast', [('buttonName') : 'Xác nhận']))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu.']), 2)

