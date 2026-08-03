import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('API/API_CungCapCho_HKD/DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

// 1. Send request
def response = WS.sendRequest(findTestObject('API/API_CungCapCho_HKD/DongBoChungTuThuChi_get_spending', [('url') : GlobalVariable.url_hkd]))

// 2. Verify status code
WS.verifyResponseStatusCode(response, 200)

// 3. Print full response (RAW)
KeywordUtil.logInfo('===== RESPONSE BODY =====')

KeywordUtil.logInfo(response.getResponseBodyContent())

KeywordUtil.logInfo('=========================')

// 4. Parse response JSON
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// 5. Get list rs
def rsList = json?.map?.rs instanceof List ? json.map.rs : []

assert rsList.size() > 0 : '❌ Danh sách rs rỗng'

// 6. Regex Text + Number
def pattern = ~('^[A-Za-z]+\\d+$') 

// 7. Lưu danh sách SO_PHIEU_CHI
List<String> soPhieuChiList = []

// 8. Check & lấy dữ liệu
rsList.eachWithIndex({ def item, def idx ->
        def soPhieuChi = item.SO_PHIEU_CHI.toString().trim()

        KeywordUtil.logInfo("Row $idx - SO_PHIEU_CHI = $soPhieuChi")

        assert soPhieuChi

        assert soPhieuChi ==~ pattern

        soPhieuChiList.add(soPhieuChi)
    })

// 9. Log kết quả cuối
KeywordUtil.logInfo("✅ Danh sách SO_PHIEU_CHI hợp lệ: $soPhieuChiList")

