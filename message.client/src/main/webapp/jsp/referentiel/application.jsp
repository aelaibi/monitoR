<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript" src="<s:url value='/js/referentiel/application.js'/>" ></script>
<s:form >
		<blockquote style="margin-top: 50px ">
		  <p>Liste des applications </p>
		</blockquote>
		<s:url id="remoteurlApplication" action="applicationList" />
		<s:url id="editurlApplication" action="applicationEdit" />
		<sjg:grid 
		    	id="idGridApplication"
		    	
		    	caption="Liste des applications"
		    	dataType="json"
		    	href="%{remoteurlApplication}"
		    	pager="true"
		    	navigator="true"
		    	
		    	navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		    	navigatorAddOptions="{height:150,reloadAfterSubmit:true}"
		    	navigatorEditOptions="{height:150,reloadAfterSubmit:true}"
		    	navigatorEdit="false"
		    	navigatorView="true"
		    	navigatorDelete="true"
		    	navigatorDeleteOptions="{height:150,reloadAfterSubmit:true}"
		    	
		    	gridModel="gridApplications"
		    	rowList="5,10,20"
		    	rowNum="5"
		    	editurl="%{editurlApplication}"
		    	editinline="true"
		    	viewrecords="true"
		    	width="1320"
		    	shrinkToFit="true"
		    	onSelectRowTopics="rowselect"
		    	onEditInlineSuccessTopics="editInlineSuccess">
			<sjg:gridColumn key="true" hidden="false" name="idApplication" index="idApplication" 
							title="ID" formatter="integer" 
							editable="true" sortable="false" width="300"/>
			<sjg:gridColumn name="nomApplication" frozen="true" title="application" 
							editable="true" edittype="text" width="700"/>
		</sjg:grid>
		
		
	
<!-- 	    <div id="gridinfo" class="ui-widget-content ui-corner-all"><p>Edit Mode for Row :</p></div> -->
	
		
		<blockquote style="margin-top: 50px ">
		  <p>Liste des domaines </p>
		</blockquote>
		<s:url id="remoteurlDomaines" action="domainesList" />
		<s:url id="editurlDomaines" action="domainesEdit" />
		<sjg:grid 
		    	id="idGridDomaines"
		    	caption="Liste des Domaines"
		    	dataType="json"
		    	href="%{remoteurlDomaines}"
		    	pager="true"
		    	navigator="true"
		    	navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		    	navigatorAddOptions="{height:150,reloadAfterSubmit:true}"
		    	navigatorEditOptions="{height:150,reloadAfterSubmit:true}"
		    	navigatorEdit="false"
		    	navigatorView="true"
		    	navigatorDelete="true"
		    	navigatorDeleteOptions="{height:150,reloadAfterSubmit:true}"
		    	gridModel="gridDomaines"
		    	rowList="5,10,20"
		    	rowNum="5"
		    	editurl="%{editurlDomaines}"
		    	editinline="true"
		    	viewrecords="true"
		    	width="1320"
		    	shrinkToFit="false"
		    	onEditInlineBeforeTopics="beforTopic"
		    	>
			<sjg:gridColumn key="true" hidden="false" name="idDomaine" index="idDomaine" 
							title="ID" formatter="integer" 
							editable="true" sortable="false" width="400"/>
			<sjg:gridColumn name="nomDomaine" frozen="true" title="Domaine" 
							editable="true" edittype="text" width="920"/>
		</sjg:grid>
		
		
</s:form>

