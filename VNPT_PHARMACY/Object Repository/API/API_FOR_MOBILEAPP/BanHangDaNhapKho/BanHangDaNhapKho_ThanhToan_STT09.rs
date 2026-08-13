<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>BanHangDaNhapKho_ThanhToan_STT09</name>
   <tag></tag>
   <elementGuidId>7b74b15e-a417-4dcf-b4f8-345c7fe753d6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>${GlobalVariable.access_token}</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;ma_kh\&quot;: \&quot;8397\&quot;,\n  \&quot;tongdua\&quot;: 2414479,\n  \&quot;tongkm\&quot;:0,\n  \&quot;dsloaisp\&quot;: \&quot;${GlobalVariable.product_cat_id}\&quot;,\n  \&quot;dssoluong\&quot;: \&quot;1\&quot;,\n  \&quot;dsngayhh\&quot;: \&quot;${GlobalVariable.ds_phieunhap}\&quot;,\n  \&quot;dsgiaban\&quot;: \&quot;801493\&quot;,\n  \&quot;thungan\&quot;: \&quot;admin_huong6787\&quot;,\n  \&quot;dshdsd\&quot;:\&quot;công dụng giống thuốc lá ngón\&quot;,\n  \&quot;dslosx\&quot;:\&quot;all\&quot;,\n  \&quot;chuthich\&quot;:\&quot;KH đã đi tập thể dục\&quot;,\n  \&quot;partner\&quot;: \&quot;ios\&quot;,\n  \&quot;signature\&quot;: \&quot;de8fbc3e91ad577e60ea43a2e28e816f\&quot;\n}&quot;,
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
      <webElementGuid>3125e477-d00f-42f0-8f3d-45e4d6056845</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.access_token}</value>
      <webElementGuid>fa31355b-2e71-4173-949d-0f7b5e990a64</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.2.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://10.168.3.96/pharmacy_service_v2/selling/payment</restUrl>
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

//RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

//ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
