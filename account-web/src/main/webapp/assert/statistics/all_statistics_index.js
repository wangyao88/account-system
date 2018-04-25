var all_statistics_pie;
var all_statistics_line;

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
	
	var html = '<option value="year" selected="selected">年</option>'+
				'<option value="month">月</option>'+
			   '<option value="day">日</option>';
	$("#dateType").html(html);

	$('.datepicker-default').datepicker({
        format: 'yyyy-mm-dd'
    });
}

function initStatisticsChartHeight(){
	var height = $("#search_panel").height();
	$("#all_statistics_pie").height(height-60);
	$("#all_statistics_line").height(height*1.5);
}

function initStatisticsChart(){
	all_statistics_pie = echarts.init(document.getElementById('all_statistics_pie'));
	all_statistics_line = echarts.init(document.getElementById('all_statistics_line'));
}

function initAllStatisticsPieData(accountName,legend_data,series_data){
	var option = {
	    title : {
	        text: '总收入支出占比',
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
	            name:'总收入支出占比',
	            type:'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:series_data
	        }
	    ]
	};
	all_statistics_pie.setOption(option);
}

function initAllStatisticsLineData(legend_data,xAxis_data,series_data){
	var option = {
	    title : {
	    	x: 'center',
	        text: '综合统计'
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
	all_statistics_line.setOption(option);
}

function statistics(){
	var data = {
		accountId : $('#accountId').val(),
		dateType : $('#dateType').val(),
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
		url :"statistics/getInAndOutSumData",
		type : "post",
		data : data,
		dataType : "json",
		success : function(result) {
			var accountName = $("#accountId").find("option:selected").text();
			var pie_legend_data = new Array();
			var pie_series_data = new Array();
			if(result.status && result.data.length > 0){
				var tallies = result.data;
				$(tallies).each(function(index,tally){
					var categoryType = tally.categoryType;
					var money = tally.money;
					pie_legend_data.push(categoryType);
					pie_series_data.push({value:money, name:categoryType});
			    });
			}else{
				pie_legend_data.push("收入");
				pie_series_data.push({value:0, name:"收入"});
				pie_legend_data.push("支出");
				pie_series_data.push({value:0, name:"支出"});
			}
			
			initAllStatisticsPieData(accountName,pie_legend_data,pie_series_data);
		}
	});
	
	$.ajax({
		url :"statistics/getInAndOutSumLineData",
		type : "post",
		data : data,
		dataType : "json",
		success : function(result) {
			if(result.status){
				console.log(result.data);
				var legend_data = result.data.legendData;
				var xAxis_data = result.data.xAxisData;
				var series_data = result.data.seriesData;
				initAllStatisticsLineData(legend_data,xAxis_data,series_data);
			}
		}
	});
}

(function(){
	initSearchPanel();
	initStatisticsChartHeight();
	initStatisticsChart();
	statistics();
})();