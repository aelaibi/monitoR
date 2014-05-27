charts();
$(document).ready(function(){
	$("#tree").click(function(){
		charts();
		search();
	});
	
});

function searchPasAuto()
{
	charts();
	search();
}

function search()
{
	var firstDate = $("#firstDate").val();
	var lastDate  = $("#lastDate").val();
	
//	if(firstDate>lastDate)
//		{
//		if(firstDate!=""&&lastDate!="")
//		{alert();}
//		
//		}
//	
	var types  = $("#types").val();
	var someObj={};
	someObj.idsGranted=[];
	someObj.idsDenied=[];

	$("input:checkbox").each(function(){
	    var $this = $(this);

	    if($this.is(":checked")){
	        someObj.idsGranted.push($this.attr("value"));
	    }else{
	        someObj.idsDenied.push($this.attr("id"));
	    }
	});
	
	var id  = someObj.idsGranted;
	if(id=="")
		{id=null;}
	console.log(firstDate);
	console.log(lastDate);
	
	$("#gridDataTable").jqGrid('setGridParam', {
		postData : {
					        
		'firstDatev' : firstDate,
        'lastDatev'  : lastDate,
        'types'  : types,
        'ids'  : id,
        
        
		}
	});
	$("#gridDataTable").trigger("reloadGrid");
	

}



	
setInterval(function(){
	search();
},3000);



//chart
function charts()
{
$(function () {
    $(document).ready(function() {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });
    
        var chart;
        $('#container').highcharts({
            chart: {
                type: 'spline',
                marginRight: 10,
                events: {
                    load: function() {
    
                        // set up the updating of the chart each second
                        var series = this.series[0];
                        
                        
                        
                        setInterval(function() {
                        	
                        	var firstDate = $("#firstDate").val();
                        	var lastDate  = $("#lastDate").val();
                        	
//                        	if(firstDate>lastDate)
//                        		{
//                        		if(firstDate!=""&&lastDate!="")
//                        		{alert();}
//                        		
//                        		}
                        //	
                        	var types  = $("#types").val();
                        	var someObj={};
                        	someObj.idsGranted=[];
                        	someObj.idsDenied=[];

                        	$("input:checkbox").each(function(){
                        	    var $this = $(this);

                        	    if($this.is(":checked")){
                        	        someObj.idsGranted.push($this.attr("value"));
                        	    }else{
                        	        someObj.idsDenied.push($this.attr("id"));
                        	    }
                        	});
                        	
                        	var id  = someObj.idsGranted;
                        	if(id=="")
                        		{id=null;}
                        	
                        	
                        	$.getJSON('nombreMessages.action',
                        			 {
                        		'firstDate' : firstDate,
                                'lastDate'  : lastDate,
                                'types'  : types,
                                'ids'  : id,
                        		}
                        			
                        			
                        			, function(json) {
                                
                               
                            var x = (new Date()).getTime(), // current time
                                y = json.nbrMessages;
                            
                            series.addPoint([x, y], true, true);
                        	 });
                        	}, 10000);
                    }
                }
            },
            title: {
                text: 'Live Monitor'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Nombre'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function() {
                        return '<b>'+ this.series.name +'</b><br/>'+
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'Nombre messages',
                data: (function() {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;
    
                    for (i = -19; i <= 0; i++) {
                        data.push({
                            x: time + i * 1000,
                            
                            y: null
                        });
                    }
                    return data;
                })()
            }]
        });
    });
    
});

//chart
}