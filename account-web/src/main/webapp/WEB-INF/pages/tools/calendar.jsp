<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>爱记账-日历</title>
    
    <link href='https://fonts.googleapis.com/css?family=Architects+Daughter' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assert/common/simplecalendar/stylesheet.css" media="screen">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assert/common/simplecalendar/print.css" media="print">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assert/common/simplecalendar/simple-calendar.css">
    <style>
	  #calendar{
		width: 100%
	  }
	  .clearfix{
		margin-bottom: 50px !important;
	  }
	</style>
  </head>
  
  <body>
    <div id="content-wrapper">
		<div class="inner clearfix">
		  <div id = 'calendar'>
		
		  </div>
		</div>
	</div>
    <script type="text/javascript" src="<%=basePath%>assert/common/simplecalendar/simple-calendar.js"></script>
	<script>
	    var myCalendar = new SimpleCalendar('#calendar');
	</script>
  </body>
</html>
