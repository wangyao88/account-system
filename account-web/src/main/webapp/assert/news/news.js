(function(){
	$.ajax({
		url :"news/getRecentTopAll",
		type : "post",
		dataType : "json",
		success : function(result) {
			if(result.status){
				var data = result.data;
				var images = data.sum_image;
				var videos = data.sum_video;
				var hits = data.sum_hit;
				var disss = data.sum_diss;
				var shares = data.sum_share;
				console.log(hits);
				initTable("image_table",images.news);
				initTable("video_table",videos.news);
				initTable("hit_table",hits.news);
				initTable("diss_table",disss.news);
				initTable("share_table",shares.news);
			}
		}
	});
})();

function initTable(id,images){
	var html = "";
	$(images).each(function(index,image){
		html += getpanelHtml(index,image);
    });
	id = "#"+id;
	$(id).html(html);
}

function getpanelHtml(index,news){
	return '<tr>'+
			    '<td>'+(index+1)+'</td>'+
			    '<td>'+news.title+'</td>'+
			    '<td>'+news.source+'</td>'+
			    '<td>'+news.date+'</td>'+
			'</tr>';
}