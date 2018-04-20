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
				getOutcomeCategoryData(accountId,true);
			}
		}
	});
}

function getOutcomeCategoryDataWhenChange(){
	var accountId = $("#accountbook_select").val();
	getOutcomeCategoryData(accountId,false);
}

function getOutcomeCategoryData(accountId,nestable){
	$.ajax({
		url :"outcomecategory/getOutcomeCategory",
		type : "post",
		data : {
			accountId : accountId
		},
		dataType : "html",
		success : function(result) {
			$("#tree_list").html(result);
			if(nestable){
				initOutcomeCategoryList();
			}
		}
	});
}

function initOutcomeCategoryList(){
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

function addRootOutcomeCategory(){
	var accountId = $("#accountbook_select").val();
	layer.prompt({title: '输入名称，并确认', formType: 3}, function(name, index){
		$.ajax({
			url :"outcomecategory/addRootOutcomeCategory",
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
					getOutcomeCategoryData(accountId,false);
				}
			}
		});
	});
}

function addChildOutcomeCategory(){
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
			url :"outcomecategory/addChildOutcomeCategory",
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
					getOutcomeCategoryData(accountId,false);
				}
			}
		});
	});
}

function updateOutcomeCategory(){
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
			url :"outcomecategory/updateOutcomeCategory",
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
					getOutcomeCategoryData(accountId,false);
				}
			}
		});
	});
}
    