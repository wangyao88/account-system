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

getIncomeCategoryData();

function getIncomeCategoryData(){
	$.ajax({
		url :"incomecategory/getIncomeCategory",
		type : "post",
		data : {
			accountId : '8af507b662d8013d0162d801c5dd0000'
		},
		dataType : "html",
		success : function(result) {
			$("#tree_list").html(result);
			initIncomeCategoryList();
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
    