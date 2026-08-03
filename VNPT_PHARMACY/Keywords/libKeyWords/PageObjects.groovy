package libKeyWords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.*
import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable





public class PageObject {
	private final String xPathVisible = "[not(ancestor-or-self::*[contains(@class,'hid') or @aria-expanded='false' or contains(@class,'menu')])]";
	static WebDriver driver
	static WebElement element
	private static String timeNow = new String();

	public PageObject() {
		driver = DriverFactory.getWebDriver()
		timeNow = new String();
	}

	@Keyword
	def loginPage(String URL, String username, String password) {
		WebUI.navigateToUrl(URL)

		WebUI.maximizeWindow()

		WebUI.click(findTestObject('Common/button_advanced'))

		WebUI.click(findTestObject('Common/link_unsafe'))

		WebUI.setText(findTestObject('Common/input_username'), username)

		WebUI.setText(findTestObject('Common/input_password'), password)

		WebUI.click(findTestObject('Common/btn_DangNhap'))

		WebUI.waitForElementVisible(findTestObject('Common/logo_vnpt'), GlobalVariable.timeout)
	}

	@Keyword
	def deleteFilesWithPrefixStartEnd(String pathFileDownload, String startName, String endName) {
		File folder = new File(pathFileDownload)

		if (folder.exists() && folder.isDirectory()) {
			File[] matchingFiles = folder.listFiles({ file ->
				file.isFile() &&
						file.getName().startsWith(startName) &&
						file.getName().endsWith(endName)
			} as FileFilter)

			if (matchingFiles.length > 0) {
				for (File file : matchingFiles) {
					println("🔍 Tìm thấy file: ${file.getName()}")
					boolean deleted = file.delete()
					if (deleted) {
						println("✅ Đã xóa: ${file.getName()}")
					} else {
						println("❌ Không thể xóa: ${file.getName()}")
					}
				}
			} else {
				println("⚠️ Không tìm thấy file nào phù hợp trong '${pathFileDownload}'")
			}
		} else {
			println("❌ Thư mục không tồn tại hoặc không hợp lệ: ${pathFileDownload}")
		}
	}

	@Keyword
	def checkFileDownloadedStartEnd(String pathFileDownload, String startName, String endName, int timeoutInSeconds = 20) {
		boolean fileDownloaded = false

		for (int i = 0; i < timeoutInSeconds; i++) {
			try {
				DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(pathFileDownload))
				for (Path file : stream) {
					String fileName = file.getFileName().toString()
					if (Files.isRegularFile(file)
							&& fileName.startsWith(startName)
							&& fileName.endsWith(endName)) {

						KeywordUtil.markPassed("✅ File đã được tải: " + fileName)
						fileDownloaded = true
						break
					}
				}
			} catch (IOException e) {
				println("❌ Lỗi khi đọc thư mục: " + e.getMessage())
			}

			if (fileDownloaded) break
				WebUI.delay(1)
		}

