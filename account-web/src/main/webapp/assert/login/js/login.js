function onRegisteNameBlur(){
	var registe_name = $("#registe_name").val();
	if(registe_name == ""){
		layer.msg('请输入用户名');
		return;
	}
	$.ajax({
		url :"checkName",
		type : "post",
		data : {
			name : registe_name
		},
		dataType : "json",
		success : function(result) {
			if(!result.status){
				layer.msg('用户名【'+registe_name+'】已存在');
				return;
			}
			layer.msg('用户名【'+registe_name+'】可以使用');
		},
		error : function(){
		}
	});
}

function onRePasswordBlur(){
	var registe_password = $("#registe_password").val();
	var registe_repassword = $("#registe_repassword").val();
	if(registe_password != registe_repassword){
		layer.msg('两次输入密码不一致');
	}
}

function registe(){
	var password = $("#registe_password").val();
	$.ajax({
		url :"getPublicKey",
		type : "post",
		success : function(publicKey) {
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publicKey);
			var data = encrypt.encrypt(password);
			doRegiste(data);
		},
		error : function(){
		}
	});
}

function doRegiste(password){
	var name = $("#registe_name").val();
	$.ajax({
		url :"registe",
		type : "post",
		data : {
			name : name,
			password : password
		},
		dataType : "json",
		success : function(result) {
			if(!result.status){
				layer.msg('用户名【'+name+'】注册失败，请稍后重试');
				return;
			}
			layer.msg('用户名【'+name+'】注册成功');
		},
		error : function(){
			layer.msg('注册失败，晴稍候重试！');
		}
	});
}

function onLoginNameBlur(){
	var login_name = $("#login_name").val();
	if(login_name == ""){
		layer.msg('请输入用户名');
		return;
	}
	$.ajax({
		url :"checkName",
		type : "post",
		data : {
			name : login_name
		},
		dataType : "json",
		success : function(result) {
			if(result.status){
				layer.msg('用户名【'+login_name+'】不存在');
			}
		},
		error : function(){
		}
	});
}

function login(){
	var password = $("#login_password").val();
	$.ajax({
		url :"getPublicKey",
		type : "post",
		success : function(publicKey) {
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(publicKey);
			var data = encrypt.encrypt(password);
			doLogin(data);
		},
		error : function(){
		}
	});
}

function doLogin(password){
	var name = $("#login_name").val();
	$.ajax({
		url :"login",
		type : "post",
		data : {
			name : name,
			password : password
		},
		dataType : "json",
		success : function(result) {
			if(!result.status){
				layer.msg(result.data);
				return;
			}
			window.location.href = "main";
		},
		error : function(){
			layer.msg('登陆失败，晴稍候重试！');
		}
	});
}