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

String columnTable = 'Chứng từ;Ngày NK'

WebUI.callTestCase(findTestCase('Common/UR001_DangNhap/UR001_TC01_DangNhapThanhCong'), [:], FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Common/li_idDynamicLocators', [('idValue') : 'more']))

//WebUI.click(findTestObject('Common/menu_baoCao'))
//
//WebUI.click(findTestObject('Common/submenu_baoCaoKho'))
CustomKeywords.'libKeyWords.PageObject.openSubmenu'('BÁO CÁO', 'Báo cáo kho')

WebUI.verifyElementVisible(findTestObject('BaoCaoKho/text_bangKePhieuNhap'))

String[] subStr = columnTable.split(';')

for (int i = 0; i < subStr.length; i++) {
    WebUI.verifyElementPresent(findTestObject('Common/text_thDynamicLocators', [('text') : subStr[i]]), 10)
}

WebUI.click(findTestObject('BaoCaoKho/dropdown_luaChonKho'))

WebUI.click(findTestObject('XuatKhoBanHang/option_cuaHang'))

WebUI.click(findTestObject('Common/input_theoKhoangThoiGian'))

WebUI.click(findTestObject('BaoCaoKho/button_xoa'))

WebUI.setText(findTestObject('BaoCaoKho/input_theoTuKhoaLoaiHang'), 'ỐNG TIÊM 5 ML')

WebUI.delay(3)

//
//WebUI.setText(findTestObject('XuatKhoBanHang/input_soHDDT'), '239')
//
WebUI.sendKeys(findTestObject('Object Repository/Input_Field'), Keys.chord(Keys.ENTER))

//
WebUI.verifyTextPresent('Tổng số bản ghi', true)

