$(document).ready(function(){
	
});

//var error_msg = $("#error_msg").val();
//layer.msg(error_msg);
//if(error_msg != ""){
//	layer.msg(error_msg);
//}
initAccountBookTable();

function initAccountBookTable(){
	$.ajax({
		url :"accountbook/getAccountBooks",
		type : "post",
		dataType : "json",
		success : function(result) {
			if(result.status){
				var accountbooks = result.data;
				var html = "";
				var length = accountbooks.length;
				$(accountbooks).each(function(index,accountbook){
					html += getpanelHtml(index,accountbook);
			    });
				$("#account_book_table").html(html);
			}
		}
	});
}

function getpanelHtml(index,accountbook){
	var html = '<tr onclick="selectAccountbook(this)">'+
	                '<td style="display:none;">'+accountbook.id+'</td>'+
				    '<td>'+(index+1)+'</td>'+
				    '<td>'+accountbook.name+'</td>'+
				    '<td>'+accountbook.createDate+'</td>'+
				    '<td>'+accountbook.income+'</td>'+
				    '<td>'+accountbook.outcome+'</td>';
	
	if(accountbook.income > accountbook.outcome){
		html += '<td><span class="label label-sm label-success">'+(accountbook.income-accountbook.outcome)+'</span></td>';
	}else{
		html += '<td><span class="label label-sm label-danger">'+(accountbook.income-accountbook.outcome)+'</span></td>';
	}
	html += '<td>'+accountbook.describe+'</td>'+
			'</tr>';
	return html;
}

function selectAccountbook(tr){
	var id = $(tr).children('td').first().html();
	var name = $(tr).children('td').eq(2).html();
	var describe = $(tr).children('td').eq(7).html();
	$("#update_account_id").val(id);
	$("#update_account_name").val(name);
	$("#update_account_describe").val(describe);
}