		if (!fileDownloaded) {
			KeywordUtil.markFailed("❌ Không tìm thấy file bắt đầu bằng.. và kết thúc bằng '.xlsx' trong: " + pathFileDownload)
		}
	}

	@Keyword
	public static void openSubmenu(String parentMenu, String subMenu) {
		WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text') : parentMenu]))
		WebUI.waitForElementVisible(findTestObject('Common/menu_aDynamicLocators',[('text') : subMenu]), GlobalVariable.timeout)
		WebUI.click(findTestObject('Common/menu_aDynamicLocators',[('text') : subMenu]))
	}

	@Keyword
	def String getValueInTableByColumnName(String columnName, int index, String tableID) {

		WebDriver driver = DriverFactory.getWebDriver()

		// Lấy bảng
		WebElement table = driver.findElement(By.xpath("//table[@id='${tableID}']"))

		// Lấy danh sách header
		List<WebElement> headers = table.findElements(By.xpath(".//thead//th"))

		// Tìm index của cột
		int colIndex = 0
		for (int i = 0; i < headers.size(); i++) {
			String headerText = headers.get(i).getText().trim()
			if (headerText.equalsIgnoreCase(columnName.trim())) {
				colIndex = i + 1 // XPath index bắt đầu từ 1
				break
			}
		}

		// Lấy tất cả cell của cột
		List<WebElement> cells = table.findElements(By.xpath(".//tbody/tr/td[" + colIndex + "]"))
		String value = cells.get(index).getText()
		return value
	}


	@Keyword
	def String getCurrentDate() {
		Date today = new Date()
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
		return sdf.format(today)
	}

	//	public static boolean scrollIntoElementCenterView(TestObject TO) {
	//		try {
	//			element = WebUiCommonHelper.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//			JavascriptExecutor js = (JavascriptExecutor) driver;
	//			js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
	//			return true;
	//		}
	//		catch (Exception e) {
	//			try {
	//				takeWebElementScreenshot()
	//				return false;
	//			} catch (Exception e1) {
	//				e1.printStackTrace();
	//				System.out.println("***** INFO ***** CAPTURE FAILED.");
	//				return false;
	//			}
	//		}
	//	}
	//
	//	@Keyword
	//	public static void clickElement(TestObject TO) {
	//		try {
	//			hiddenTooltip()
	//			driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//			scrollIntoElementCenterView(TO)
	//			WebUI.waitForElementClickable(TO, GlobalVariable.waitElementVisiable)
	//			highlightElement(TO, 5)
	//			hiddenTooltip()
	//			WebUI.click(TO)
	//			hiddenTooltip()
	//			KeywordUtil.markPassed(TO.toString() + "Element has been clicked")
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			println(e.getMessage())
	//			KeywordUtil.markFailed(e.getMessage())
	//		}
	//	}
	//
	//
	//	@Keyword
	//	def uploadFile(TestObject TO, String filePath) {
	//		clickElement(TO);
	//		//		Thread.sleep(3000);
	//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		StringSelection ss = new StringSelection(filePath);
	//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	//		Robot robot = new Robot();
	//		robot.keyPress(KeyEvent.VK_ENTER);
	//		robot.keyRelease(KeyEvent.VK_ENTER);
	//		robot.keyPress(KeyEvent.VK_CONTROL);
	//		robot.keyPress(KeyEvent.VK_V);
	//		robot.keyRelease(KeyEvent.VK_V);
	//		robot.keyRelease(KeyEvent.VK_CONTROL);
	//		robot.keyPress(KeyEvent.VK_ENTER);
	//		robot.keyRelease(KeyEvent.VK_ENTER);
	//	}
	//
	//	@Keyword
	//	public static void ClickJS(TestObject TO) {
	//		//		WebElement element = WebUiCommonHelper.findWebElement(TO,30)
	//		//		System.out.println"log=" + (element.getText())
	//		//		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
	//
	//		element = WebUiCommonHelper.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//
	//		System.out.println("element=" + element.getText() );
	//		JavascriptExecutor js = (JavascriptExecutor) driver;
	//		js.executeScript("arguments[0].click();", element);
	//	}
	//
	//	@Keyword
	//	public static void ClickJS(WebElement element) {
	//		//		WebElement element = WebUiCommonHelper.findWebElement(TO,30)
	//		//		System.out.println"log=" + (element.getText())
	//		//		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
	//
	//		//		element = WebUiCommonHelper.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//		JavascriptExecutor js = (JavascriptExecutor) driver;
	//		js.executeScript("arguments[0].click();", element);
	//	}
	//
	//	@Keyword
	//	public static void clickElementV1(TestObject TO) {
	//		try {
	//			driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//			scrollIntoElementView(TO)
	//			//			WebUI.scrollToElement(TO, 3)
	//			WebUI.waitForElementClickable(TO, GlobalVariable.waitPresentTimeout)
	//			WebUI.delay(GlobalVariable.timeDelay)
	//			highlightElement(TO, 5)
	//			hiddenTooltip()
	//
	//			//			WebUI.click(TO)
	//
	//			ClickJS(TO)
	//			//			element = WebUiCommonHelper.findWebElement(TO,30)
	//			//			WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
	//
	//			KeywordUtil.markPassed(TO.toString() + "Element has been clicked")
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			System.err.println("ERROR="+e.getMessage());
	//			KeywordUtil.markFailed("Fail to click on element");
	//		}
	//	}
	//
	//	@Keyword
	//	public static void clickOnElement(String _xPath) {
	//		try {
	//			driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//			waitUntilElementEnable(_xPath, 90)
	//			element = driver.findElement(By.xpath(_xPath))
	//			highlightElement(_xPath)
	//			element.click()
	//			hiddenTooltip()
	//			KeywordUtil.markPassed(_xPath + "Element has been clicked")
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			KeywordUtil.markFailed("Fail to click on element")
	//		}
	//	}
	//
	//	@Keyword
	//	public static void clickOnElement1(String _xPath) {
	//		try {
	//			driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//			waitUntilElementEnable(_xPath, 90)
	//			element = driver.findElement(By.xpath(_xPath))
	//			highlightElement(_xPath)
	//			ClickJS(element)
	//			hiddenTooltip()
	//			KeywordUtil.markPassed(_xPath + "Element has been clicked")
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			KeywordUtil.markFailed("Fail to click on element")
	//		}
	//	}
	//
	@Keyword (keywordObject = "random")
	public static String randomString(String chars, int length) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return sb.toString();
	}
	//
	//	@Keyword
	//	public void setChkbox(String _xPathCheckBox, String _value) {
	//		if (_value.toLowerCase().equals("true") || _value.toLowerCase().equals("yes")
	//				|| _value.toLowerCase().equals("y")) {
	//			checkChkbox(_xPathCheckBox);
	//		} else {
	//			uncheckChkbox(_xPathCheckBox);
	//		}
	//	}
	//
	//	public void checkChkbox(String _xPathCheckBox) {
	//		System.out.println(_xPathCheckBox);
	//		if (!findElement(_xPathCheckBox).isSelected()) {
	//			clickOnElement(_xPathCheckBox);
	//		} else {
	//			highlightElement(_xPathCheckBox + "//ancestor-or-self::span[1]");
	//		}
	//	}
	//
	//	public void uncheckChkbox(String _xPathCheckBox) {
	//		if (findElement(_xPathCheckBox).isSelected()) {
	//			clickOnElement(_xPathCheckBox);
	//		} else {
	//			highlightElement(_xPathCheckBox + "//ancestor-or-self::span[1]");
	//		}
	//	}
	//
	//	@Keyword
	//	public static void verifyElementClickable(TestObject TO) {
	//		WebUI.waitForElementPresent(TO, 5)
	//		WebUI.verifyElementClickable(TO, FailureHandling.CONTINUE_ON_FAILURE)
	//	}
	//
	//	@Keyword
	//	public static void verifyElementNotClickable(TestObject TO) {
	//		WebUI.waitForElementPresent(TO, 5)
	//		WebUI.verifyElementNotClickable(TO, FailureHandling.CONTINUE_ON_FAILURE)
	//	}
	//
	//	@Keyword
	//	public static void setText_search(TestObject TO, String _value) {
	//		if(_value.contains("@NOW@")){
	//			if(timeNow == null || timeNow.equals("")) {
	//				SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss");
	//				Date date = new Date();
	//				timeNow = format.format(date);
	//			}
	//			_value = _value.replace("@NOW@", timeNow);
	//		}
	//		try {
	//			element = WebUiBuiltInKeywords.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//			highlightElement(TO, 5)
	//			ClickJS(TO)
	//			element.clear()
	//			element.sendKeys((_value), Keys.chord(Keys.ENTER))
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			KeywordUtil.markFailed("Fail to sendKey on element")
	//		}
	//	}
	//
	//	@Keyword
	//	public static String setTime() {
	//		SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss");
	//		Date date = new Date();
	//		timeNow = format.format(date);
	//		return timeNow;
	//	}
	//
	//	@Keyword
	//	public static void setText(TestObject TO, String _value) {
	//		if(_value.contains("@NOW@")){
	//			if(timeNow == null || timeNow.equals("")) {
	//				setTime();
	//			}
	//			_value = _value.replace("@NOW@", timeNow);
	//		}
	//		try {
	//			element = WebUiBuiltInKeywords.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//			highlightElement(TO, 5)
	//			element.clear()
	//			element.sendKeys(_value)
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			KeywordUtil.markFailed("Fail to sendKey on element")
	//		}
	//	}
	//
	//	@Keyword
	//	public static void setText_random(TestObject TO, String _value) {
	//		if(_value.contains("@NOW@")){
	//			if(timeNow == null || timeNow.equals("")) {
	//				SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss");
	//				Date date = new Date();
	//				timeNow = format.format(date);
	//			}
	//			_value = _value.replace("@NOW@", timeNow);
	//		}
	//		try {
	//			element = WebUiBuiltInKeywords.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//			highlightElement(TO, 5)
	//			element.clear()
	//			element = WebUiBuiltInKeywords.setText(TO, GlobalVariable.name_service)
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			KeywordUtil.markFailed("Fail to sendKey on element")
	//		}
	//	}
	//
	//	@Keyword
	//	public static void getText(TestObject TO) {
	//		try {
	//			WebUI.waitForPageLoad(GlobalVariable.waitForPageLoad)
	//			element = WebUiBuiltInKeywords.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//			highlightElement(TO, 5)
	//			element.getText()
	//			WebUI.delay(GlobalVariable.timeDelay)
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Element not found")
	//		} catch (Exception e) {
	//			KeywordUtil.markFailed("Fail to getText() on element")
	//		}
	//	}
	//
	//	@Keyword
	//	public static String getTextTbDataCellByPosition(String sRow, String _headerText) {
	//		int _rowIndex = getRowIndex(sRow)
	//		int _headerIndex = getTbColHeaderIndex(_headerText)
	//		String _xpath = xPathTbDataCellByPosition(_rowIndex, _headerIndex)
	//		element = findElement(_xpath)
	//		return element.getText()
	//	}
	//
	//	@Keyword
	//	public static String getTextSubTbDataCellByPosition(String sRow, String _headerText) {
	//		int _rowIndex = getRowIndex(sRow)
	//		int _headerIndex = getSubTbHeaderIndex(_headerText)
	//		String _xpath = xPathSubTbDataCellByPosition(_rowIndex, _headerIndex)
	//		element = findElement(_xpath)
	//		return element.getText()
	//	}
	//
	//	@Keyword
	//	public static boolean verifyEqual(Object expect, Object actual) {
	//		actual = String.valueOf(actual)
	//		expect = String.valueOf(expect)
	//		println("actual: " + actual + "_ expect: " +(expect))
	//		return actual.equals(expect)
	//	}
	//
	//	@Keyword
	//	public static boolean isElementExistNow(TestObject TO) {
	//		try {
	//			WebUI.verifyElementVisibleInViewport(TO, 10)
	//			return true
	//		} catch (Exception e) {
	//			return false
	//		}
	//		return false
	//	}
	//
	//	@Keyword
	//	public static boolean isElementExist(TestObject TO, int _TimeOutInSecond) {
	//		WebUI.waitForPageLoad(_TimeOutInSecond)
	//		WebUI.waitForElementVisible(TO, _TimeOutInSecond)
	//		return WebUI.verifyElementVisible(TO)
	//	}
	//
	//	@Keyword
	//	public static boolean isElementExist(String xPath, int _TimeOutInSecond) {
	//		try {
	//			WebUI.waitForPageLoad(_TimeOutInSecond)
	//			driver.findElement(By.xpath(xPath))
	//			return true
	//		} catch (Exception e) {
	//			return false
	//		}
	//		return false
	//	}
	//
	//	@Keyword
	//	public static String get_alert(TestObject TO) {
	//		highlightElement(TO, 3)
	//		//		String message="";
	//		//		if(isElementExist(TO, GlobalVariable.waitForPageLoad)){
	//		//			message = WebUI.getText(TO);
	//		//			System.out.println("***** INFO ***** Alert Message : [" + message + "]");
	//		//		} else {
	//		//			System.out.println("***** INFO ***** Alert Message not display.");
	//		//		}
	//		return WebUI.getText(TO);;
	//	}
	//
	//	@Keyword
	//	public static String get_message(TestObject TO) {
	//		highlightElement(TO, 5)
	//		String message="";
	//		if(isElementExist(TO, GlobalVariable.waitPresentTimeout)){
	//			message = WebUI.getText(TO);
	//			System.out.println("***** INFO ***** Message : [" + message + "]");
	//		} else {
	//			System.out.println("***** INFO ***** Message not display.");
	//		}
	//		return message;
	//	}
	//
	//	@Keyword
	//	public static boolean close_message(String _btnName) {
	//		String xPath = "//*[contains(@class,'oneui-modal-confirm-btns')]//*[contains(text(),'"+_btnName+"')]//parent::button";
	//		if(isElementExist(xPath, 3)){
	//			clickOnElement(xPath);
	//			return true;
	//		} else {
	//			System.out.println("***** INFO ***** Message not display. Can not click button : " + _btnName);
	//			return false;
	//		}
	//	}
	//
	//	public static boolean isYes(String _value) {
	//		_value = _value.toLowerCase();
	//		_value = _value.replace("@dialog@", "");
	//		return _value.equals("yes") || _value.equals("y") || _value.equals("co") || _value.equals("true") || _value.equals("dong y") || _value.equals("ok");
	//	}
	//
	//	public static boolean isNumeric(String str) {
	//		try {
	//			Integer.parseInt(str);
	//			return true;
	//		} catch (NumberFormatException e) {
	//			return false;
	//		}
	//	}
	//
	//	public static String xPathTbDataCellByPosition(int _rowIndex, int _headerIndex) {
	//		String _parentXpath = "//descendant-or-self::table[thead/tr]";
	//		String xPath = "(" + _parentXpath + "//tbody)//tr[contains(@class,'data-item')][" + _rowIndex + "]//td[" + _headerIndex + "]";
	//		//		highlightElement(xPath);
	//		System.out.println(xPath);
	//		return xPath;
	//	}
	//
	//	public static String xPathSubTbDataCellByPosition(int _rowIndex, int _headerIndex) {
	//		String _parentXpath = "//descendant-or-self::table[thead/tr]";
	//		String xPath = "(" + _parentXpath + "//tbody)//tr[contains(@class,'table-expanded-row')][" + _rowIndex + "]//td[not(contains(@class,'disable'))][" + _headerIndex + "]";
	//		highlightElement(xPath);
	//		System.out.println(xPath);
	//		return xPath;
	//	}
	//
	//	public static int getTbColHeaderIndex(String _headerText) {
	//		String _xPathHeaderCell = "//descendant-or-self::table//tr//descendant-or-self::th[contains(.,'" + _headerText + "')]";
	//		String _xpath = _xPathHeaderCell + "//preceding-sibling::th";
	//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		try {
	//			System.out.println(_xpath);
	//			List<WebElement> list = findElements(_xpath)
	//			System.out.println("getTbColHeaderIndex: " + list.size() + 1);
	//			return list.size() + 1
	//		} catch (Exception e) {
	//			return 0;
	//		}
	//	}
	//
	//	public static int getSubTbHeaderIndex(String _headerText) {
	//		String _xPathHeaderCell = "//descendant-or-self::table//tr[contains(@class,'table-expanded-row')]//descendant-or-self::th[contains(.,'" + _headerText + "')]";
	//		String _xpath = _xPathHeaderCell + "//preceding-sibling::th";
	//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		try {
	//			System.out.println(_xpath);
	//			List<WebElement> list = findElements(_xpath)
	//			System.out.println("getTbColHeaderIndex: " + list.size() + 1);
	//			return list.size() + 1
	//		} catch (Exception e) {
	//			return 0;
	//		}
	//	}
	//
	//	public static int getRowIndex(String sRow){
	//		int rowIndex = -1;
	//		if(isNumeric(sRow)){
	//			rowIndex = Integer.parseInt(sRow);
	//		} else if (sRow.contains("@ID@")){
	//			sRow = sRow.replace("@ID@", "");
	//			rowIndex = getTbRowIndexOfDataCell(sRow);
	//		} else {
	//			rowIndex = getTbRowIndexOfDataCell(sRow);
	//		}
	//		System.out.println(rowIndex);
	//		return rowIndex;
	//	}
	//
	//	public static int getTbRowIndexOfDataCell(String _givenText) {
	//		String _parentXpath = xPathTbDataCellByText(_givenText, 1)
	//		String _xpath =  _parentXpath + "/ancestor::tr[1]/preceding-sibling::tr"
	//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		try {
	//			System.out.println(_xpath);
	//			List<WebElement> list = findElements(_xpath)
	//			System.out.println("getTbRowIndexOfDataCell: " + list.size() + 1);
	//			return list.size() + 1
	//		} catch (Exception e) {
	//			return 0;
	//		}
	//	}
	//
	//	public static String xPathTbDataCellByText(String _givenText, int _cellOrder) {
	//		String _parentXpath = "//descendant-or-self::table";
	//		String[] aGivenText = _givenText.split(" ");
	//		String sSearchPattern = "";
	//		String xpath = "";
	//		int numText = aGivenText.length;
	//		if (numText > 1) {
	//			sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'"
	//			+ aGivenText[0] + "')]";
	//			for (int i = 1; i < numText; i++) {
	//				sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i]
	//				+ "') or contains(text(),'" + aGivenText[i] + "')]";
	//			}
	//			xpath = "(" + _parentXpath + "//tr//descendant-or-self::td[" + sSearchPattern + "])[" + _cellOrder + "]";
	//		} else {
	//			sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'" + _givenText + "')]]";
	//			xpath = "(" + _parentXpath + "//tr//descendant-or-self::td" + sSearchPattern + ")[" + _cellOrder + "]";
	//		}
	//		System.out.println(xpath);
	//		return xpath;
	//	}
	//
	//	public static void actionTbRow(String sRow, String sAction) {
	//		int rowIndex = getRowIndex(sRow);
	//		String xPath = "(//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')][" + rowIndex + "]//button[contains(.,'" + sAction + "')]" ;
	//		clickOnElement(xPath);
	//	}
	//
	//	@Keyword
	//	public static void actionOpenTbRow(String sRow) {
	//		int rowIndex = getRowIndex(sRow);
	//		String xPath = "(//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')][" + rowIndex + "]//button[contains(@class,'expand')]" ;
	//		clickOnElement(xPath);
	//	}
	//
	//	public static void actionRemoveTbRow(String sRow) {
	//		String xPath = ""
	//		if(sRow.contains("@dialog@")){
	//			xPath = "//*[@class='ui-helper-hidden-accessible']//following::div" + xPath;
	//			sRow = sRow.replace("@dialog@", "");
	//		}
	//		int rowIndex = getRowIndex(sRow);
	//		xPath = "(" + xPath + "//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')]["+rowIndex+"]//td[contains(@class,'table-cell')]//ancestor::tr//*[contains(@class,'Delete')]//ancestor::button" ;
	//		System.out.println(xPath);
	//		clickOnElement(xPath);
	//	}
	//
	//	public static void actionEditTbRow(String sRow) {
	//		String xPath = ""
	//		if(sRow.contains("@dialog@")){
	//			xPath = "//*[@class='ui-helper-hidden-accessible']//following::div" + xPath;
	//			sRow = sRow.replace("@dialog@", "");
	//		}
	//		int rowIndex = getRowIndex(sRow);
	//		xPath = "(" + xPath + "//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')]["+rowIndex+"]//td[contains(@class,'table-cell')]//ancestor::tr//*[contains(@class,'Edit')]//ancestor::button" ;
	//		System.out.println(xPath);
	//		clickOnElement(xPath);
	//	}
	//
	//	public static void actionSendRequestTbRow(String sRow) {
	//		String xPath = ""
	//		if(sRow.contains("@dialog@")){
	//			xPath = "//*[@class='ui-helper-hidden-accessible']//following::div" + xPath;
	//			sRow = sRow.replace("@dialog@", "");
	//		}
	//		int rowIndex = getRowIndex(sRow);
	//		xPath = "(" + xPath + "//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')]["+rowIndex+"]//td[contains(@class,'table-cell')]//ancestor::tr//*[contains(@class,'Send')]//ancestor::button" ;
	//		System.out.println(xPath);
	//		clickOnElement(xPath);
	//	}
	//
	//	public static void actionApprovedTbRow(String sRow) {
	//		String xPath = ""
	//		if(sRow.contains("@dialog@")){
	//			xPath = "//*[@class='ui-helper-hidden-accessible']//following::div" + xPath;
	//			sRow = sRow.replace("@dialog@", "");
	//		}
	//		int rowIndex = getRowIndex(sRow);
	//		xPath = "(" + xPath + "//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')]["+rowIndex+"]//td[contains(@class,'table-cell')]//ancestor::tr//*[contains(@class,'ChoiceColumn') or contains(@class,'EventToDoLogo')]//ancestor::button" ;
	//		System.out.println(xPath);
	//		clickOnElement(xPath);
	//	}
	//
	//	public static void actionRejectTbRow(String sRow) {
	//		String xPath = ""
	//		if(sRow.contains("@dialog@")){
	//			xPath = "//*[@class='ui-helper-hidden-accessible']//following::div" + xPath;
	//			sRow = sRow.replace("@dialog@", "");
	//		}
	//		int rowIndex = getRowIndex(sRow);
	//		xPath = "(" + xPath + "//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')]["+rowIndex+"]//td[contains(@class,'table-cell')]//ancestor::tr//*[contains(@class,'ErrorBadge')]//ancestor::button" ;
	//		System.out.println(xPath);
	//		clickOnElement(xPath);
	//	}
	//
	//	public static void actionUpgradeTbRow(String sRow) {
	//		String xPath = ""
	//		if(sRow.contains("@dialog@")){
	//			xPath = "//*[@class='ui-helper-hidden-accessible']//following::div" + xPath;
	//			sRow = sRow.replace("@dialog@", "");
	//		}
	//		int rowIndex = getRowIndex(sRow);
	//		xPath = "(" + xPath + "//descendant-or-self::table[thead/tr]//tbody)//tr[contains(@class,'data-item')]["+rowIndex+"]//td[contains(@class,'table-cell')]//ancestor::tr//*[contains(@class,'UpgradeAnalysis')]//ancestor::button" ;
	//		System.out.println(xPath);
	//		clickOnElement(xPath);
	//	}
	//
	//	public static int getTbCountDataRow() {
	//		String _parentXpath = "//div[@class='oneui-table']"
	//		try {
	//			return findTbAllDataRows(_parentXpath).size();
	//		} catch (Exception e) {
	//			return 0;
	//		}
	//	}
	//
	//	public static String xPathTbGetAllDataRows(String _parentXpath) {
	//		//		_parentXpath += "";
	//		return _parentXpath + "//descendant-or-self::table[thead]//tbody//tr[contains(@class,'data-item')]//td[contains(@class,'table-cell')]//ancestor::tr";
	//	}
	//
	//	public static List<WebElement> findTbAllDataRows(String _parentXpath) {
	//		_parentXpath = xPathTbGetAllDataRows(_parentXpath)
	//		List<WebElement> list = DriverFactory.getWebDriver().findElements(By.xpath(_parentXpath))
	//		println(_parentXpath)
	//		println(list)
	//		return list;
	//	}
	//
	//	public static List<WebElement> findElements (String _xpath){
	//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		return DriverFactory.getWebDriver().findElements(By.xpath(_xpath))
	//	}
	//
	//	public static WebElement findElement (String _xpath){
	//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		return DriverFactory.getWebDriver().findElement(By.xpath(_xpath))
	//	}
	//
	//	public static boolean waitUntilElementVisible(String xPath, String sKey, int _timeoutInSeconds) {
	//		try {
	//			long _timeoutInMilliseconds = _timeoutInSeconds * 1000
	//			WebUiCommonHelper.sleep(_timeoutInSeconds * 1000)
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			System.out.println("***** INFO ***** ELEMENT NOT PRESENCE FOR OVER " + _timeoutInSeconds + "SECONDS.");
	//			return false;
	//		}
	//	}
	//
	//	public static boolean highlightElement(TestObject TO, int _timeoutInSeconds) {
	//		try {
	//			element = WebUiCommonHelper.findWebElement(TO, _timeoutInSeconds);
	//			JavascriptExecutor js = (JavascriptExecutor) driver;
	//			js.executeScript("arguments[0].setAttribute('style','border: solid 1px red');", element);
	//			return true;
	//		} catch (Exception e) {
	//			try {
	//				takeWebElementScreenshot()
	//				return false;
	//			} catch (Exception e1) {
	//				e1.printStackTrace();
	//				System.out.println("***** INFO ***** CAPTURE FAILED.");
	//				return false;
	//			}
	//		}
	//	}
	//
	//	public static boolean highlightElement(String xpath) {
	//		//		driver.manage().timeouts().implicitlyWait(GlobalVariable.waitElementVisiable, TimeUnit.SECONDS);
	//		waitForElementvisible(xpath, GlobalVariable.waitPresentTimeout)
	//		element = driver.findElement(By.xpath(xpath))
	//		try {
	//			KeywordUtil.logInfo("highlightElement")
	//			JavascriptExecutor js = (JavascriptExecutor) driver;
	//			js.executeScript("arguments[0].setAttribute('style','border: solid 1px red');", element);
	//			return true;
	//		} catch (Exception e) {
	//			try {
	//				takeWebElementScreenshot()
	//				return false;
	//			} catch (Exception e1) {
	//				e1.printStackTrace();
	//				System.out.println("***** INFO ***** CAPTURE FAILED.");
	//				return false;
	//			}
	//		}
	//	}
	//
	//	public static boolean scrollIntoElementView(TestObject TO) {
	//		try {
	//			element = WebUiCommonHelper.findWebElement(TO, GlobalVariable.waitPresentTimeout);
	//			JavascriptExecutor js = (JavascriptExecutor) driver;
	//			js.executeScript("arguments[0].scrollIntoView(false);", element);
	//			return true;
	//		} catch (Exception e) {
	//			try {
	//				takeWebElementScreenshot()
	//				return false;
	//			} catch (Exception e1) {
	//				e1.printStackTrace();
	//				System.out.println("***** INFO ***** CAPTURE FAILED.");
	//				return false;
	//			}
	//		}
	//	}
	//
	//	public static String getNow (){
	//		return timeNow;
	//	}
	//
	//	public static void takeWebElementScreenshot() {
	//		WebUI.takeScreenshot( System.getProperty("user.dir") + "/TestResults/Image_" + getNow() + '.PNG')
	//	}
	//
	//	public static boolean waitForElementvisible(String xPath, int _timeoutInSeconds){
	//		try {
	//			WebDriverWait wait = new WebDriverWait(driver, 60)
	//			wait.withTimeout(_timeoutInSeconds, TimeUnit.SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)))
	//			return true;
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			System.out.println("***** INFO ***** ELEMENT NOT PRESENCE FOR OVER " + _timeoutInSeconds + "SECONDS.");
	//			return false;
	//		}
	//	}
	//
	//	public static boolean waitUntilElementEnable(String xPath, int _timeoutInSeconds) {
	//		try {
	//			WebDriverWait wait = new WebDriverWait(driver, 60)
	//			wait.withTimeout(_timeoutInSeconds, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))
	//			return true;
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			System.out.println("***** INFO ***** ELEMENT NOT ENABLE FOR OVER " + _timeoutInSeconds + "SECONDS.");
	//			return false;
	//		}
	//	}
	//
	//	public static boolean hiddenTooltip() {
	//		String xPath = "//descendant-or-self::div[contains(@class,'oneui-tooltip-placement')]"
	//		if(isElementExist(xPath, GlobalVariable.waitPresentTimeout)) {
	//			element = driver.findElement(By.xpath(xPath))
	//			try {
	//				JavascriptExecutor js = (JavascriptExecutor) driver;
	//				js.executeScript("arguments[0].setAttribute('style','display:none;')", element);
	//				return true;
	//			} catch (Exception e) {
	//				try {
	//					takeWebElementScreenshot()
	//					return false;
	//				} catch (Exception e1) {
	//					e1.printStackTrace();
	//					System.out.println("***** INFO ***** CAPTURE FAILED.");
	//					return false;
	//				}
	//			}
	//		}
	//	}
	//
	//	public static String covertToString(String value) {
	//		try {
	//			String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
	//			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	//			return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").replaceAll(" ", "_");
	//		} catch (Exception ex) {
	//			ex.printStackTrace();
	//		}
	//		return null;
	//	}
	//
	//	public String sTextPredicates(String _givenText) {
	//		String[] tokens = _givenText.split("\"|\\'| ");
	//		int numText = tokens.length;
	//		String sSearchPattern = "";
	//		if (numText > 1) {
	//			sSearchPattern = "[contains(.,'" + tokens[0] + "')";
	//			for (int i = 1; i < numText; i++) {
	//				sSearchPattern += " and contains(.,'" + tokens[i] + "')";
	//			}
	//			return sSearchPattern + "and string-length(normalize-space(translate(., '\u00A0', ''))) < "
	//			+ (int) (_givenText.length() + 5) + "]";
	//		} else {
	//			return "[contains(.,'" + _givenText + "') and string-length(normalize-space()) < " + (int) (_givenText.length() + 5) + "]";
	//		}
	//	}
	//
	//	public String xPathChkboxWithLabel(String _parentXpath, String _labelName, int _labelOrder, int _resOrder) {
	//		println("(" + _parentXpath + "//*[self::div or self::label]" + sTextPredicates(_labelName) + xPathVisible + ")["
	//				+ _labelOrder + "]//input[@type='checkbox'][" + _resOrder + "]");
	//		return "(" + _parentXpath + "//*[self::div or self::label]" + sTextPredicates(_labelName) + xPathVisible + ")[" + _labelOrder + "]//input[@type='checkbox'][" + _resOrder + "]";
	//	}
	//
	//	@Keyword
	//	public static void clickSubmenu(String parentMenu, String subMenu) {
	//		String vOpen= WebUI.getAttribute(findTestObject('Common/text_attributeMenu',[('0') : parentMenu]), 'ng-reflect-v-open')
	//		println(vOpen)
	//		if (vOpen == "false") {
	//			WebUI.click(findTestObject('Common/text_menu',[('0') : parentMenu]))
	//			WebUI.delay(1) // chờ animation hoặc xử lý DOM
	//		}
	//		// Đảm bảo submenu hiển thị rồi mới click
	//		WebUI.waitForElementVisible(findTestObject('Common/text_menu',[('0') : subMenu]), GlobalVariable.timeout)
	//		WebUI.click(findTestObject('Common/text_menu',[('0') : subMenu]))
	//	}
	//
	//	@Keyword
	//	def String getRandomTwoLetters() {
	//		String alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	//		Random random = new Random()
	//		String result = ''
	//		for (int i = 0; i < 2; i++) {
	//			int index = random.nextInt(alphabet.length())
	//			result += alphabet.charAt(index)
	//		}
	//		return result
}

