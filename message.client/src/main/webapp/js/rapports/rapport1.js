//$.getJSON('loadAttributs.do', {
//                       'sousDomaine.id' : sousDomaineId,
//                       'formId' : currentForm.attr('id')
//               }, function(data) {
//                       // TODO : Enlever le critere existant
//                       rechargerAttributs(data);
//               });


$(function () {
        $('#container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '% des messages 2013'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
            	percentageDecimals: 1
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        formatter: function() {
                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                        }
                    }
                }
            },
            series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                    ['Application 1',   45.0],
                    ['Application 2',       26.8],
                    {
                        name: 'Application 5',
                        y: 12.8,
                        sliced: true,
                        selected: true
                    },
                    ['Application 3',    8.5],
                    ['Application 4',     6.2],
                    ['Others',   0.7]
                ]
            }]
        });
    });
   ///////////////////////////////////////////////////////////////////////////////

$.getJSON('getRapport1.action',
		 {

'application'  : $("#application").val(),
'firstDate'    : $("#firstDate").val(),
'lastDate'     : $("#lastDate").val(),
	}, function(json) {

		
		chart1([{
		    name: 'Erreur',
		    data: [10,20,13,null,63,2,5,5,5,99,99,99]
		}, {
		    name: 'INFO',
		    data: [1,85,6,94,7,99,99,99,99,99,99,99]
		}],json.timesChart1);
	
	});
  















function chart1(info,temps)
{
$(function () {
    $('#container2').highcharts({
        chart: {
            type: 'line',
            marginRight: 130,
            marginBottom: 50
        },
        title: {
            text: 'Statistics des messages par application',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: temps
        },
        yAxis: {
            title: {
                text: 'nombre (K)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -10,
            y: 100,
            borderWidth: 0
        },
        series: info
    });
});
}

//////////////////////////////////////////////////////////////::::


$(function () {
  $('#container1').highcharts({
      chart: {
          type: 'column'
      },
      title: {
          text: ''
      },
      subtitle: {
          text: ''
      },
      xAxis: {
          categories: [
              'Info',
              'Error',
              'Worning'
  
          ]
      },
      yAxis: {
          min: 0,
          title: {
              text: ''
          }
      },
      tooltip: {
          headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
          pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
              '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
      },
      plotOptions: {
          column: {
              pointPadding: 0.2,
              borderWidth: 0
          }
      },
      series: [{
          name: 'Dom1 App1',
          data: [49.9, 71.5, 106.4]

      }, {
          name: 'Dom2 App1',
          data: [83.6, 78.8, 98.5]

      }, {
          name: 'Dom3 App1',
          data: [48.9, 38.8, 39.3]

      }, {
          name: 'Dom4 App1',
          data: [42.4, 33.2, 34.5]

      }]
  });
});
////////////////////////////////////////////////////////////////////////////////////////
