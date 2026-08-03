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

WebUI.callTestCase(findTestCase('API/API_TICHHOP_HKD/DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

//send request of api get receipt
RequestObject req = findTestObject('API/API_TICHHOP_HKD/ChungTuThu')

def resp = WS.sendRequest(findTestObject('API/API_TICHHOP_HKD/ChungTuThu', [('access_token') : GlobalVariable.access_token]))

// 2) Read request dates (yyyyMMdd) and parse
String bodyRaw = req.getBodyContent()?.getText() ?: ''

Map bodyJson = bodyRaw ? ((new JsonSlurper().parseText(bodyRaw)) as Map) : [:]

def fromD = LocalDate.parse(bodyJson.fromDate.toString(), DateTimeFormatter.BASIC_ISO_DATE)

def toD = LocalDate.parse(bodyJson.toDate.toString(), DateTimeFormatter.BASIC_ISO_DATE)

// 3) Parse response and validate
def data = new JsonSlurper().parseText(resp.getResponseBodyContent())

def rows = data?.map?.rs instanceof List ? data.map.rs : []

def respFmt = DateTimeFormatter.ofPattern('dd/MM/yyyy')

def bad = rows.findAll({ def r ->
        def raw = r.NGAY_PHIEU_THU.toString().trim()

        if (!(raw)) // treat missing as invalid
        {
            return true
        }
        
        LocalDate d = LocalDate.parse(raw, respFmt // <-- no .toLocalDate()
            )

        d.isBefore(fromD) || d.isAfter(toD)
    })

// 4) Report
if (bad.isEmpty()) {
    KeywordUtil.logInfo("✅ $rows.size() rows OK: NGAY_PHIEU_THU within $fromD..$toD")
} else {
    KeywordUtil.markFailed('❌ Out of range NGAY_PHIEU_THU: ' + bad*.NGAY_PHIEU_THU)
}