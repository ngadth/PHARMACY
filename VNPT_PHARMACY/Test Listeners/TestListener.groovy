import java.text.SimpleDateFormat

import org.apache.commons.io.FileUtils

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.logging.model.TestSuiteLogRecord
import com.kms.katalon.core.reporting.ReportWriterUtil
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.util.WebDriverCleanerUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

class TestListener {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		
		KeywordUtil.logInfo(testCaseContext.getTestCaseId())
		KeywordUtil.logInfo(testCaseContext.getTestCaseStatus())

		def status = testCaseContext.getTestCaseStatus()
		GlobalVariable.testsTotal++
		if (status == 'FAILED') {
			GlobalVariable.testsFailed++
		}
		if (status == 'PASSED'){
			GlobalVariable.testsPassed++
		}
		if (status == 'ERROR'){
			GlobalVariable.testsError++
		}
		
		WebUI.closeBrowser()
	}
	
//	def sendTelegramMessage(String message, String chatId, String botToken) {
//		ProcessBuilder processBuilder = new ProcessBuilder();
//		processBuilder.command("curl", "-X", "POST", "https://api.telegram.org/" + botToken + "/sendMessage", "-d", "chat_id=" + chatId, "-d", "text=" + URLEncoder.encode(message), "-d", "parse_mode=HTML");
//
//		try {
//
//			Process process = processBuilder.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	def sendTelegramMessage(String message, String chatId, String botToken) {
		ProcessBuilder processBuilder = new ProcessBuilder()
	
		String proxyUrl = "socks5h://14ac09b5bbc47:399f0c6925@181.215.26.230:12324"
		String apiUrl = "https://api.telegram.org/${botToken}/sendMessage"
	
		processBuilder.command("curl",
//			"--proxy", proxyUrl,
			"-X", "POST", apiUrl,
			"-d", "chat_id=" + chatId,
			"-d", "text=" + URLEncoder.encode(message, "UTF-8"),
			"-d", "parse_mode=HTML")
	
		try {
			Process process = processBuilder.start()
			process.waitFor()
		} catch (IOException | InterruptedException e) {
			e.printStackTrace()
		}
	}
//	def sendTelegramFile(String filePath, String caption, String chatId, String botToken) {
//		ProcessBuilder processBuilder = new ProcessBuilder();
//		processBuilder.command("curl", "-v","-F", "caption=" + caption, "-F", "document=@"+ filePath, "https://api.telegram.org/"+ botToken +"/sendDocument", "-F", "chat_id="+ chatId);
//		try {
//
//			Process process = processBuilder.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	def sendTelegramFile(String filePath, String caption, String chatId, String botToken) {
		ProcessBuilder processBuilder = new ProcessBuilder()
	
		String proxyUrl = "socks5h://14ac09b5bbc47:399f0c6925@181.215.26.230:12324"
		String apiUrl = "https://api.telegram.org/${botToken}/sendDocument"
	
		processBuilder.command("curl", "-v",
//			"--proxy", proxyUrl,
			"-F", "caption=" + caption,
			"-F", "document=@" + filePath,
			"-F", "chat_id=" + chatId,
			apiUrl)
	
		try {
			Process process = processBuilder.start()
			process.waitFor()
		} catch (IOException | InterruptedException e) {
			e.printStackTrace()
		}
	}
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */

	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		System.out.println("Failed: " + GlobalVariable.testsFailed)
		System.out.println("Pass: " + GlobalVariable.testsPassed)
		System.out.println("Error: " + GlobalVariable.testsError)

		String outputPdf = "";

		try {
			FileUtils.copyDirectory(new File(RunConfiguration.getReportFolder()), new File(RunConfiguration.getReportFolder() + '_tmp'))
			File folderTmp = new File(RunConfiguration.getReportFolder())
			String pathFolderTmp = folderTmp.getAbsolutePath()
			
			TestSuiteLogRecord suiteLogEntity = ReportWriterUtil.parseTestSuiteLog(pathFolderTmp);
			ReportWriterUtil.writePdfReport(suiteLogEntity, folderTmp);
			
			outputPdf = pathFolderTmp + "\\" + folderTmp.getName() + ".pdf"

		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuilder strMessage = new StringBuilder().append("Success: ").append(GlobalVariable.testsPassed).append("\n").append("Failed: ").append(GlobalVariable.testsFailed).append("\n").append("Error: ").append(GlobalVariable.testsError);
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		String testSuiteId = testSuiteContext.getTestSuiteId()
		String testSuiteName = testSuiteId.substring(testSuiteId.lastIndexOf("/") + 1)
		
		StringBuilder strMessageNew = new StringBuilder().append("Ngày ").append(simpleDate.format(new Date())).append(" thực hiện <b>").append(" Web UI Automation Testing " + testSuiteName + "</b>:\n");
		strMessageNew.append("- Tổng số TestCase đã chạy là: ").append(GlobalVariable.testsTotal).append(" TestCase\n");
		strMessageNew.append("- Tổng số TestCase PASSED là: ").append(GlobalVariable.testsPassed).append(" TestCase\n");
		strMessageNew.append("- Tổng số TestCase FAILED là: ").append(GlobalVariable.testsFailed).append(" TestCase");


		// Send Result
//		sendTelegramMessage(strMessageNew.toString(), "830548884", 'bot5028236627:AAE0hNdvDFIy_kPM5kEaiCFLKYnGri3hNmg');
		sendTelegramMessage(strMessageNew.toString(), GlobalVariable.GROUP_ID, GlobalVariable.API_BOT);

		if (outputPdf != "") {
//			sendTelegramFile(outputPdf, "File ket qua test ","830548884", 'bot5028236627:AAE0hNdvDFIy_kPM5kEaiCFLKYnGri3hNmg')
			sendTelegramFile(outputPdf, "File ket qua test_VNPT Pharmacy ", GlobalVariable.GROUP_ID, GlobalVariable.API_BOT)
		}


	}

}