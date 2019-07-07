<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/admin/css/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/base.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/info-mgt.css" />
    <style>
        .layui-layer-title{background:url(images/righttitlebig.png) repeat-x;font-weight:bold;color:#46647e; border:1px solid #c1d3de;height: 33px;line-height: 33px;}
        .tabe_bot label{width: 70px;text-align: right;font-size: 14px;font-weight: 900;color: #46647e}
        .l_left{float: left}
        .tabe_bot input,.tabe_bot  select{width: 180px;height: 30px;border-radius: 6px;margin:0 20px 0 0;border: none;border: 1px #ccc solid;text-indent: 1em}
        .tabe_btn{width: 60px;height: 30px;background-color: #68b86c;border: none;border-radius: 6px;color: #fff}
    </style>
    <title>所有项目</title>
</head>

<body onload="Workload()">
<div class="title"><h2>所有项目</h2></div>
<div class="query">
    <div class="tabe_bot">
        <form action="${pageContext.request.contextPath}/AdminServlet?method=SearProject" method="post">
        <div class="l_left"><label>起始日期：</label><input id="demo" placeholder="查询开始于该日期之后的项目" name="date" /></div>
        <button class="tabe_btn " type="submit">查询</button>
        </form>
        <div class="clear"></div>
    </div>
</div>
<div class="table-operate ue-clear">
		<a href="${pageContext.request.contextPath}/admin/project-add2.jsp" class="add" onclick="addWork()">添加</a>
	</div>
<div class="table-box">
   <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="100">项目编号</th>
					<th>项目内容</th>
					<th width="180">开始时间</th>
					<th width="180">结束时间</th>
					<th width="150">金额</th>
					<th width="150">状态</th>
					<th width="150">操作</th>
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
						<td class="edit">
						<c:if test="${p.state == 2 or p.state == 3}">
							<button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/AdminServlet?method=UpdateProject&id=${p.id}'">确认完成</button>
						</c:if>
						    <c:if test="${p.state != 4}">
						    <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/AdminServlet?method=editProjectUI&id=${p.id}'">修改</button>
						    </c:if>
						    <c:if test="${p.state == 4}">
                            <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/AdminServlet?method=deleteProject&id=${p.id}'">删除</button>
                            </c:if>
                        </td>
						</tr>
					</c:forEach>
									
					</tbody>
									
		</table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>

<script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/date/js/laydate.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/mywork.js"></script>

<script>
    !function(){
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({elem: '#demo'});//绑定元素
    }();
</script>
<script src="${pageContext.request.contextPath}/admin/js/layer_v2.1/layer/layer.js"></script>
</html>
