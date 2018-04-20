<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-收入类别管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
    <%@ include file="../common/css.jsp"%>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/theme/vendors/jquery-nestable/nestable.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>assert/category/incomecategory.css">
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
						<div class="page-title">收入类别管理</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div id="tab-general">
					    <div class="row mbl">
					    	<div class="col-lg-12">
	                            <button type="button" class="btn btn-red btn-square" onclick="addRootIncomeCategory()">添加类别</button>
	                            <button type="button" class="btn btn-orange btn-square" onclick="addChildIncomeCategory()">添加子类别</button>
	                            <button type="button" class="btn btn-green btn-square" onclick="updateIncomeCategory()">修改类别</button>
	                        </div>
					    </div>
					    
                        <div class="row mbl">
					        <div class="col-lg-6">
					        	<div class="panel">
	                                <div class="panel-body">
	                                
		                                <div class="row mbl">
			                                <div class="col-lg-6">
			                                  	<h4 class="block-heading">类别列表</h4>
			                                </div>
			                                <div class="col-lg-2">
				                                <select id="accountbook_select" class="form-control" onchange="getIncomeCategoryDataWhenChange()">
			                                     </select>
			                                </div>
		                                 </div>
	                                    
	                                    
	                                     <div id="nestable3" class="dd">
	                                         <div id="select_item_id" style="display: none;"></div>
	                                         <ol id="tree_list" class="dd-list">
	                                         
	                                         </ol>
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
	<script src="<%=basePath%>assert/theme/vendors/jquery-nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/layer/layer.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/category/incomecategory.js"></script>
</body>
</html>
