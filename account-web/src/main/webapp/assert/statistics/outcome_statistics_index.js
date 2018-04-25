var outcome_statistics_pie;
var outcome_statistics_bar;
var outcome_statistics_line;

function initSearchPanel(){
	$.ajax({
		url :"accountbook/getAccountBooks",
		type : "post",
		dataType : "json",
		success : function(result) {
			if(result.status){
				var accountbooks = result.data;
				var html = "";
				$(accountbooks).each(function(index,accountbook){
					if(index == 0){
						html +='<option selected="selected" value="'+accountbook.id+'">'+accountbook.name+'</option>';
						return;
					}
					html +='<option value="'+accountbook.id+'">'+accountbook.name+'</option>';
			    });
				$("#accountId").html(html);
			}
		}
	});

	$('.datepicker-default').datepicker({
        format: 'yyyy-mm-dd'
    });
}

function initStatisticsChartHeight(){
	var height = $("#search_panel").height();
	$("#outcome_statistics_pie").height(height-60);
	$("#outcome_statistics_bar").height(height*1.5);
	$("#outcome_statistics_line").height(height*1.5);
}

function initStatisticsChart(){
	outcome_statistics_pie = echarts.init(document.getElementById('outcome_statistics_pie'));
	outcome_statistics_bar = echarts.init(document.getElementById('outcome_statistics_bar'));
	outcome_statistics_line = echarts.init(document.getElementById('outcome_statistics_line'));
}

function initOutcomeStatisticsChart(){
	var data = {
		accountId : $('#accountId').val(),
		categoryType : 'OUTCOME'
	};
	var beginDate = $('#beginDate').val();
	if(beginDate){
		data.beginDate = beginDate;
	}
	var endDate = $('#endDate').val();
	if(endDate){
		data.endDate = endDate;
	}
	$.ajax({
		url :"statistics/getOutcomeCategoryData",
		type : "post",
		data : data,
		dataType : "json",
		success : function(result) {
			if(result.status){
				var accountName = $("#accountId").find("option:selected").text();
				var tallies = result.data;
				var pie_series_data = new Array();
				var pie_legend_data = new Array();
				var bar_series_data = new Array();
				$(tallies).each(function(index,tally){
					var categoryName = tally.categoryName;
					var money = tally.money;
					pie_legend_data.push(categoryName);
					pie_series_data.push({value:money, name:categoryName});
					bar_series_data.push(money);
			    });
				var bar_xAxis_data = pie_legend_data;
				initOutcomeStatisticsBarData(accountName,bar_xAxis_data,bar_series_data);
				initOutcomeStatisticsPieData(accountName,pie_legend_data,pie_series_data);
			}
		}
	});
	$.ajax({
		url :"statistics/getOutcomeCategoryLineData",
		type : "post",
		data : data,
		dataType : "json",
		success : function(result) {
			if(result.status){
				var accountName = $("#accountId").find("option:selected").text();
				var legend_data = result.data.legendData;
				var xAxis_data = result.data.xAxisData;
				var series_data = result.data.seriesData;
				initOutcomeStatisticsLineData(accountName,legend_data,xAxis_data,series_data);
			}
		}
	});
}

function initOutcomeStatisticsPieData(accountName,legend_data,series_data){
	var option = {
	    title : {
	        text: '各支出来源占比',
	        subtext: '账本：'+accountName,
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient : 'vertical',
	        x : 'left',
	        data:legend_data
	    },
	    calculable : true,
	    series : [
	        {
	            name:'支出来源占比',
	            type:'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:series_data
	        }
	    ]
	};
	outcome_statistics_pie.setOption(option);
}

function initOutcomeStatisticsBarData(accountName,xAxis_data,series_data){
	var option = {
		title: {
	        x: 'center',
	        text: '支出统计',
	        subtext: '账本：'+accountName
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	    	orient : 'vertical',
	        x : 'left',
	        data:xAxis_data
	    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            data : xAxis_data
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'支出统计',
	            type:'bar',
	            itemStyle: {
	                normal: {
	                    color: function(params) {
	                        // build a color map as your need.
	                        var colorList = [
	                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
	                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
	                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
	                        ];
	                        return colorList[params.dataIndex]
	                    },
	                    label: {
	                        show: true,
	                        position: 'top',
	                        formatter: '{b}\n{c}'
	                    }
	                }
	            },
	            data:series_data
	        }
	    ]
	};
	outcome_statistics_bar.setOption(option);
}

function initOutcomeStatisticsLineData(accountName,legend_data,xAxis_data,series_data){
	console.log(accountName);
	console.log(legend_data);
	console.log(xAxis_data);
	console.log(series_data);
	var option = {
	    title : {
	    	x: 'center',
	        text: '支出统计',
	        subtext: '账本：'+accountName
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	    	orient : 'vertical',
	        x : 'left',
	        data:legend_data
	    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data : xAxis_data
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            axisLabel : {
	                formatter: '{value} 元'
	            }
	        }
	    ],
	    series : series_data
	};
	setTimeout(outcome_statistics_line.setOption(option), 500);  
}

function statistics(){
	initOutcomeStatisticsChart();
}

(function(){
	initSearchPanel();
	initStatisticsChartHeight();
	initStatisticsChart();
})();



