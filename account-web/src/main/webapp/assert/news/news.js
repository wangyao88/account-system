(function(){
//	var interval = 1000*60*10;//10分钟
//	setInterval(getRecentTopAll,interval);
	getRecentTopAll();
})();


function getRecentTopAll(){
	$.ajax({
		url :"news/getRecentTopAll",
		type : "post",
		dataType : "json",
		success : function(result) {
			if(result.status){
				var data = result.data;
				var images = data.sum_image;
				initTable("sum_image_table",images.news);
				var videos = data.sum_video;
				initTable("sum_video_table",videos.news);
				
				var sum_hits = data.sum_hit;
				initTable("sum_hit_table",sum_hits.news);
				var sum_disss = data.sum_diss;
				initTable("sum_diss_table",sum_disss.news);
				var sum_shares = data.sum_share;
				initTable("sum_share_table",sum_shares.news);
				
				var domestic_hits = data.domestic_hit;
				initTable("domestic_hit_table",domestic_hits.news);
				var domestic_disss = data.domestic_diss;
				initTable("domestic_diss_table",domestic_disss.news);
				var domestic_shares = data.domestic_share;
				initTable("domestic_share_table",domestic_shares.news);
				
				var international_hits = data.international_hit;
				initTable("international_hit_table",international_hits.news);
				var international_disss = data.international_diss;
				initTable("international_diss_table",international_disss.news);
				var international_shares = data.international_share;
				initTable("international_share_table",international_shares.news);
				
				var social_hits = data.social_hit;
				initTable("social_hit_table",social_hits.news);
				var social_disss = data.social_diss;
				initTable("social_diss_table",social_disss.news);
				var social_shares = data.social_share;
				initTable("social_share_table",social_shares.news);
				
				var sports_hits = data.sports_hit;
				initTable("sports_hit_table",sports_hits.news);
				var sports_disss = data.sports_diss;
				initTable("sports_diss_table",sports_disss.news);
				var sports_shares = data.sports_share;
				initTable("sports_share_table",sports_shares.news);
				
				var finance_hits = data.finance_hit;
				initTable("finance_hit_table",finance_hits.news);
				var finance_disss = data.finance_diss;
				initTable("finance_diss_table",finance_disss.news);
				var finance_shares = data.finance_share;
				initTable("finance_share_table",finance_shares.news);
				
				var entertainment_hits = data.entertainment_hit;
				initTable("entertainment_hit_table",entertainment_hits.news);
				var entertainment_disss = data.entertainment_diss;
				initTable("entertainment_diss_table",entertainment_disss.news);
				var entertainment_shares = data.entertainment_share;
				initTable("entertainment_share_table",entertainment_shares.news);
				
				var technology_hits = data.technology_hit;
				initTable("technology_hit_table",technology_hits.news);
				var technology_disss = data.technology_diss;
				initTable("technology_diss_table",technology_disss.news);
				var technology_shares = data.technology_share;
				initTable("technology_share_table",technology_shares.news);
				
				var military_hits = data.military_hit;
				initTable("military_hit_table",military_hits.news);
				var military_disss = data.military_diss;
				initTable("military_diss_table",military_disss.news);
				var military_shares = data.military_share;
				initTable("military_share_table",military_shares.news);
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