<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags"%>
 
 
 <s:actionerror   theme="jquery"/>
 <s:actionmessage theme="jquery"/> 

<s:url id="remoteurl" action="messageList2" >

</s:url>




<sjg:grid
        loadonce="true"
        width="955"
	    id="gridDataTable"
    	caption="Customer Examples"
    	dataType="json"
    	href="%{remoteurl}"
    	gridModel="gridModel"
    	
	>

	<sjg:gridColumn  name="nomApplication"  title="nomApplication" sortable="true" />
	<sjg:gridColumn  name="nomDomaine" index="nomDomaine" title="nomDomaine" sortable="true" />
	<sjg:gridColumn name="type" index="type" title="type" sortable="true"  />
	<sjg:gridColumn name="message" index="message" title="message" sortable="true"  />
    <sjg:gridColumn name="dateEnvoi" index="dateEnvoi" title="dateEnvoi" sortable="true"  />


</sjg:grid>
        


<%--  <s:textarea label="lastDate" name="lastDate"></s:textarea> --%>
<%--  <s:textarea label="Selected" name="id"></s:textarea> --%>
<%--  <s:textarea label="Types" name="types"></s:textarea> --%>
<%-- <s:textarea label="firstDate"  name="firstDate"></s:textarea> --%>
<%-- <s:textarea label="lastDate" name="lastDate"></s:textarea> --%>
        