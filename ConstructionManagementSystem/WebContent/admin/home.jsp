<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/home.css" />
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">-->
    <link href="${pageContext.request.contextPath}/admin/css/bootstrap-table.css" rel="stylesheet" type="text/css">
<title>移动办公自动化系统</title>
</head>

<body>
<div class="article toolbar">
	<div class="title ue-clear">
    	<h2>常用功能</h2>
        <!--<a href="javascript:;" class="more">更多</a>-->
    </div>
    <div class="content">
    	<ul class="toollist ue-clear">
    	    <li>
            	<a href="${pageContext.request.contextPath}/AdminServlet?method=findProjectStart" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/posintion01.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminServlet?method=findProjectStart" target="right">施工项目</a></p>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/AdminServlet?method=findCate" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/icon07.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminServlet?method=findCate" target="right">材料管理</a></p>
            </li>
            <li>
            	<a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkStart" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/file03.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkStart" target="right">施工进度</a></p>
            </li>
            <li>
            	<a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkDate" class="img"><img src="${pageContext.request.contextPath}/admin/images/leave01.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminServlet?method=findWorkDate">工时记录</a></p>
            </li>
            <li>
            	<a href="${pageContext.request.contextPath}/AdminServlet?method=findBadTime" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/file02.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminServlet?method=findBadTime" target="right">缺勤记录</a></p>
            </li>
            	<li>
            	<a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findMoney&num=4" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/icon01.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findMoney&num=4" target="right">财务报销</a></p>
            </li>
             <li>
            	<a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findWorkMoney" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/icon04.png"/></a>
                <p><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findWorkMoney" onclick="openlayer()">工资结算</a></p>
            </li>
             <li>
                <a href="${pageContext.request.contextPath}/AdminServlet?method=findOutUser" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/myFiles.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminServlet?method=findOutUser" target="right">离职办理</a></p>
            </li>
            <li>
            	<a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findAllMoney" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/icon02.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findAllMoney" target="right">当月账单</a></p>
            </li>
            <li>
            	<a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findTime" class="img" target="right"><img src="${pageContext.request.contextPath}/admin/images/datecion01.png" /></a>
                <p><a href="${pageContext.request.contextPath}/AdminMoneyServlet?method=findTime" target="right">时间设定</a></p>
            </li>
            <li class="add-btn">
            	<img src="${pageContext.request.contextPath}/admin/images/add.png" />
            </li>
    	</ul>
        
    </div>
</div>
<div class="article half email">
	<div class="wrap-l">
        <div class="title ue-clear">
            <h2>施工项目</h2>
            <a href="${pageContext.request.contextPath}/AdminServlet?method=findProject" class="more" target="right">更多</a>
        </div>
        <div class="content">
            <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="100">项目编号</th>
					<th>项目内容</th>
					<th width="150">开始时间</th>
					<th width="150">结束时间</th>
					<th width="120">金额</th>
					<th width="120">状态</th>
				    </tr>
					</thead>
					
					<tbody>
					<c:forEach items="${pro}" var="p"  varStatus="status">
				      <tr class="text-c">
					    <td>${status.count}</td>
					    <td class="text-l">${p.name}</td>
					    <td>${p.start}</td>
					    <td>${p.end}</td>
					    <td>${p.money}</td>
					   <td class="td-status">
					    <c:if test="${p.state == 1}">
					    <span class="label label-success radius">未开始</span>
					    </c:if>
					    <c:if test="${p.state == 2}">
					    <span class="label label-success radius" style="color:blue;">施工中</span>
					    </c:if>
					    <c:if test="${p.state == 3}">
					    <span class="label label-success radius" style="color:red;">已延期</span>
					    </c:if>
					    <c:if test="${p.state == 4}">
					    <span class="label label-success radius" style="color:green;">已完成</span>
					    </c:if>
					   </td>
						</tr>
					</c:forEach>
									
					</tbody>
									
		</table>
        </div>
    </div>
</div>
<div class="article half email">
	<div class="wrap-l">
         <div class="title ue-clear">
            <h2>进度安排</h2>
            <a href="${pageContext.request.contextPath}/AdminServlet?method=findWork" class="more" target="right">更多</a>
        </div>
        <div class="content">
           <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="100">施工编号</th>
					<th>施工内容</th>
					<th width="150">开始时间</th>
					<th width="150">结束时间</th>
					<th width="120">责任人</th>
					<th width="120">状态</th>
				    </tr>
					</thead>
					
					<tbody>
					<c:forEach items="${work}" var="p"  varStatus="status">
				      <tr class="text-c">
					    <td>${status.count}</td>
					    <td class="text-l">${p.name}</td>
					    <td>${p.start}</td>
					    <td>${p.end}</td>
					    <td>${p.user.name}</td>
					   <td class="td-status">
					    <c:if test="${p.state == 1}">
					    <span class="label label-success radius">未开始</span>
					    </c:if>
					    <c:if test="${p.state == 2}">
					    <span class="label label-success radius" style="color:blue;">施工中</span>
					    </c:if>
					    <c:if test="${p.state == 3}">
					    <span class="label label-success radius" style="color:red;">已延期</span>
					    </c:if>
					    <c:if test="${p.state == 4}">
					    <span class="label label-success radius" style="color:green;">已完成</span>
					    </c:if>
					   </td>
						</tr>
					</c:forEach>				
					</tbody>								
		  </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/common.js"></script>
<script type="text/javascript">
$(".title-list ul").on("click","li",function(){
	var aIndex = $(this).index();
	$(this).addClass("current").siblings().removeClass("current");
	$(".matter-content").removeClass("current").eq(aIndex).addClass("current");
});

$(".duty").find("tbody").find("tr:even").css("backgroundColor","#eff6fa");
</script>
<script src="js/layer_v2.1/layer/layer.js"></script>
</html>
