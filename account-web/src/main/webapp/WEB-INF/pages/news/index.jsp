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
                    	<div class="col-lg-12">
                    		<ul class="nav ul-edit nav-tabs responsive">
                                <li class="active"><a href="#tab-sum" data-toggle="tab">新闻总排行</a>
                                </li>
                                <li><a href="#tab-domestic" data-toggle="tab">国内新闻</a>
                                </li>
                                <li><a href="#tab-international" data-toggle="tab">国际新闻</a>
                                </li>
                                <li><a href="#tab-social" data-toggle="tab">社会新闻</a>
                                </li>
                                <li><a href="#tab-sports" data-toggle="tab">体育新闻</a>
                                </li>
                                <li><a href="#tab-financee" data-toggle="tab">财经新闻</a>
                                </li>
                                <li><a href="#tab-entertainment" data-toggle="tab">娱乐新闻</a>
                                </li>
                                <li><a href="#tab-technology" data-toggle="tab">科技新闻</a>
                                </li>
                                <li><a href="#tab-military" data-toggle="tab">军事新闻</a>
                                </li>
                            </ul>
                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
                             	<div id="tab-sum" class="tab-pane fade active in">
                                    <div class="row">
                                       <div class="col-lg-12">
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
						                                      <tbody id="sum_image_table">
						                                      </tbody>
						                                  </table>
						                              </div>
						                          </div>
						                       </div>
						                       <div class="col-lg-6">
						                       		<div class="panel panel-green">
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
						                                      <tbody id="sum_video_table">
						                                      </tbody>
						                                  </table>
						                              </div>
						                          </div>
						                       </div>
						                    </div>
                                       </div>
                                     </div>
                                     <div class="row">
				                    	<div class="col-lg-12">
				                    	   <div class="panel panel-violet">
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
											                                      <tbody id="sum_hit_table">
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
											                                      <tbody id="sum_diss_table">
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
											                                      <tbody id="sum_share_table">
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
                                 <div id="tab-domestic" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="row">
						                    	<div class="col-lg-12">
						                    	   <div class="panel panel-orange">
						                                <div class="panel-heading">国内新闻</div>
						                                <div class="panel-body">
						                                   <ul class="nav ul-edit nav-tabs responsive">
								                                <li class="active"><a href="#tab-domestic-hit" data-toggle="tab">点击量排行</a>
								                                </li>
								                                <li><a href="#tab-domestic-diss" data-toggle="tab">评论数排行</a>
								                                </li>
								                                <li><a href="#tab-domestic-share" data-toggle="tab">分享数排行</a>
								                                </li>
								                            </ul>
								                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
								                                <div id="tab-domestic-hit" class="tab-pane fade active in">
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
													                                      <tbody id="domestic_hit_table">
													                                      </tbody>
													                                 </table>
								                                                </div>
								                                            </div>
										                                 </div>
										                              </div>
								                                 </div>
								                                 <div id="tab-domestic-diss" class="tab-pane fade">
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
													                                      <tbody id="domestic_diss_table">
													                                      </tbody>
													                                 </table>
								                                                </div>
								                                            </div>
								                                        </div>
								                                    </div>
								                                 </div> 
								                                 <div id="tab-domestic-share" class="tab-pane fade">
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
													                                      <tbody id="domestic_share_table">
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
                                     </div>
                                 </div>
                                 <div id="tab-international" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-green">
				                                <div class="panel-heading">国际新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-international-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-international-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-international-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-international-hit" class="tab-pane fade active in">
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
											                                      <tbody id="international_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-international-diss" class="tab-pane fade">
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
											                                      <tbody id="international_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-international-share" class="tab-pane fade">
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
											                                      <tbody id="international_share_table">
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
                                 <div id="tab-social" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-yellow">
				                                <div class="panel-heading">社会新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-social-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-social-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-social-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-social-hit" class="tab-pane fade active in">
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
											                                      <tbody id="social_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-social-diss" class="tab-pane fade">
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
											                                      <tbody id="social_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-social-share" class="tab-pane fade">
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
											                                      <tbody id="social_share_table">
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
                                 <div id="tab-sports" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-red">
				                                <div class="panel-heading">体育新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-sports-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-sports-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-sports-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-sports-hit" class="tab-pane fade active in">
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
											                                      <tbody id="sports_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-sports-diss" class="tab-pane fade">
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
											                                      <tbody id="sports_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-sports-share" class="tab-pane fade">
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
											                                      <tbody id="sports_share_table">
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
                                 <div id="tab-financee" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-dark">
				                                <div class="panel-heading">财经新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-finance-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-finance-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-finance-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-finance-hit" class="tab-pane fade active in">
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
											                                      <tbody id="finance_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-finance-diss" class="tab-pane fade">
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
											                                      <tbody id="finance_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-finance-share" class="tab-pane fade">
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
											                                      <tbody id="finance_share_table">
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
                                 <div id="tab-entertainment" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-grey">
				                                <div class="panel-heading">娱乐新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-entertainment-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-entertainment-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-entertainment-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-entertainment-hit" class="tab-pane fade active in">
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
											                                      <tbody id="entertainment_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-entertainment-diss" class="tab-pane fade">
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
											                                      <tbody id="entertainment_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-entertainment-share" class="tab-pane fade">
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
											                                      <tbody id="entertainment_share_table">
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
                                 <div id="tab-technology" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-pink">
				                                <div class="panel-heading">科技新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-technology-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-technology-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-technology-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-technology-hit" class="tab-pane fade active in">
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
											                                      <tbody id="technology_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-technology-diss" class="tab-pane fade">
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
											                                      <tbody id="technology_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-technology-share" class="tab-pane fade">
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
											                                      <tbody id="technology_share_table">
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
                                 <div id="tab-military" class="tab-pane fade">
                                    <div class="row">
                                       <div class="col-lg-12">
                                       		<div class="panel panel-green">
				                                <div class="panel-heading">军事新闻</div>
				                                <div class="panel-body">
				                                   <ul class="nav ul-edit nav-tabs responsive">
						                                <li class="active"><a href="#tab-military-hit" data-toggle="tab">点击量排行</a>
						                                </li>
						                                <li><a href="#tab-military-diss" data-toggle="tab">评论数排行</a>
						                                </li>
						                                <li><a href="#tab-military-share" data-toggle="tab">分享数排行</a>
						                                </li>
						                            </ul>
						                             <div style="background: transparent; border: 0; box-shadow: none !important" class="tab-content pan mtl mbn responsive">
						                                <div id="tab-military-hit" class="tab-pane fade active in">
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
											                                      <tbody id="military_hit_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
								                                 </div>
								                              </div>
						                                 </div>
						                                 <div id="tab-military-diss" class="tab-pane fade">
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
											                                      <tbody id="military_diss_table">
											                                      </tbody>
											                                 </table>
						                                                </div>
						                                            </div>
						                                        </div>
						                                    </div>
						                                 </div> 
						                                 <div id="tab-military-share" class="tab-pane fade">
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
											                                      <tbody id="military_share_table">
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
