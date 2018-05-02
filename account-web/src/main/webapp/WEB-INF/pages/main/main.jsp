<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>爱记账-首页</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
<%@ include file="../common/css.jsp"%>
</head>

<body class=" ">
	<div>
		<%@ include file="../common/header.jsp"%>
		<div id="wrapper">
			<%@ include file="menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">首页</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-violet">
                                <div class="panel-heading">账单</div>
                                <div class="panel-body pan">
                                    <div id="linechart" style="height:400px"></div>
                                </div>
                            </div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-green">
                                <div class="panel-heading">新闻</div>
                                <div class="panel-body">
	                                 <table class="table table-hover table-bordered">
	                                      <thead>
	                                          <tr>
	                                              <th>序号</th>
	                                              <th>标题</th>
	                                              <th>媒体</th>
	                                              <th>时间</th>
	                                          </tr>
	                                      </thead>
	                                      <tbody id="news_table">
	                                      </tbody>
	                                  </table>
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
	<script src="<%=basePath%>assert/common/echarts/echarts-3.8.4.js"></script>
	<script src="<%=basePath%>assert/main/main.js"></script>
</body>
</html>
