<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-小工具</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
    <%@ include file="../common/css.jsp"%>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/bootstrap-datepicker/css/datepicker.css">
</head>

<body class=" ">
	<div>
		<div id="error_msg" value="${error_msg}" style="display: none;">
		</div>
		<%@ include file="../common/header.jsp"%>
		<div id="wrapper">
			<%@ include file="index_menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">综合统计</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div id="tab-general">
					    <div class="row mbl">
					    	<div id="search_panel" class="col-lg-6">
					    		<div class="panel panel-blue">
	                                <div class="panel-heading">天气预报</div>
	                                <div class="panel-body pan">
	                                	<div class="col-md-offset-1 col-md-6">
	                                		<iframe allowtransparency="true" 
	                                				frameborder="0" 
	                                				width="565" 
	                                				height="120" 
	                                				scrolling="no" 
	                                				src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=3&bd=0&k=&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=565&h=98&align=center">
	                                		</iframe>
	                                	</div>
	                                </div>
	                            </div>
					    	</div>
					    	<div id="search_panel" class="col-lg-6">
					    		<div class="panel panel-red">
	                                <div class="panel-heading">天气预报</div>
	                                <div class="panel-body pan">
	                                	<div class="col-md-offset-1 col-md-6">
	                                		<iframe allowtransparency="true" 
	                                				frameborder="0" 
	                                				width="565" 
	                                				height="120" 
	                                				scrolling="no" 
	                                				src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=3&bd=0&k=&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=565&h=98&align=center">
	                                		</iframe>
	                                	</div>
	                                </div>
	                            </div>
					    	</div>
                        </div>
                        <div class="row mbl">
					    	<div id="search_panel" class="col-lg-6">
					    		<div class="panel panel-grey">
	                                <div class="panel-heading">计算器</div>
	                                <div class="panel-body pan">
	                                	<div class="col-md-offset-1 col-md-6">
	                                		<iframe allowtransparency="true" 
	                                				frameborder="0" 
	                                				width="600" 
	                                				height="600" 
	                                				scrolling="no" 
	                                				src="tools/calculator">
	                                		</iframe>
	                                	</div>
	                                </div>
	                            </div>
					    	</div>
					    	<div id="search_panel" class="col-lg-6">
					    		<div class="panel panel-yellow">
	                                <div class="panel-heading">日历</div>
	                                <div class="panel-body pan">
	                                	<div class="col-md-offset-1 col-md-6">
	                                		<iframe allowtransparency="true" 
	                                				frameborder="0" 
	                                				width="600" 
	                                				height="600" 
	                                				scrolling="no" 
	                                				src="tools/calendar">
	                                		</iframe>
	                                	</div>
	                                </div>
	                            </div>
					    	</div>
                        </div>
					</div>
				</div>
				<!--END CONTENT-->
			</div>
			<%@ include file="../common/footer.jsp"%>
			<!--END PAGE WRAPPER-->
		</div>
	</div>
	<%@ include file="../common/js.jsp"%>
</body>
</html>
