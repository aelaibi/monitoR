<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags"%>

<script type="text/javascript" src="<s:url value='/js/highcharts/highcharts.js'/>" ></script>
<script type="text/javascript" src="<s:url value='/js/highcharts/exporting.js'/>" ></script>

<script type="text/javascript" src="<s:url value='/js/message/message.js'/>" ></script>

 <style type="text/css">
  rect {
fill-opacity: .6;
fill: rgb(252, 252, 252);
}
  </style>



<br>


       <div >
         <s:url id="echo" value="/message2.action"/>
        
        <div align="center"  class="result ui-widget-content ui-corner-all" style="  margin-bottom:2%; float:left; width: 99%; ">
     
    
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
		changeMonth="true" value="today" onblur="searchPasAuto();"/>


</td>
<td>
<s:label theme="simple">Date fin</s:label>

</td>
<td>
    <sj:datepicker cssClass="input-medium search-query" id="lastDate" name="lastDate" 
		displayFormat="dd/mm/yy" imageTooltip="" placeholder="jj/mm/aaaa" 
		changeYear="true" changeMonth="true" value="today" onblur="searchPasAuto();"/>
    
<!--     <input type="button" class="btn btn-primary" value="valider" id="validateSearch" /> -->
 
</td>
<!--  Date filtre -->

<td>
<s:label theme="simple">Type des messages</s:label>
    
</td>
<td >
     <!--  Type filtre -->
    <s:select  onchange="searchPasAuto();" theme="simple" label="providers"   list="AllTypes"  id="types" name="types" listKey="code" listValue="libelle"  cssStyle="margin-top:9px; margin-left:9px; margin-right:9px; min-width:250px; "/>
    

     <!--  Type filtre -->
     
     </td>
     <td>
     
   
	    
        
     </td>
     <td>
    
   
     </td>
     
     </tr>
     
     
     
     
     
     </table>
    
       
          </div>
     <div id="container" class="result ui-widget-content ui-corner-all" style="margin-bottom:2%; float:left; min-width: 99%; height:150px;"></div>      
       
       <div 	Style="float:left; width: 25%; height: auto;" 
        		Class="ui-widget-content ui-corner-all"
            >
     
   
        <sjt:tree 
        		
        		
                id="tree"
              	dataType="TreeNode"
                jstreetheme="apple"
                rootNode="nodes"
                childCollectionProperty="children"
                nodeTitleProperty="title"
                nodeIdProperty="id"
                nodeTypeProperty="type" 
                openAllOnLoad="true"
                checkbox="true"
 				onClickTopics="tree"
 			    checkboxCheckAllTopics="checkAllNodesTopic"
 			 
          />
    </div>
	  
        </div>
      
        
        
        <div id="result3"  style="float:left; max-width: 72%; margin-left:2%;">    
        
        

 <s:url id="remoteurl" action="messageList2" >

</s:url>




<sjg:grid

    
 		id="gridDataTable" 
        
        width="955"
 	    id="gridDataTable"
    	caption="Liste des messages" 
     	dataType="json"
    	href="%{remoteurl}" 
     	gridModel="gridModel"
    	sortorder="dateEnvoi"
		pager="true"
		rowList="5,10,20"
		rowNum="5">
	<sjg:gridColumn name="dateEnvoi" index="dateEnvoi" title="dateEnvoi" sortable="true"  />
	<sjg:gridColumn  name="nomApplication"  title="nomApplication" sortable="true" />
	<sjg:gridColumn  name="nomDomaine" index="nomDomaine" title="nomDomaine" sortable="true" />
	<sjg:gridColumn name="type" index="type" title="type" sortable="true"  />
	<sjg:gridColumn name="message" index="message" title="message" sortable="true"  />
    

</sjg:grid>
 
        
        
        
        </div>
       
        
        
        
        
        
        
        
 