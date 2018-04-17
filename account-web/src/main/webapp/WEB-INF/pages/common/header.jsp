<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="header-topbar-option-demo" class="page-header-topbar">
 <nav id="topbar" role="navigation" style="margin-bottom: 0; z-index: 2;" class="navbar navbar-default navbar-static-top">
     <div class="navbar-header">
        <a id="logo" href="main" class="navbar-brand"><span class="fa fa-rocket"></span><span class="logo-text">爱记账</span></a>
     </div>
     <div class="topbar-main"><a id="menu-toggle" href="#" class="hidden-xs"><i class="fa fa-bars"></i></a>
         <ul class="nav navbar navbar-top-links navbar-right mbn">
             <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-bell fa-fw"></i><span class="badge badge-green">3</span></a>
             </li>
             <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-envelope fa-fw"></i><span class="badge badge-orange">7</span></a>
             </li>
             <li class="dropdown hidden-xs">
                 <!--BEGIN THEME SETTING--><a id="theme-setting" href="javascript:;" data-hover="dropdown" data-step="1" data-intro="&lt;b&gt;Header&lt;/b&gt;, &lt;b&gt;sidebar&lt;/b&gt;, &lt;b&gt;border style&lt;/b&gt; and &lt;b&gt;color&lt;/b&gt;, all of them can change for you to create the best" data-position="left" class="dropdown-toggle"><i class="fa fa-cogs"></i></a>
                 <ul class="dropdown-menu dropdown-theme-setting pull-right">
                     <li>
                         <h4 class="mtn">主题</h4>
                         <select id="list-style" class="form-control">
                             <option value="style1">扁平化</option>
                             <option value="style2">扁圆形</option>
                             <option value="style3">平板边框样式</option>
                         </select>
                     </li>
                     <li>
                         <h4 class="mtn">菜单样式</h4>
                         <select id="list-menu" class="form-control">
                             <option value="sidebar-default">菜单主题1</option>
                             <option value="sidebar-colors">菜单主题2</option>
                             <option value="sidebar-icons">菜单主题3</option>
                             <option value="sidebar-collapsed">菜单主题4</option>
                         </select>
                     </li>
                     <li>
                         <h4 class="mtn">页头和侧边栏</h4>
                         <select id="list-header" class="form-control">
                             <option value="header-static">静态</option>
                             <option value="header-fixed">固定</option>
                         </select>
                     </li>
                     <li>
                         <h4 class="mtn">主题颜色</h4>
                         <ul id="list-color" class="list-unstyled list-inline">
                             <li data-color="green-dark" data-hover="tooltip" title="Green - Dark" class="green-dark"></li>
                             <li data-color="red-dark" data-hover="tooltip" title="Red - Dark" class="red-dark"></li>
                             <li data-color="pink-dark" data-hover="tooltip" title="Pink - Dark" class="pink-dark"></li>
                             <li data-color="blue-dark" data-hover="tooltip" title="Blue - Dark" class="blue-dark"></li>
                             <li data-color="yellow-dark" data-hover="tooltip" title="Yellow - Dark" class="yellow-dark"></li>
                             <li data-color="green-grey" data-hover="tooltip" title="Green - Grey" class="green-grey"></li>
                             <li data-color="red-grey" data-hover="tooltip" title="Red - Grey" class="red-grey"></li>
                             <li data-color="pink-grey" data-hover="tooltip" title="Pink - Grey" class="pink-grey"></li>
                             <li data-color="blue-grey" data-hover="tooltip" title="Blue - Grey" class="blue-grey"></li>
                             <li data-color="yellow-grey" data-hover="tooltip" title="Yellow - Grey" class="yellow-grey"></li>
                             <li data-color="yellow-green" data-hover="tooltip" title="Yellow - Green" class="yellow-green"></li>
                             <li data-color="orange-grey" data-hover="tooltip" title="Orange - Grey" class="orange-grey"></li>
                             <li data-color="pink-blue" data-hover="tooltip" title="Pink - Blue" class="pink-blue"></li>
                             <li data-color="pink-violet" data-hover="tooltip" title="Pink - Violet" class="pink-violet active"></li>
                             <li data-color="orange-violet" data-hover="tooltip" title="Orange - Violet" class="orange-violet"></li>
                             <li data-color="pink-green" data-hover="tooltip" title="Pink - Green" class="pink-green"></li>
                             <li data-color="pink-brown" data-hover="tooltip" title="Pink - Brown" class="pink-brown"></li>
                             <li data-color="orange-blue" data-hover="tooltip" title="Orange - Blue" class="orange-blue"></li>
                             <li data-color="yellow-blue" data-hover="tooltip" title="Yellow - Blue" class="yellow-blue"></li>
                             <li data-color="green-blue" data-hover="tooltip" title="Green - Blue" class="green-blue"></li>
                         </ul>
                     </li>
                 </ul>
                 <!--END THEME SETTING-->
                </li>
            </ul>
        </div>
    </nav>
</div>