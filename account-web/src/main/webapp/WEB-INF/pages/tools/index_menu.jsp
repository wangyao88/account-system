<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<nav id="sidebar" role="navigation" class="navbar-default navbar-static-side">
    <div class="sidebar-collapse menu-scroll">
        <ul id="side-menu" class="nav">
            <li class="user-panel">
                <div class="info">
                    <p>${username}</p>
                    <ul class="list-inline list-unstyled">
                        <li><a href="extra-profile.html" data-hover="tooltip" title="个人信息"><i class="fa fa-user"></i></a>
                        </li>
                        <li><a href="logout" data-hover="tooltip" title="退出"><i class="fa fa-sign-out"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </li>
            <li><a href="main"><i class="fa fa-tachometer fa-fw"><div class="icon-bg bg-orange"></div></i><span class="menu-title">首页</span></a>
            </li>
            <li><a href="accountbook/index" target="_self"><i class="fa fa-bullhorn fa-fw"><div class="icon-bg bg-orange"></div></i><span class="menu-title">账本管理</span></a>
            </li>
            <li><a href="#"><i class="fa fa-desktop fa-fw"><div class="icon-bg bg-pink"></div></i><span class="menu-title">收支类别管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="incomecategory/index"><i class="fa fa-align-left"></i><span class="submenu-title">收入类别管理</span></a>
                    </li>
                    <li><a href="outcomecategory/index"><i class="fa fa-angle-double-left"></i><span class="submenu-title">支出类别管理</span></a>
                    </li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-slack fa-fw"><div class="icon-bg bg-green"></div></i><span class="menu-title">记账管理</span><span class="fa arrow"></span></a>
            	<ul class="nav nav-second-level">
                    <li><a href="tally/index"><i class="fa fa-chain"></i><span class="submenu-title">记账</span></a>
                    </li>
                    <li><a href="tally/list"><i class="fa fa-group"></i><span class="submenu-title">查账</span></a>
                    </li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-send-o fa-fw"><div class="icon-bg bg-green"></div></i><span class="menu-title">财富统计</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="statistics/income/index"><i class="fa fa-briefcase"></i><span class="submenu-title">收入统计</span></a>
                    </li>
                    <li><a href="statistics/outcome/index"><i class="fa fa-instagram"></i><span class="submenu-title">支出统计</span></a>
                    </li>
                    <li><a href="statistics/all/index"><i class="fa fa-hand-o-up"></i><span class="submenu-title">总和统计</span></a>
                    </li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-rocket fa-fw"><div class="icon-bg bg-green"></div></i><span class="menu-title">专属空间</span><span class="fa arrow"></span></a>
            	<ul class="nav nav-second-level">
                    <li><a href="extra-profile.html"><i class="fa fa-user"></i><span class="submenu-title">日记</span></a>
                    </li>
                    <li><a href="extra-signin.html"><i class="fa fa-sign-in"></i><span class="submenu-title">财富树</span></a>
                    </li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-edit fa-fw"><div class="icon-bg bg-violet"></div></i><span class="menu-title">时事新闻</span></a>
            </li>
            <li class="active"><a href="tools/index"><i class="fa fa-th-list fa-fw"><div class="icon-bg bg-blue"></div></i><span class="menu-title">小工具</span></a>
            </li>
            <li><a href="#"><i class="fa fa-database fa-fw"><div class="icon-bg bg-red"></div></i><span class="menu-title">任务管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="#"><i class="fa fa-th-large"></i><span class="submenu-title">待办事项</span></a>
                    </li>
                    <li><a href="extra-invoice.html"><i class="fa fa-print"></i><span class="submenu-title">任务设置</span></a>
                    </li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-file-o fa-fw"><div class="icon-bg bg-yellow"></div></i><span class="menu-title">个人设置</span></a>
            </li>
        </ul>
    </div>
</nav>
