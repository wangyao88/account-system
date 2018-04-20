//var updateOutput = function(e)
//    {
//        var list   = e.length ? e : $(e.target),
//            output = list.data('output');
//        if (window.JSON) {
//            output.val(window.JSON.stringify(list.nestable('serialize')));//, null, 2));
//        } else {
//            output.val('JSON browser support required for this demo.');
//        }
//    };
//
//    updateOutput($('#nestable').data('output', $('#nestable-output')));
//    updateOutput($('#nestable2').data('output', $('#nestable2-output')));
getAccountbookSelectData();

function getAccountbookSelectData(){
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
				$("#accountbook_select").html(html);
				var accountId = $("#accountbook_select").val();
				getIncomeCategoryData(accountId,true);
			}
		}
	});
}

function getIncomeCategoryDataWhenChange(){
	var accountId = $("#accountbook_select").val();
	getIncomeCategoryData(accountId,false);
}

function getIncomeCategoryData(accountId,nestable){
	$.ajax({
		url :"incomecategory/getIncomeCategory",
		type : "post",
		data : {
			accountId : accountId
		},
		dataType : "html",
		success : function(result) {
			$("#tree_list").html(result);
			if(nestable){
				initIncomeCategoryList();
			}
		}
	});
}

function initIncomeCategoryList(){
	$('#nestable-menu').on('click', function(e){
	    var target = $(e.target),
	        action = target.data('action');
	    if (action === 'expand-all') {
	        $('.dd').nestable('expandAll');
	    }
	    if (action === 'collapse-all') {
	        $('.dd').nestable('collapseAll');
	    }
	});
	$('#nestable3').nestable();
}

function addActiveClass(div){
	removeActiveClass();
	$(div).addClass("item-active");
	$("#select_item_id").val($(div).parent().attr("data-id"));
}

function removeActiveClass(){
	var actives = $(".item-active");
	$(actives).each(function(index,active){
		$(active).removeClass("item-active");
    });
	$("#select_item_id").val('');
}

function getParentId(){
	return $("#select_item_id").val();
}

function addRootIncomeCategory(){
	var accountId = $("#accountbook_select").val();
	layer.prompt({title: '输入名称，并确认', formType: 3}, function(name, index){
		$.ajax({
			url :"incomecategory/addRootIncomeCategory",
			type : "post",
			data : {
				name : name,
				accountId : accountId
			},
			dataType : "json",
			success : function(result) {
				layer.close(index);
				if(result.status){
					layer.msg(result.data);
					var accountId = $("#accountbook_select").val();
					getIncomeCategoryData(accountId,false);
				}
			}
		});
	});
}

function addChildIncomeCategory(){
	var parentId = getParentId();
	if(!parentId) {
		layer.alert('请选择需要添加子类别的类别', {
			skin : 'layui-layer-lan',
			closeBtn : 1,
			anim : 4 //动画类型
		}) ;
		return;
	}
	var accountId = $("#accountbook_select").val();
	layer.prompt({title: '输入名称，并确认', formType: 3}, function(name, index){
		$.ajax({
			url :"incomecategory/addChildIncomeCategory",
			type : "post",
			data : {
				name : name,
				parentId : parentId,
				accountId : accountId
			},
			dataType : "json",
			success : function(result) {
				layer.close(index);
				if(result.status){
					layer.msg(result.data);
					removeActiveClass();
					var accountId = $("#accountbook_select").val();
					getIncomeCategoryData(accountId,false);
				}
			}
		});
	});
}

function updateIncomeCategory(){
	var id = $("#select_item_id").val();
	if(!id) {
		layer.alert('请选择需要修改的类别', {
			skin : 'layui-layer-lan',
			closeBtn : 1,
			anim : 4 //动画类型
		}) ;
		return;
	}
	layer.prompt({title: '输入名称，并确认', formType: 3}, function(name, index){
		$.ajax({
			url :"incomecategory/updateIncomeCategory",
			type : "post",
			data : {
				id : id,
				name : name
			},
			dataType : "json",
			success : function(result) {
				layer.close(index);
				if(result.status){
					layer.msg(result.data);
					removeActiveClass();
					var accountId = $("#accountbook_select").val();
					getIncomeCategoryData(accountId,false);
				}
			}
		});
	});
}
    