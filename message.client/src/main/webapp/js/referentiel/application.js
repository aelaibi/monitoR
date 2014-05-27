$(document).ready(function(){
		
		  $.subscribe('showcolumns', function(event,data) {
			  $("#idGridApplication").jqGrid('setColumns',{});
			});
	
		$.subscribe('rowselect', function(event, data) {
				var idRow = event.originalEvent.id;
				/* sent id for getting all domaines of selected application */
				if( !isNaN(idRow) )
				{
		            $("#idGridDomaines").jqGrid('setGridParam', {
		    			postData : {
		    	        'idSelectedApplication' : idRow,
		    	        }
		    		});
		            $("#idGridDomaines").trigger("reloadGrid");
				}
	    });
});