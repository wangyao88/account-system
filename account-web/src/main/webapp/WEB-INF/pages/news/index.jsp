<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>爱记账-时事新闻</title>
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
			<%@ include file="index_menu.jsp"%>
			<!--BEGIN PAGE WRAPPER-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<div class="page-header pull-left">
						<div class="page-title">时事新闻</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div class="row">
                       <div class="col-lg-6">
                       		<div class="panel panel-blue">
                                <div class="panel-heading">图片排行</div>
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
                                      <tbody id="image_table">
                                      </tbody>
                                  </table>
                              </div>
                          </div>
                       </div>
                       <div class="col-lg-6">
                       		<div class="panel panel-blue">
                                <div class="panel-heading">视频排行</div>
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
                                      <tbody id="video_table">
                                      </tbody>
                                  </table>
                              </div>
                          </div>
                       </div>
                    </div>
                    <div class="row">
                    	<div class="col-lg-12">
                    	   <div class="panel panel-blue">
                                <div class="panel-heading">新闻总排行</div>
                                <div class="panel-body">
                                   <ul class="nav ul-edit nav-tabs responsive">
		                                <li class="active"><a href="#tab-sum-hit" data-toggle="tab">点击量排行</a>
		                                </li>
		                                <li><a href="#tab-sum-diss" data-toggle="tab">评论数排行</a>
		                                </li>
		                                <li><a href="#tab-sum-share" data-toggle="tab">分享数排行</a>
		                                </li>
		                            </ul>
		                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
		                                <div id="tab-sum-hit" class="tab-pane fade active in">
		                                     <div class="row">
		                                        <div class="col-lg-12">
		                                            <div class="panel panel-yellow">
		                                                <div class="panel-body pan">
		                                                	<table class="table table-hover table-bordered">
							                                      <thead>
							                                          <tr>
							                                              <th>序号</th>
							                                              <th>标题</th>
							                                              <th>媒体</th>
							                                              <th>时间</th>
							                                          </tr>
							                                      </thead>
							                                      <tbody id="hit_table">
							                                      </tbody>
							                                 </table>
		                                                </div>
		                                            </div>
				                                 </div>
				                              </div>
		                                 </div>
		                                 <div id="tab-sum-diss" class="tab-pane fade">
		                                    <div class="row">
		                                        <div class="col-lg-12">
		                                        	<div class="panel panel-yellow">
		                                                <div class="panel-body pan">
		                                                	<table class="table table-hover table-bordered">
							                                      <thead>
							                                          <tr>
							                                              <th>序号</th>
							                                              <th>标题</th>
							                                              <th>评论数</th>
							                                              <th>时间</th>
							                                          </tr>
							                                      </thead>
							                                      <tbody id="diss_table">
							                                      </tbody>
							                                 </table>
		                                                </div>
		                                            </div>
		                                        </div>
		                                    </div>
		                                 </div> 
		                                 <div id="tab-sum-share" class="tab-pane fade">
		                                    <div class="row">
		                                        <div class="col-lg-12">
		                                        	<div class="panel panel-yellow">
		                                                <div class="panel-body pan">
		                                                	<table class="table table-hover table-bordered">
							                                      <thead>
							                                          <tr>
							                                              <th>序号</th>
							                                              <th>标题</th>
							                                              <th>分享数</th>
							                                              <th>时间</th>
							                                          </tr>
							                                      </thead>
							                                      <tbody id="share_table">
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
	<script type="text/javascript" src="<%=basePath%>assert/news/news.js"></script>
</body>
</html>
