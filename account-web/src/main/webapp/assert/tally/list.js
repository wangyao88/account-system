function initAccountBookSelect(){
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
}

function initCategoryTypeSelect(){
	var html ='<option value="">请选择收支类型</option>'+
			  '<option value="INCOME">收入</option>'+
			  '<option value="OUTCOME">支出</option>';
	$("#categoryType").html(html);
}

function initDateTimePicker(){
	$('.datepicker-default').datepicker({
        format: 'yyyy-mm-dd'
    });
}

function initPagination(total){
	$('.M-box').pagination({
	    pageCount: total,
	    jump : true,
	    coping : true,
	    homePage : '首页',
	    endPage : '末页',
	    prevContent : '上页',
	    nextContent : '下页',
	    callback: function (currPageNmu) {
	    	initTallyTable(currPageNmu,false);
	    }
	});
}

function initTallyTable(pageIndex, isInitPagination){
	if(pageIndex){
		pageIndex = pageIndex - 1;
	}
	var data = {
		pageIndex : pageIndex || 0,
		pageSize : 10
	};
	data.accountId = $('#accountId').val();
	var categoryType = $('#categoryType').val();
	if(categoryType){
		data.categoryType = categoryType;
	}
	var beginDate = $('#beginDate').val();
	if(beginDate){
		data.beginDate = beginDate;
	}
	var endDate = $('#endDate').val();
	if(endDate){
		data.endDate = endDate;
	}
	$.ajax({
		url :"tally/findPage",
		type : "post",
		data : data,
		dataType : "json",
		success : function(result) {
			if(result.status){
				$("#outcome_span").html("支出：0元");
				$("#income_span").html("收入：0元");
				var total = result.total;
				if(isInitPagination){
					initPagination(total);
				}
				var tallies = result.data;
				var html = "";
				$(tallies).each(function(index,tally){
					html += getTrHtml(index,tally);
			    });
				$("#tally_table").html(html);
			}
		}
	});
}

function getTrHtml(index,tally){
	if(!tally.id){
		var span_html = "";
		if(tally.categoryType == 'OUTCOME'){
			span_html = "支出："+tally.money+"元";
			$("#outcome_span").html(span_html);
		}
		if(tally.categoryType == 'INCOME'){
			span_html = "收入："+tally.money+"元";
			$("#income_span").html(span_html);
		}
		return "";
	}
	var categoryType = "";
	if(tally.categoryType == 'OUTCOME'){
		categoryType = "支出";
	}
	if(tally.categoryType == 'INCOME'){
		categoryType = "收入";
	}
	var html = '<tr">'+
				    '<td>'+(index+1)+'</td>'+
				    '<td>'+tally.categoryName+'</td>'+
				    '<td>'+categoryType+'</td>'+
				    '<td>'+tally.createDate+'</td>'+
				    '<td>'+tally.money+'</td>'+
			    '</tr>';
	return html;
}

(function init(){
	initAccountBookSelect();
	initCategoryTypeSelect();
	initDateTimePicker();
})();


