var linechart;
var page = 0;

function getDynamicData(){
	$.ajax({
		url :"tally/getDynamicData",
		type : "post",
		dataType : "json",
		success : function(result) {
			if(result.status && result.data.length > 0){
				var tallies = result.data;
				linechart = echarts.init(document.getElementById('linechart'));
				setInterval(function() {
					initDyanmicChart(tallies);
				}, 3000)
			}
		}
	});
}

function initDyanmicChart(tallies){
	var xAxis_data = new Array();
	var series_data = new Array();
	var flag = true;
	for(var i = page; i < page+10; i+=1){
		if(i < tallies.length){
			xAxis_data.push(tallies[i].createDate);
			series_data.push(tallies[i].money);
		}else{
			page = 0;
			flag = false;
		}
	}
	if(flag){
		page += 1;
	}
	var option = {
		    title : {
		    	x: 'center',
		        text: '支出详情'
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
		    series : [{
		    	name : "支出",
		    	type : "line",
		    	data : series_data
		    }]
		};
	linechart.setOption(option);
}

(function init(){
	getDynamicData();
})();