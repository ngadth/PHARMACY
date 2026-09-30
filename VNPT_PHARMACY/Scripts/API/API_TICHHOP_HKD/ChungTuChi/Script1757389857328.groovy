import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ▶ Login once (fill GlobalVariable.access_token)
WebUI.callTestCase(findTestCase('API/API_TICHHOP_HKD/DangNhap'), [:], FailureHandling.STOP_ON_FAILURE)

//send request of api get spending
RequestObject req = findTestObject('API/API_TICHHOP_HKD/ChungTuChi')

def resp = WS.sendRequest(findTestObject('API/API_TICHHOP_HKD/ChungTuChi', [('access_token') : GlobalVariable.access_token]))

// 2) Read request dates (yyyyMMdd) and parse
String bodyRaw = req.getBodyContent()?.getText() ?: ''

Map bodyJson   = bodyRaw ? (Map) new JsonSlurper().parseText(bodyRaw) : [:]

def fromD = LocalDate.parse(bodyJson.fromDate.toString(), DateTimeFormatter.BASIC_ISO_DATE)

def toD = LocalDate.parse(bodyJson.toDate.toString(), DateTimeFormatter.BASIC_ISO_DATE)

// 3) Parse response and validate
def data = new JsonSlurper().parseText(resp.getResponseBodyContent())

def rows = data?.map?.rs instanceof List ? data.map.rs : []

def respFmt = DateTimeFormatter.ofPattern('dd/MM/yyyy')

def bad = rows.findAll({ def r ->
        def raw = r.NGAY_PHIEU_CHI.toString().trim()

        if (!(raw)) {
            return true
        }
        
        LocalDate d = LocalDate.parse(raw, respFmt)

        d.isBefore(fromD) || d.isAfter(toD)
    })

// 4) Report
if (bad.isEmpty()) {
    KeywordUtil.logInfo("✅ $rows.size() rows OK: NGAY_PHIEU_CHI within $fromD..$toD")
} else {
    KeywordUtil.markFailed('❌ Out of range NGAY_PHIEU_CHI: ' + bad*.NGAY_PHIEU_CHI)
}