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
		<div id="error_msg" value="${error_msg}" style="display: none;">
		
		</div>
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
                                         <form action="accountbook/update" method="post" class="form-horizontal">
                                             <div class="form-body pal">
                                                 <div class="form-group">
                                                     <label for="update_account_name" class="col-md-3 control-label">账本名称 <span class='require'>*</span>
                                                     </label>
                                                     <div class="col-md-9">
                                                         <div class="input-icon"><i class="fa fa-user"></i>
                                                             <input id="update_account_id" name="id" type="hidden" placeholder="账本ID" class="form-control" />
                                                             <input id="update_account_name" name="name" type="text" placeholder="账本名称" class="form-control" />
                                                         </div>
                                                     </div>
                                                 </div>
                                                 <div class="form-group mbn">
                                                     <label for="update_account_describe" class="col-md-3 control-label">账本描述</label>
                                                     <div class="col-md-9">
                                                         <textarea id="update_account_describe" name="describe" rows="3" class="form-control" placeholder="账本描述"></textarea>
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
					    
					    <div class="col-lg-12">
                            <div class="portlet box">
                                <div class="portlet-body">
                                    <div class="row mbm">
                                        <div class="col-lg-12">
											<div class="panel panel-blue">
				                                <div class="panel-heading">账本列表</div>
				                                <div class="panel-body">
				                                    <table class="table table-hover table-bordered">
				                                        <thead>
				                                            <tr>
				                                                <th>序号</th>
				                                                <th>名称</th>
				                                                <th>创建时间</th>
				                                                <th>收入</th>
				                                                <th>支出</th>
				                                                <th>结余</th>
				                                                <th>备注</th>
				                                            </tr>
				                                        </thead>
				                                        <tbody id="account_book_table">
				                                        </tbody>
				                                    </table>
				                                </div>
				                            </div>
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
	<script type="text/javascript" src="<%=basePath%>assert/layer/layer.js"></script>
	<script type="text/javascript" src="<%=basePath%>assert/accountbook/accountbook.js"></script>
</body>
</html>
