<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>爱记账-登陆页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="<%=basePath%>assert/login/css/style.css" type="text/css" media="all">
	<script type="text/javascript" src="<%=basePath%>assert/common/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/login/js/login.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/layer/layer.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/common/encrypt/jsencrypt.min.js"></script>
	<script type="application/x-javascript">
		addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);
			function hideURLbar() {
				window.scrollTo(0, 1);
		}
	</script>
</head>
<body>
	<h1>爱记账</h1>
	<div class="container w3layouts agileits">
		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<form action="#" method="post">
				<input type="text" name="login_name" id="login_name" placeholder="用户名" required="" onBlur="onLoginNameBlur()" value="wangyao">
				<input type="password" name="login_password" id="login_password" placeholder="密码" required="" value="1">
			</form>
			<ul class="tick w3layouts agileits">
				<li><input type="checkbox" id="brand1" value=""> <label
					for="brand1"><span></span>记住我</label></li>
			</ul>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="button" value="登 录" onclick="login()">
				</form>
			</div>
			<a href="#">记住密码?</a>
			<div class="clear"></div>
		</div>

		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<form action="#" method="post">
				<input type="text" name="registe_name" id="registe_name" placeholder="用户名" required="" onBlur="onRegisteNameBlur()">
				<input type="password" name="registe_password" id="registe_password" placeholder="密码" required="">
				<input type="password" name="registe_repassword" id="registe_repassword" placeholder="确认密码" required="" onBlur="onRePasswordBlur()">
			</form>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="button" value="免费注册" onclick="registe()">
				</form>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="footer w3layouts agileits">
		<p>Copyright &copy; travelmonk123</p>
	</div>
</body>
</html>
