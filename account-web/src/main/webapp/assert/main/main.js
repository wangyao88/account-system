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
				initDyanmicChart(tallies);
				setInterval(function() {
					initDyanmicChart(tallies);
				}, 1000)
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

var newsIndex = 0;
function initNewsTable(){
	$.ajax({
		url :"news/getRecentTopAll",
		type : "post",
		dataType : "json",
		success : function(result) {
			if(result.status){
				var newsArr = new Array();
				var data = result.data;
				newsArr.push(data.sum_hit.news);
				newsArr.push(data.domestic_hit.news);
				newsArr.push(data.international_hit.news);
				newsArr.push(data.social_hit.news);
				newsArr.push(data.sports_hit.news);
				newsArr.push(data.finance_hit.news);
				newsArr.push(data.entertainment_hit.news);
				newsArr.push(data.technology_hit.news);
				newsArr.push(data.military_hit.news);
				initTable("news_table",newsArr[newsIndex]);
				setInterval(function() {
					if(newsIndex > newsArr.length-1){
						newsIndex = 0;
					}
					initTable("news_table",newsArr[newsIndex]);
					newsIndex += 1;
				}, 10000)
			}
		}
	});
}

function initTable(id,images){
	var html = "";
	$(images).each(function(index,image){
		html += getpanelHtml(id,index,image);
    });
	id = "#"+id;
	$(id).html(html);
}

function getpanelHtml(id,index,news){
	var source = news.source;
	if(id == 'sports_hit_table' && source == ''){
		source = '新浪体育';
	}
	if(id == 'entertainment_hit_table' && source == ''){
		source = '新浪娱乐';
	}
	return '<tr>'+
			    '<td>'+(index+1)+'</td>'+
			    '<td><a href="'+news.url+'" target="_blank">'+news.title+'</a></td>'+
			    '<td>'+source+'</td>'+
			    '<td>'+news.date+'</td>'+
			'</tr>';
}

(function init(){
	getDynamicData();
	initNewsTable();
})();