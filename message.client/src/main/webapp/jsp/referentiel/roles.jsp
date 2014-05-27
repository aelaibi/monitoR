<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript" src="<s:url value='/js/referentiel/application.js'/>" ></script>

<form class="form-inline" style="margin-top: 40px;">

	<fieldset>
		<legend>Liste des roles</legend>
	</fieldset>
	<s:url id="remoteurl" action="roleList" />
    <s:url id="editurl" action="roleEdit"/>
    <sjg:grid
    	id="gridmultitable"
    	caption="Liste des roles"
    	dataType="json"
    	href="%{remoteurl}"
    	pager="true"
    	navigator="true"
    	navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
    	navigatorAddOptions="{height:280,reloadAfterSubmit:true}"
    	navigatorEditOptions="{height:280,reloadAfterSubmit:false}"
    	navigatorEdit="true"
    	navigatorView="true"
    	navigatorDelete="true"
    	navigatorDeleteOptions="{height:280,reloadAfterSubmit:true}"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	editurl="%{editurl}"
    	multiselect="true"
    	onSelectRowTopics="rowselect"
    	editinline="true"
		cellEdit="true"
    >
    	<sjg:gridColumn name="id" index="id" title="ID" formatter="integer" editable="false" sortable="false" search="true" searchoptions="{sopt:['eq','ne','lt','gt']}"/>
    	<sjg:gridColumn name="role" index="role" title="Nom" editable="true" edittype="text" sortable="true" search="false"/>
<%--     	<sjg:gridColumn name="lastName" index="lastName" title="Last Name" sortable="false" hidden="true"/> --%>
<%--     	<sjg:gridColumn name="firstName" index="firstName" title="First Name" sortable="false" hidden="true"/> --%>
<%--     	<sjg:gridColumn name="addressLine1" index="addressLine1" title="Adress" sortable="false" hidden="true"/> --%>
<%--     	<sjg:gridColumn name="country" index="country" title="Country" editable="true" edittype="select" editoptions="{value:'France:France;USA:USA;Australia:Australia;Norway:Norway;Poland:Poland;Germany:Germany;Spain:Spain'}" sortable="false" search="false"/> --%>
<%--     	<sjg:gridColumn name="city" index="city" title="City" editable="true" edittype="text" sortable="false" search="false"/> --%>
<%--     	<sjg:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" formatter="currency" editable="true" edittype="text" sortable="false" search="false"/> --%>
    </sjg:grid>
	<br/>
    <sj:submit id="grid_multi_getselectedbutton" value="Get Selected Rows" onClickTopics="getselectedids" button="true"/>
		
</form>


