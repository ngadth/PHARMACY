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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.Arrays

WebUI.callTestCase(findTestCase('XuatKhoBanHang/UR021_XuatKho/TC19_XuatKhoMoi'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.delay(3)

//CustomKeywords.'libKeyWords.PageObject.openSubmenu'('QUẢN LÝ KHO', 'Nhập kho')
WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'QUẢN LÝ KHO']))

WebUI.click(findTestObject('Common/menu_aDynamicLocators', [('text') : 'Nhập kho']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Lập phiếu nhập kho']), 5)

WebUI.click(findTestObject('QuanLyKho/select_labelOptionDynamicLocators',[('labelValue'):'Loại phiếu nhập',('valueName'):'from_output']))

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Tra cứu giao dịch cần nhập kho trả hàng']), 5)

WebUI.verifyTextPresent(GlobalVariable.soPhieuXuat, false)


WebUI.click(findTestObject('QuanLyKho/btn_Chọn'))

WebUI.delay(5)

WebUI.sendKeys(findTestObject('QuanLyKho/input_labelDynamicLocators', [('labelValue') : 'Thủ kho nhập ']), 'Shop5')

WebUI.click(findTestObject('XuatKhoBanHang/button_lastDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Cập nhật dữ liệu thành công!']), 10)

WebUI.waitForElementVisible(findTestObject('Admin/Common/text_hDynamicLocators', [('text') : 'Sửa phiếu nhập kho']), 5)

WebUI.click(findTestObject('QuanLyKho/li_aTextDynamicLocators',[('textValue'):'Hàng trong phiếu xuất']))

WebUI.click(findTestObject('Common/checkbox_nameDynamicLocators',[('nameValue'):'pcheck']))

WebUI.click(findTestObject('QuanLyKho/button_textDynamicLocatorsLast',[('buttonName'):'Nhập kho']))

WebUI.waitForElementVisible(findTestObject('Common/noti_h4ThanhCong', [('text') : 'Nhập kho thành công!']), 5)
