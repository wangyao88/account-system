var income_statistics_bar;

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
				initTallyTable(0,true);
			}
		}
	});

	$('.datepicker-default').datepicker({
        format: 'yyyy-mm-dd'
    });
}

function initStatisticsChartHeight(){
	var height = $("#search_panel").height();
	$("#income_statistics_bar").height(height);
}

function initStatisticsChart(){
	income_statistics_bar = echarts.init(document.getElementById('income_statistics_bar'));
}

function initIncomeStatisticsBarChart(){
	var data = {
		accountId : $('#accountId').val(),
		categoryType : 'INCOME'
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
		url :"statistics/getIncomeCategoryData",
		type : "post",
		data : data,
		dataType : "json",
		success : function(result) {
			if(result.status){
				var accountName = $("#accountId").find("option:selected").text();
				var tallies = result.data;
				var xAxis_data = new Array();
				var series_data = new Array();
				$(tallies).each(function(index,tally){
					xAxis_data.push(tally.categoryName);
					series_data.push(tally.money);
			    });
				initIncomeStatisticsBarData(accountName,xAxis_data,series_data);
			}
		}
	});
}

function initIncomeStatisticsBarData(accountName,xAxis_data,series_data){
	var option = {
	    title: {
	        x: 'center',
	        text: '收入统计',
	        subtext: '账本：'+accountName
	    },
	    tooltip: {
	        trigger: 'item'
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            dataView: {show: true, readOnly: false},
	            restore: {show: true},
	            saveAsImage: {show: true}
	        }
	    },
	    calculable: true,
	    grid: {
	        borderWidth: 0,
	        y: 80,
	        y2: 60
	    },
	    xAxis: [
	        {
	            type: 'category',
	            show: false,
	            data: xAxis_data
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            show: false
	        }
	    ],
	    series: [
	        {
	            name: 'ECharts例子个数统计',
	            type: 'bar',
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
	            data: series_data,
	            markPoint: {
	                tooltip: {
	                    trigger: 'item',
	                    backgroundColor: 'rgba(0,0,0,0)',
	                    formatter: function(params){
	                        return '<img src="' 
	                                + params.data.symbol.replace('image://', '')
	                                + '"/>';
	                    }
	                },
	                data: [
	                    {xAxis:0, y: 350, name:'Line', symbolSize:20, symbol: 'image://ico/折线图.png'},
	                    {xAxis:1, y: 350, name:'Bar', symbolSize:20, symbol: 'image://../asset/ico/柱状图.png'},
	                    {xAxis:2, y: 350, name:'Scatter', symbolSize:20, symbol: 'image://../asset/ico/散点图.png'},
	                    {xAxis:3, y: 350, name:'K', symbolSize:20, symbol: 'image://../asset/ico/K线图.png'},
	                    {xAxis:4, y: 350, name:'Pie', symbolSize:20, symbol: 'image://../asset/ico/饼状图.png'},
	                    {xAxis:5, y: 350, name:'Radar', symbolSize:20, symbol: 'image://../asset/ico/雷达图.png'},
	                    {xAxis:6, y: 350, name:'Chord', symbolSize:20, symbol: 'image://../asset/ico/和弦图.png'},
	                    {xAxis:7, y: 350, name:'Force', symbolSize:20, symbol: 'image://../asset/ico/力导向图.png'},
	                    {xAxis:8, y: 350, name:'Map', symbolSize:20, symbol: 'image://../asset/ico/地图.png'},
	                    {xAxis:9, y: 350, name:'Gauge', symbolSize:20, symbol: 'image://../asset/ico/仪表盘.png'},
	                    {xAxis:10, y: 350, name:'Funnel', symbolSize:20, symbol: 'image://../asset/ico/漏斗图.png'},
	                ]
	            }
	        }
	    ]
	};
	income_statistics_bar.setOption(option);
}

function statistics(){
	initIncomeStatisticsBarChart();
}

(function(){
	initSearchPanel();
	initStatisticsChartHeight();
	initStatisticsChart();
})();



