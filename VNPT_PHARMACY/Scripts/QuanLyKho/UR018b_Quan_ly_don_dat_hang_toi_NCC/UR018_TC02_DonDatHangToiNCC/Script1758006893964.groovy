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

String donVi = 'shop6-CH 6'

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Đơn đặt hàng tới NCC')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : ' Thêm mới']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập đơn đặt hàng']), 5)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHYPE9kTcbV5Etw6Etk5m..']), 
    'SHOP6-CH 6', false)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : 'cbbNhacungung']), '001_NT Gia Huy', 
    false)

String currentDate = CustomKeywords.'libKeyWords.PageObject.getCurrentDate'()

String date = (currentDate + ' - ') + currentDate

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXU3bbTBLXTO..']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXU3bbTBLXTO..']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRcTXU3bbTBLXTO..']), Keys.chord(Keys.ENTER))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwOBPaDcAvDm..']), 'Đà Nẵng')

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRc9w5O..']), 'Giao hàng tận nơi')

WebUI.click(findTestObject('QuanLyKho/tab_hangHoaTrongDonHang'))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwRctj5O..']), '209236')

WebUI.click(findTestObject('XuatKhoBanHang/data_index', [('value') : '0']))

WebUI.click(findTestObject('QuanLyKho/input_idDynamicLocators', [('idValue') : 'txtSoluong209237']))

WebUI.clearText(findTestObject('QuanLyKho/input_idDynamicLocators', [('idValue') : 'txtSoluong209237']))

WebUI.sendKeys(findTestObject('QuanLyKho/input_idDynamicLocators', [('idValue') : 'txtSoluong209237']), '2')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Cập nhật']))

WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlRzHa53HbDb9f5o..']), 
    'SHOP6-CH 6', false)

WebUI.selectOptionByLabel(findTestObject('Common/dropdown_selectDynamicLocators', [('idValue') : '4yHlRcTxCyba43Pe4B1d3yba']), 
    'Hà Thái Bảo(baoht)', false)

WebUI.click(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwScAnTBAvTsPXTES.']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwScAnTBAvTsPXTES.']), currentDate)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'TFXwScAnTBAvTsPXTES.']), Keys.chord(Keys.ENTER))

String donViDatHang = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Đơn vị đặt hàng', 0, 'order')

WebUI.verifyEqual(donViDatHang, donVi)

