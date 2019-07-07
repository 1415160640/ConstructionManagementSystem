<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/jquery.dialog.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/index.css" />
    <style>
        .layui-layer-title{background:url(${pageContext.request.contextPath}/admin/images/righttitlebig.png) repeat-x;font-weight:bold;color:#46647e; border:1px solid #c1d3de;height: 33px;line-height: 33px;}
    </style>
<title>施工管理系统</title>
</head>
<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap ue-clear">
        	<div class="top-light"></div>
            <div class="login-info ue-clear">
                <div class="welcome ue-clear"><span>欢迎您,</span>${Admin.username}</div>
            </div>
            <div class="toolbar ue-clear">
                <a href="${pageContext.request.contextPath}/AdminServlet?method=index" class="home-btn" target="right">首页</a>
                <a href="javascript:void(0)" class="home-btn1" target="right" onclick="openlayer()">修改密码</a>
                <a href="javascript:void(0)" class="quit-btn exit home-btn">退出</a>
            </div>
        </div>
    </div>
    <div id="bd">
    	<div class="wrap ue-clear">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
                	<li class="office current"><div class="nav-header"><a href="${pageContext.request.contextPath}/AdminServlet?method=index" target="right" class="ue-clear"><span>首页</span><i class="icon"></i></a></div></li>
                    <li class="land"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>项目管理</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findProject" target="right">所有项目</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findProjectNo" target="right">未开始项目</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findProjectStart" target="right">施工项目</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findProjectEnd" target="right">已完成项目</a></li>
                        </ul>
                    </li>

                    <li class="train"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>采购管理</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findCate" target="right">材料管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findBuy" target="right">采购记录</a></li>
                        </ul>
                    </li>
                    <li class="news_m"><div class="nav-header"><a href="JavaScript:;" class="ue-clear"  target="right"><span>施工进度</span><i class="icon"></i></a></div>
                         <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findWork" target="right">所有施工</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkStart" target="right">正在施工</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkEnd" target="right">已完成施工</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findBadWork" target="right">延期记录</a></li>
                        </ul>
                    </li>
                    <li class="dossier"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>员工管理</span><i class="icon hasChild"></i></a></div>
                         <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findUser" target="right">人员信息</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkDate" target="right">员工工时</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findBadTime" target="right">缺勤记录</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminServlet?method=findOutUser" target="right">离职办理</a></li>
                        </ul>
                    </li>
                    <li class="list_m"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" target="right"><span>财务管理</span><i class="icon"></i></a></div>
                        <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findMoney&num=1" target="right">项目收入</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findMoney&num=2" target="right">采购支出</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findMoney&num=3" target="right">工资支出</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findMoney&num=4" target="right">其他支出</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findBorrow" target="right">工资预支</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findWorkMoney" target="right">工资结算</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findAllMoney" target="right">当月账单</a></li>
                        </ul>
                    </li>
                    <li class="part"><div class="nav-header"><a href="JavaScript:;" class="ue-clear" ><span>系统设置</span><i class="icon hasChild"></i></a></div>
                        <ul class="subnav">
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findSpring" target="right">奖励设置</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findTime" target="right">时间设置</a></li>
                        </ul>
                    </li>

                    
                    
                </ul>
            </div>
            <div class="content">
            	<iframe src="${pageContext.request.contextPath}/AdminServlet?method=index" id="iframe" width="100%" height="100%" frameborder="0" name="right" style="min-width: 1100px"></iframe>
            </div>
        </div>
    </div>
    <div id="ft" class="foot_div">

            <span>施工管理</span>

    </div>
</div>
<div class="exitDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.dialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/index.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/layer_v2.1/layer/layer.js"></script>
<script type="text/javascript">
    function openlayer(id){
        layer.open({
            type: 2,
            title: '修改密码',
            shadeClose: false,
            shade: 0.5,
            skin: 'layui-layer-rim',
            maxmin: true,
            closeBtn:2,
            area: ['35%', '40%'],
            content: '/ConstructionManagementSystem/admin/password.jsp'
            //iframe的url
        });
    }
</script>
</html>
