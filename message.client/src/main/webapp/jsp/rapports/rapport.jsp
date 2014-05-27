<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags"%>
<script type="text/javascript" src="<s:url value='/js/highcharts/highcharts.js'/>" ></script>
<script type="text/javascript" src="<s:url value='/js/highcharts/exporting.js'/>" ></script>
<script type="text/javascript" src="<s:url value='/js/highcharts/highstock.js'/>" ></script>

<br>

<s:form theme="simple" id="urlreporting" action="/displayRapports.action" target="resultdiv">
<div align="center" class="result ui-widget-content ui-corner-all" style="margin-bottom:2%; float:left; width: 99%; ">

<table>
     
     <tr>
<!--  Date filtre -->
 <td>
<s:label theme="simple">Date début</s:label>
 
 </td>     
<td>
    <sj:datepicker 
    	
	    cssClass="input-medium search-query" id="firstDate" name="firstDate" 
		displayFormat="dd/mm/yy" imageUrl="images/datepicker.gif" 
		imageTooltip="" placeholder="jj/mm/aaaa" changeYear="true"
		changeMonth="true" value="" />


</td>
<td>
<s:label theme="simple">Date fin</s:label>

</td>
<td>
    <sj:datepicker cssClass="input-medium search-query" id="lastDate" name="lastDate" 
		displayFormat="dd/mm/yy" imageTooltip="" placeholder="jj/mm/aaaa" 
		changeYear="true" changeMonth="true"  value="" />
    
<!--     <input type="button" class="btn btn-primary" value="valider" id="validateSearch" /> -->
 
</td>
<td>
<s:label theme="simple">Application</s:label>
    
</td>
<td >
     <!--  Type filtre -->
    <s:select   theme="simple"    list="AllApps"  id="application" name="application" listKey="code" listValue="libelle"  cssStyle="margin-top:9px; margin-left:9px; margin-right:9px; min-width:250px; "/>
    

     <!--  Type filtre -->
     
     </td>
     <td>
    <sj:submit 
	            
	            	targets="resultdiv" 
	            	value="OK" 
	            	button="true"
	            	/>   
     </td>
</tr>
</table>
</div>
</s:form>
<div id="resultdiv" class="result ui-widget-content ui-corner-all" style="margin-bottom:2%; float:left; min-width: 99%; ">


</div>



 



