<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-支出类别管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
    <%@ include file="../common/css.jsp"%>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/jquery-bootstrap-wizard/custom.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/jquery-steps/css/jquery.steps.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/tally/jquery.autocomplete.css">
</head>

<body class=" ">
	<div>
		<div id="error_msg" value="${error_msg}" style="display: none;">
		
		</div>
		<%@ include file="../common/header.jsp"%>
		<div id="wrapper">
			<%@ include file="menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">记账</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div class="row"><!-- 流程  start-->
                        <div class="col-lg-12">
                        	
                        	<div class="col-lg-12">
                            <div class="portlet box portlet-green">
                                <div class="portlet-header">
                                    <div class="caption">记账流程</div>
                                    <div class="tools"><i class="fa fa-chevron-up"></i><i data-toggle="modal" data-target="#modal-config" class="fa fa-cog"></i><i class="fa fa-refresh"></i><i class="fa fa-times"></i>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div id="rootwizard-custom-circle">
                                        <div class="navbar">
                                            <div class="navbar-inner">
                                                <ul>
                                                    <li><a href="#tab1-wizard-custom-circle" data-toggle="tab"><i class="glyphicon glyphicon-user"></i><p class="anchor">1. 账本</p><p class="description">选择一个账本</p></a>
                                                    </li>
                                                    <li><a href="#tab2-wizard-custom-circle" data-toggle="tab"><i class="glyphicon glyphicon-send mln"></i><p class="anchor">2. 收支类型</p><p class="description">决定是收入还是支出</p></a>
                                                    </li>
                                                    <li><a href="#tab3-wizard-custom-circle" data-toggle="tab"><i class="glyphicon glyphicon-shopping-cart"></i><p class="anchor">3. 选择类别</p><p class="description">选择类别</p></a>
                                                    </li>
                                                    <li><a href="#tab4-wizard-custom-circle" data-toggle="tab"><i class="glyphicon glyphicon-check"></i><p class="anchor">4. 金额</p><p class="description">输入金额</p></a>
                                                    </li>
                                                    <li><a href="#tab5-wizard-custom-circle" data-toggle="tab"><i class="glyphicon glyphicon-check"></i><p class="anchor">5. 提交</p><p class="description">确认无误，点击按钮，完成记账</p></a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div id="bar" class="progress active">
                                            <div class="bar progress-bar progress-bar-primary"></div>
                                        </div>
                                        <div class="tab-content">
                                            <div id="tab1-wizard-custom-circle" class="tab-pane">
                                                <div class="row">
	                                                <div class="col-lg-4">
							                            <div class="panel panel-yellow">
							                                <div class="panel-heading">选择账本</div>
							                                <div class="panel-body pan">
							                                    <form action="#" class="form-horizontal" style="margin-top:6px;">
				                                                    <div class="form-group">
				                                                        <label for="account" class="col-sm-3 control-label">账本 <span class='require'>*</span>
				                                                        </label>
				                                                        <div class="col-sm-5">
				                                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
				                                                                <select id="accountId" class="form-control"></select>
				                                                            </div>
				                                                        </div>
				                                                    </div>
				                                                </form>
							                                </div>
							                            </div>
							                         </div>
						                         </div>
                                            </div>
                                            <div id="tab2-wizard-custom-circle" class="tab-pane">
                                                <div class="row">
	                                                <div class="col-lg-4">
							                            <div class="panel panel-yellow">
							                                <div class="panel-heading">选择收支类型</div>
							                                <div class="panel-body pan">
							                                    <form action="#" class="form-horizontal" style="margin-top:6px;">
				                                                    <div class="form-group">
				                                                        <label for="categoryType" class="col-sm-3 control-label">收支类型 <span class='require'>*</span>
				                                                        </label>
				                                                        <div class="col-sm-5">
				                                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
				                                                                <select id="categoryType" class="form-control"></select>
				                                                            </div>
				                                                        </div>
				                                                    </div>
				                                                </form>
							                                </div>
							                            </div>
							                         </div>
						                         </div>
                                            </div>
                                            <div id="tab3-wizard-custom-circle" class="tab-pane fadeIn">
                                                <div class="row">
	                                                <div class="col-lg-4">
							                            <div class="panel panel-yellow">
							                                <div class="panel-heading">选择列别</div>
							                                <div class="panel-body pan">
							                                    <form action="#" class="form-horizontal" style="margin-top:6px;">
				                                                    <div class="form-group">
				                                                        <label for="categoryType" class="col-sm-3 control-label">类别 <span class='require'>*</span>
				                                                        </label>
				                                                        <div class="col-sm-5">
				                                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
				                                                                <input type="text" id="categoryId"/>
				                                                            </div>
				                                                        </div>
				                                                    </div>
				                                                </form>
							                                </div>
							                            </div>
							                         </div>
						                         </div>
                                            </div>
                                            <div id="tab4-wizard-custom-circle" class="tab-pane fadeIn">
                                                <h3 class="mbxl">Thank you!</h3>
                                                <p>Congragulation! You have completed checkout steps.</p>
                                                <p>Thank you for use our products.</p>
                                            </div>
                                            <div id="tab5-wizard-custom-circle" class="tab-pane fadeIn">
                                                <button type="button" class="btn btn-green btn-square" onclick="">狠狠地记上一笔</button>
                                            </div>
                                            <div class="action text-right">
                                                <button type="button" name="previous" value="Previous" class="btn btn-info button-previous"><i class="fa fa-arrow-circle-o-left mrx"></i>上一步</button>
                                                <button type="button" name="next" value="Next" class="btn btn-info button-next mlm">下一步<i class="fa fa-arrow-circle-o-right mlx"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        	
                        	
                        	
                        </div>
                    </div><!-- 流程  end-->
				</div>
				<!--END CONTENT-->
			</div>
			<%@ include file="../common/footer.jsp"%>
			<!--END PAGE WRAPPER-->
		</div>
	</div>
	<%@ include file="../common/js.jsp"%>
	<script type="text/javascript" src="<%=basePath%>assert/layer/layer.js"></script>
	<script src="<%=basePath%>assert/theme/vendors/jquery-validate/jquery.validate.min.js"></script>
    <script src="<%=basePath%>assert/theme/vendors/jquery-steps/js/jquery.steps.min.js"></script>
    <script src="<%=basePath%>assert/theme/vendors/jquery-bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
    <script type='text/javascript' src='<%=basePath%>assert/common/js/jquery.bgiframe.min.js'></script>
	<script type='text/javascript' src='<%=basePath%>assert/common/js/jquery.ajaxQueue.js'></script>
	<script type='text/javascript' src='<%=basePath%>assert/common/js/thickbox-compressed.js'></script>
    <script type="text/javascript" src="<%=basePath%>assert/common/js/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/tally/tally.js"></script>
</body>
</html>
