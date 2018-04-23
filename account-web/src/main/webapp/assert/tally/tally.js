function initWizard(){
	/************ #rootwizard-custom-circle ***********/
	function accountAlert(id,msg){
		if(!id){
    		layer.alert(msg, {
    			skin : 'layui-layer-lan',
    			closeBtn : 1,
    			anim : 4 //动画类型
    		}) ;
    		return false;
    	}
		return true;
	}
	$('#rootwizard-custom-circle').bootstrapWizard({
	    onTabShow: function(tab, navigation, index) {
	        var $total = navigation.find('li').length;
	        var $current = index+1;
	        var $percent = ($current/$total) * 100;
	        $('#rootwizard-custom-circle').find('.bar').css({width:$percent+'%'});
	    },
	    'onNext': function(tab, navigation, index) {
	    	if(index == 1){
	    		var accountId = $("#accountId").val();
		    	var accountIdResult = accountAlert(accountId,'请选择账本。如无账本，请先创建一个');
		    	if(!accountIdResult){
		    		return false;
		    	}
	    	}
	    	if(index == 2){
	    		var categoryType = $("#categoryType").val();
		    	var accountIdResult = accountAlert(categoryType,'请选择收支类型');
		    	if(!accountIdResult){
		    		return false;
		    	}
	    	}
	    	
	    	
	    	
	        // select id of current tab content
	        var $id = tab.find("a").attr("href");
	        var $approved = 1;
	        // Check all input validation
	        $($id + " input").each(function(){
	            if (!$(this).val()) {
	                $(this).css('border-color', 'red');
	                $(this).parent().parent().find("i.alert").removeClass("alert-hide");
	                $approved = 0;
	            } else {
	                $(this).parent().parent().find("i.alert").addClass("alert-hide");
	            }
	        });
	        if ($approved !== 1) return false;
	    },
	    'onTabClick': function(tab, navigation, index) {
	        // select id of current tab content
	        var $id = tab.find("a").attr("href");
	        var $approved = 1;
	        // Check all input validation
	        $($id + " input").each(function(){
	            if (!$(this).val()) {
	                $(this).css('border-color', 'red');
	                $(this).parent().parent().find("i.alert").removeClass("alert-hide");
	                $approved = 0;
	            } else {
	                $(this).parent().parent().find("i.alert").addClass("alert-hide");
	            }
	        });
	        if ($approved !== 1) return false;
	        // Add class visited to style css
	        if (tab.attr("class")=="visited"){
	            tab.removeClass("visited");
	        } else {
	            tab.addClass("visited");
	        }
	    },
	    'tabClass': 'bwizard-steps-o','nextSelector': '.button-next', 'previousSelector': '.button-previous'
	});
}

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

function initAutocomplete(){
	var url = "incomecategory/autocompleteCategory";
    var options = {
        mustMatch : true,
        dataType : "json",
        extraParams: { 
        	accountId: function() {
        		return $('#accountId').val(); 
        	}, 
        	categoryType: function() {
        		return $('#categoryType').val();
        	}
        },
        formatResult: function(data, value) {
			return value;
		}
    };
    $('#categoryName').autocomplete(url,options);
}

function initDateTimePicker(){
	$('.datetimepicker-default').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss'
        });
}

(function init(){
	initWizard();
	initAccountBookSelect();
	initCategoryTypeSelect();
	initAutocomplete();
	initDateTimePicker();
})();

function saveTally(){
	var accountId = $('#accountId').val();
	var categoryType = $('#categoryType').val();
	var categoryName = $('#categoryName').val();
	var createDate = $('#createDate').val();
	var money = $('#money').val();
	$.ajax({
		url :"tally/save",
		type : "post",
		data : {
			money : money,
			createDate : createDate,
			categoryType : categoryType,
			categoryName : categoryName,
			accountId : accountId
		},
		dataType : "json",
		success : function(result) {
			if(result.status){
				layer.alert(result.data, {
	    			skin : 'layui-layer-lan',
	    			closeBtn : 1,
	    			anim : 4 //动画类型
	    		}) ;
				$("#previous").trigger("click");
				$('#createDate').val('');
				$('#money').val('');
				
				$("#previous").trigger("click");
				$('#categoryName').val('');
				
				$("#previous").trigger("click");
				$('#categoryType').val('');
				
				$("#previous").trigger("click");
			}
		}
	});
}


