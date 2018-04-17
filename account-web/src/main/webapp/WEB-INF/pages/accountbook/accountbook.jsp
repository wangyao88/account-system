<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-账本管理</title>
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
			<%@ include file="../common/menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">账本管理</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div id="tab-general">
					    <div id="accountbook_operation" class="row mbl">
					    	<div class="col-lg-6">
                                 <div class="panel panel-violet">
                                     <div class="panel-heading">新增账本</div>
                                     <div class="panel-body pan">
                                         <form action="accountbook/save" method="post" class="form-horizontal">
                                             <div class="form-body pal">
                                                 <div class="form-group">
                                                     <label for="create_account_name" class="col-md-3 control-label">账本名称 <span class='require'>*</span>
                                                     </label>
                                                     <div class="col-md-9">
                                                         <div class="input-icon"><i class="fa fa-user"></i>
                                                             <input id="create_account_name" name="name" type="text" placeholder="账本名称" class="form-control" />
                                                         </div>
                                                     </div>
                                                 </div>
                                                 <div class="form-group mbn">
                                                     <label for="create_account_describe" class="col-md-3 control-label">账本描述</label>
                                                     <div class="col-md-9">
                                                         <textarea id="create_account_describe" name="describe" rows="3" class="form-control" placeholder="账本描述"></textarea>
                                                     </div>
                                                 </div>
                                             </div>
                                             <div class="form-actions">
                                                 <div class="col-md-offset-3 col-md-9">
                                                     <button type="submit" class="btn btn-primary">增加</button>&nbsp;
                                                     <button type="button" class="btn btn-green">取消</button>
                                                 </div>
                                             </div>
                                         </form>
                                     </div>
                                 </div>
                             </div>
                             
                             <div class="col-lg-6">
                                 <div class="panel panel-green">
                                     <div class="panel-heading">修改账本</div>
                                     <div class="panel-body pan">
                                         <form action="#" class="form-horizontal">
                                             <div class="form-body pal">
                                                 <div class="form-group">
                                                     <label for="update_account_name" class="col-md-3 control-label">账本名称 <span class='require'>*</span>
                                                     </label>
                                                     <div class="col-md-9">
                                                         <div class="input-icon"><i class="fa fa-user"></i>
                                                             <input id="update_account_name" type="text" placeholder="账本名称" class="form-control" />
                                                         </div>
                                                     </div>
                                                 </div>
                                                 <div class="form-group mbn">
                                                     <label for="update_account_describe" class="col-md-3 control-label">账本描述</label>
                                                     <div class="col-md-9">
                                                         <textarea id="update_account_describe" rows="3" class="form-control" placeholder="账本描述"></textarea>
                                                     </div>
                                                 </div>
                                             </div>
                                             <div class="form-actions">
                                                 <div class="col-md-offset-3 col-md-9">
                                                     <button type="submit" class="btn btn-primary">修改</button>&nbsp;
                                                     <button type="button" class="btn btn-green">取消</button>
                                                 </div>
                                             </div>
                                         </form>
                                     </div>
                                 </div>
                             </div>
					    </div>
						<div id="sum_box" class="row mbl">
							<div class="col-sm-6 col-md-3">
								<div class="panel profit db mbm">
									<div class="panel-body">
										<p class="icon">
											<i class="icon fa fa-shopping-cart"></i>
										</p>
										<h4 class="value">
											<span>215</span><span>$</span>
										</h4>
										<p class="description">Profit description</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="panel income db mbm">
									<div class="panel-body">
										<p class="icon">
											<i class="icon fa fa-money"></i>
										</p>
										<h4 class="value">
											<span>215</span><span>$</span>
										</h4>
										<p class="description">Income detail</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="panel task db mbm">
									<div class="panel-body">
										<p class="icon">
											<i class="icon fa fa-signal"></i>
										</p>
										<h4 class="value">
											<span>215</span>
										</h4>
										<p class="description">Task completed</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="panel visit db mbm">
									<div class="panel-body">
										<p class="icon">
											<i class="icon fa fa-group"></i>
										</p>
										<h4 class="value">
											<span>128</span>
										</h4>
										<p class="description">Visitor description</p>
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
