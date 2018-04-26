<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-计算器</title>
	<script src="<%=basePath%>assert/common/js/jquery.min.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=basePath%>assert/tools/calculator.css">
	</head>
	<body>
		<div class="fuselage">
		    <input type="text" name="cc" id="cc" value="0" disabled="true">
		    <div class="key">
		        <ul>
		            <li onclick="run(7)">7</li>
		            <li onclick="run(8)">8</li>
		            <li onclick="run(9)">9</li>
		            <li onclick="del()">←</li>
		            <li onclick="clearscreen()">C</li>
		            <li onclick="run(4)">4</li>
		            <li onclick="run(5)">5</li>
		            <li onclick="run(6)">6</li>
		            <li onclick="times()">×</li>
		            <li onclick="divide()">÷</li>
		            <li onclick="run(1)">1</li>
		            <li onclick="run(2)">2</li>
		            <li onclick="run(3)">3</li>
		            <li onclick="plus()">+</li>
		            <li onclick="minus()">-</li>
		            <li onclick="run(0)">0</li>
		            <li onclick="dzero()">00</li>
		            <li onclick="dot()">.</li>
		            <li onclick="persent()">%</li>
		            <li onclick="equal()">=</li>
		        </ul>
		    </div>
		</div>
	    <script type="text/javascript" src="<%=basePath%>assert/tools/calculator.js"></script>
	</body>
</html>
