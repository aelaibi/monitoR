<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript" src="<s:url value='/js/message/message.js'/>" ></script>


<form id="form1" class="form-inline" style="margin-top: 40px;" action="searchWithDate">

	<fieldset>
		<legend>Filter les messages entre deux date :</legend>
	</fieldset>
	<label class="control-label" for="dateFirst">Entre :</label>
	<sj:datepicker cssClass="input-medium search-query" id="firstDate" name="firstDate" 
		displayFormat="dd/mm/yy" imageUrl="images/datepicker.gif" 
		imageTooltip="" placeholder="jj/mm/aaaa" changeYear="true"
		changeMonth="true" value="" />
	<label class="control-label" for="dateNext"> et :</label>
	<sj:datepicker cssClass="input-medium search-query" id="lastDate" name="lastDate" 
		displayFormat="dd/mm/yy" imageTooltip="" placeholder="jj/mm/aaaa" 
		changeYear="true" changeMonth="true" value="" />
	
	<input type="button" class="btn btn-primary" value="valider" id="validateSearch" />
<%-- 	<s:url id="editurl" action="messageList"/> --%>
<!-- 	<a href="%{editurl}" id="validateSearch" >valider</a> -->
<!-- 	editurl="%{editurl}" -->
</form>

<s:url id="remoteurl" action="messageList" >
<%-- 	<s:param name="loadonce" value="%{true}" /> --%>
<!-- groupField="['nomApplication']" -->
<!-- 	groupColumnShow="[false]" -->
<!-- 	groupCollapse="true" -->
<!-- 	groupText="['<b>{0}</b>']" -->
<!-- 	navigator="true" -->
<!-- 	navigatorView="true" -->
<!-- 	altRows="true" -->
<!-- 	viewrecords="true" -->
<!-- 	formIds="form1" -->
<!-- loadonce="true" -->
</s:url>

<sjg:grid

	id="gridDataTable"
	caption="Messages groupés par Application"
	href="%{remoteurl}"
	groupField="['nomApplication']"
	groupColumnShow="[false]"
	groupCollapse="true"
	dataType="json"
	gridModel="gridModel"
	rowNum="-1"
	>

	<sjg:gridColumn cssClass="cellOne" name="nomDomaine" index="nomDomaine" title="DOMAINE" sortable="true" width="300" />
	<sjg:gridColumn cssClass="typeOfMessage" name="type" index="type" title="TYPE" sortable="true" width="300" />
	<sjg:gridColumn name="message" index="message" title="MESSAGE" sortable="true" width="300" />
	<sjg:gridColumn name="nomApplication" index="nomApplication" title="APPLICATION" sortable="true" width="300" />
</sjg:grid>

<div class="modal" id="ajax-load" style="height: 50%; margin-top: 30%;visibility: hidden;">
	<table width='100%' height='100%'>
		<tr>
			<td valign="middle" align="center">
				<img src="<s:url value='/images/ajax-loader.gif'/>" />
			</td>
		</tr>
	</table>
</div>

