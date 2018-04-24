<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-查账</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
    <%@ include file="../common/css.jsp"%>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/jquery-bootstrap-wizard/custom.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/jquery-steps/css/jquery.steps.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/tally/jquery.autocomplete.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/bootstrap-datepicker/css/datepicker.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/common/pagination/css/pagination.css">
</head>

<body class=" ">
	<div>
		<div id="error_msg" value="${error_msg}" style="display: none;">
		
		</div>
		<%@ include file="../common/header.jsp"%>
		<div id="wrapper">
			<%@ include file="list_menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">查账</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div class="row" id="search_row">
						<div class="col-lg-12">
						    <div class="portlet box portlet-violet">
                                <div class="portlet-header">
                                    <div class="caption">查询条件</div>
                                    <div class="tools">
                                    	<button type="button" class="btn btn-orange btn-square" onclick="initTallyTable(0,true)">搜索</button>
                                    </div>
                                </div>
                                <div class="portlet-body pan">
                                	<form action="#" class="form-horizontal" style="margin-top:6px;">
	                                	<div class="col-lg-3">
	                                		<div class="form-group">
		                                        <label for="account" class="col-sm-3 control-label">账本 <span class='require'>*</span>
		                                        </label>
		                                        <div class="col-sm-5">
		                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
		                                                <select id="accountId" class="form-control"></select>
		                                            </div>
		                                        </div>
		                                    </div>
	                                	</div>
	                                	<div class="col-lg-3">
	                                		<div class="form-group">
		                                        <label for="account" class="col-sm-3 control-label">收支类型 <span class='require'>*</span>
		                                        </label>
		                                        <div class="col-sm-5">
		                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
		                                                <select id="categoryType" class="form-control"></select>
		                                            </div>
		                                        </div>
		                                    </div>
	                                	</div>
	                                	<div class="col-lg-3">
	                                		<div class="form-group">
		                                        <label for="account" class="col-sm-3 control-label">开始时间<span class='require'>*</span>
		                                        </label>
		                                        <div class="col-sm-5">
		                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
		                                                <input id="beginDate" type="text" class="datepicker-default form-control" />
		                                            </div>
		                                        </div>
		                                    </div>
	                                	</div>
	                                	<div class="col-lg-3">
	                                		<div class="form-group">
		                                        <label for="account" class="col-sm-3 control-label">结束时间<span class='require'>*</span>
		                                        </label>
		                                        <div class="col-sm-5">
		                                            <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
		                                                <input id="endDate" type="text" class="datepicker-default form-control" />
		                                            </div>
		                                        </div>
		                                    </div>
	                                	</div>
	                                </form>
                                </div>
                             </div>
						</div>
					</div>
					
					<div class="row" id="sum_money_row">
						<div class="col-sm-6 col-md-3">
                             <div class="panel profit db mbm">
                                 <div class="panel-body">
                                     <h4 class="value">
                                     	<span id="income_span" data-counter="" data-start="10" data-end="50" data-step="1" data-duration="0">收入：0元</span>
                                     </h4>
                                     <div class="progress progress-sm mbn">
                                         <div role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;" class="progress-bar progress-bar-success"><span class="sr-only">50% Complete (success)</span>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="col-sm-6 col-md-3">
                             <div class="panel profit db mbm">
                                 <div class="panel-body">
                                     <h4 class="value">
                                     	<span id="outcome_span" data-counter="" data-start="10" data-end="50" data-step="1" data-duration="0">支出：0元</span>
                                     </h4>
                                     <div class="progress progress-sm mbn">
                                         <div role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;" class="progress-bar progress-bar-danger"><span class="sr-only">80% Complete (success)</span>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>
					</div>
					
					<div class="row" id="list_row">
						<div class="col-lg-12">
                            <div class="portlet box">
                                <div class="portlet-body">
                                    <div class="row mbm">
                                        <div class="col-lg-12">
											<div class="panel panel-green">
				                                <div class="panel-heading">账本条目列表</div>
				                                <div class="panel-body">
				                                    <table class="table table-hover table-bordered">
				                                        <thead>
				                                            <tr>
				                                                <th>序号</th>
				                                                <th>类别名称</th>
				                                                <th>收支类型</th>
				                                                <th>记账时间</th>
				                                                <th>金额</th>
				                                            </tr>
				                                        </thead>
				                                        <tbody id="tally_table">
				                                        
				                                        </tbody>
				                                    </table>
				                                </div>
				                            </div>
                                        </div>
                                    </div>
                                    <div class="nav-box">
										<div class="M-box" style="margin-left:20px;"></div>
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
	<script type="text/javascript" src="<%=basePath%>assert/layer/layer.js"></script>
	<script src="<%=basePath%>assert/theme/vendors/jquery-validate/jquery.validate.min.js"></script>
    <script src="<%=basePath%>assert/theme/vendors/jquery-steps/js/jquery.steps.min.js"></script>
    <script src="<%=basePath%>assert/theme/vendors/jquery-bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
    <script type='text/javascript' src='<%=basePath%>assert/common/js/jquery.bgiframe.min.js'></script>
	<script type='text/javascript' src='<%=basePath%>assert/common/js/jquery.ajaxQueue.js'></script>
	<script type='text/javascript' src='<%=basePath%>assert/common/js/thickbox-compressed.js'></script>
    <script type="text/javascript" src="<%=basePath%>assert/common/js/jquery.autocomplete.js"></script>
    <script src="<%=basePath%>assert/theme/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="<%=basePath%>assert/common/pagination/js/jquery.pagination.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/tally/list.js"></script>
</body>
</html>
