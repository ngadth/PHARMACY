import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Admin/Common/TC01_DangNhap'), [:], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'libKeyWords.PageObject.openSubmenu'('HỆ THỐNG', 'Quản lý quyền (ROLE)')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Thêm mới']))

String roleName = 'AUTOMATION_ADMIN'

WebUI.waitForElementVisible(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'role_id']), 10)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'role_id']), roleName)

WebUI.sendKeys(findTestObject('Admin/Common/input_idDynamicLocators', [('idValue') : 'role_description']), 'Quyền admin của tester automation')

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Lưu']))

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'role_id']), roleName)

WebUI.sendKeys(findTestObject('Common/input_idDynamicLocators', [('idValue') : 'role_id']), Keys.chord(Keys.ENTER))

String value = CustomKeywords.'libKeyWords.PageObject.getValueInTableByColumnName'('Tên Role', 0, 'role_tbl')

WebUI.verifyEqual(value, roleName)

WebUI.mouseOver(findTestObject('Admin/Common/btn_action'))

WebUI.click(findTestObject('Common/option_aDynamicLocators', [('optionName') : 'Xóa Role']))

WebUI.click(findTestObject('Common/button_buttonDynamicLocators', [('buttonName') : 'Xác nhận xóa']))

WebUI.verifyElementPresent(findTestObject('Common/text_tdDynamicLocators', [('text') : 'Không có dữ liệu']), 0)

