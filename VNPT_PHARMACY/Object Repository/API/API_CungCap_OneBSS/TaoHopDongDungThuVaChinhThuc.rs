<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>TaoHopDongDungThuVaChinhThuc</name>
   <tag></tag>
   <elementGuidId>3d8ffacb-0268-43fd-a42f-44169a61739e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;transId\&quot;: \&quot;16068461\&quot;,\n    \&quot;sme\&quot;: {\n      \&quot;subscriptionCode\&quot;: \&quot;${randomUUID}\&quot;,\n      \&quot;provinceCode\&quot;: \&quot;DNG\&quot;,\n      \&quot;newProvinceCode\&quot;: \&quot;HCM\&quot;,\n      \&quot;name\&quot;: \&quot;Nhà thuốc test\&quot;,\n      \&quot;businessLicenseType\&quot;: \&quot;DN\&quot;,\n      \&quot;businessLicenseNo\&quot;: \&quot;7348587351\&quot;,\n      \&quot;paymentName\&quot;: \&quot;Nhà thuốc test\&quot;,\n      \&quot;taxCode\&quot;: \&quot;088614535223\&quot;,\n      \&quot;licenseAddress\&quot;: \&quot;An Phú, Thị Trấn Chúc Sơn, Huyện Chương Mỹ, Hà Nội\&quot;,\n      \&quot;paymentAddress\&quot;: \&quot;An Phú, Thị Trấn Chúc Sơn, Huyện Chương Mỹ, Hà Nội\&quot;,\n      \&quot;wholesaler\&quot;: \&quot;N\&quot;,\n      \&quot;priceByBatch\&quot;: \&quot;N\&quot;\n    },\n    \&quot;represent\&quot;: {\n      \&quot;name\&quot;: \&quot;Long\&quot;,\n      \&quot;gender\&quot;: \&quot;M\&quot;,\n      \&quot;birthDate\&quot;: \&quot;21/10/1982\&quot;,\n      \&quot;position\&quot;: \&quot;Chuyen vien\&quot;,\n      \&quot;identityType\&quot;: \&quot;CCCD\&quot;,\n      \&quot;identityNo\&quot;: \&quot;088614535234\&quot;,\n      \&quot;dateOfIssue\&quot;: \&quot;21/10/2020\&quot;,\n      \&quot;placeOfIssue\&quot;: \&quot;Cục Cảnh sát quản lý hành chính về trật tự xã hội\&quot;,\n      \&quot;email\&quot;: \&quot;long.lh8x@gmail.com\&quot;,\n      \&quot;phoneNumber\&quot;: \&quot;0886145352\&quot;\n    },\n    \&quot;contract\&quot;: {\n      \&quot;contractType\&quot;: \&quot;OFFICIAL\&quot;,\n      \&quot;effectiveDate\&quot;: \&quot;05/08/2027\&quot;,\n      \&quot;initMonth\&quot;: \&quot;1\&quot;,\n      \&quot;shopQuantity\&quot;: \&quot;1\&quot;,\n      \&quot;packType\&quot;: \&quot;3\&quot;,\n      \&quot;amEmail\&quot;: \&quot;long.lh8x@gmail.com\&quot;\n    }\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>78de157f-ded0-44b9-a69c-9a0461fef0c8</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.access_token}</value>
      <webElementGuid>4207b152-cfd1-4e19-a74a-d50d7de6d83b</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.4.3</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://10.168.3.96/pharmacy_service_v2/contract/register</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
