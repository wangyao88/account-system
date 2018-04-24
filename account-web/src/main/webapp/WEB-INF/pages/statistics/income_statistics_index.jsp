<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-收入统计</title>
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
			<%@ include file="income_statistics_menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">收入统计</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div id="tab-general">
					    <div class="row mbl">
					    	<div id="search_panel" class="col-lg-6">
					    		<div class="panel panel-yellow">
	                                <div class="panel-heading">Login Form</div>
	                                <div class="panel-body pan">
	                                    <form action="#" class="form-horizontal">
	                                        <div class="form-body pal">
	                                            <div class="form-group">
			                                        <label for="account" class="col-sm-3 control-label">账本</label>
			                                        <div class="col-sm-5">
			                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-stack-exchange"></i></span>
			                                                <select id="accountId" class="form-control"></select>
			                                            </div>
			                                        </div>
			                                    </div>
	                                            <div class="form-group">
			                                        <label for="account" class="col-sm-3 control-label">开始时间</label>
			                                        <div class="col-sm-5">
			                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-fighter-jet"></i></span>
			                                                <input id="beginDate" type="text" class="datepicker-default form-control" />
			                                            </div>
			                                        </div>
			                                    </div>
	                                            <div class="form-group">
	                                                <label for="account" class="col-sm-3 control-label">结束时间</label>
			                                        <div class="col-sm-5">
			                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-key"></i></span>
			                                                <input id="endDate" type="text" class="datepicker-default form-control" />
			                                            </div>
			                                        </div>
	                                            </div>
	                                        </div>
	                                        <div class="form-actions pal">
	                                            <div class="form-group mbn">
	                                                <div class="col-md-offset-5 col-md-6">
	                                                    <button type="button" class="btn btn-orange btn-square" onclick="statistics()">统计</button>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </form>
	                                </div>
	                            </div>
					    	</div>
					    	<div class="col-lg-6">
					    		<div id="income_statistics_bar"></div>
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
	<script type="text/javascript" src="<%=basePath%>assert/layer/layer.js"></script>
	<script src="<%=basePath%>assert/theme/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>assert/common/echarts/echarts-3.8.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/statistics/income_statistics_index.js"></script>
</body>
</html>
