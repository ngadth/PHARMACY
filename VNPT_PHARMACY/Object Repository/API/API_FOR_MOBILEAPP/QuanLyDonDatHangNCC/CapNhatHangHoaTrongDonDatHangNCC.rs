<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CapNhatHangHoaTrongDonDatHangNCC</name>
   <tag></tag>
   <elementGuidId>a27a96ad-2e34-45a3-9069-5c8f830010b3</elementGuidId>
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
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;order_id\&quot;: \&quot;${GlobalVariable.order_id}\&quot;,\n    \&quot;product_json\&quot;: \&quot;{        \\\&quot;total\\\&quot;: \\\&quot;2\\\&quot;,        \\\&quot;lsp1\\\&quot;: {            \\\&quot;id\\\&quot;: \\\&quot;70\\\&quot;,            \\\&quot;sl\\\&quot;: \\\&quot;1\\\&quot;,            \\\&quot;price\\\&quot;:\\\&quot;6000\\\&quot;},        \\\&quot;lsp2\\\&quot;: {            \\\&quot;id\\\&quot;: \\\&quot;78\\\&quot;,            \\\&quot;sl\\\&quot;: \\\&quot;1\\\&quot;,            \\\&quot;price\\\&quot;: \\\&quot;7000\\\&quot;}}\&quot;\n}&quot;,
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
      <webElementGuid>e0e722c4-94f9-419a-a5a9-2d2418f62517</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${GlobalVariable.access_token}</value>
      <webElementGuid>eb9d6439-1eec-48a6-a7fd-02c5abff9ccf</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://10.168.3.96/pharmacy_service_v2/supplier_order/edit_product_in_order</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
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
