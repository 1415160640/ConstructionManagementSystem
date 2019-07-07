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
    <title>办理离职</title>
</head>

<body onload="Workload()">
<div class="title"><h2>办理离职</h2></div>
<div class="table-operate ue-clear">
</div>
<div class="table-box">
   <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="150">员工编号</th>
					<th width="250">员工姓名</th>
					<th width="250">入职时间</th>
					<th width="250">联系电话</th>
					<th width="250">未结算工时</th>
					<th width="200">操作</th>
					<th></th>
				    </tr>
					</thead>
					
					<tbody>
					<c:forEach items="${user}" var="p"  varStatus="status">
				      <tr class="text-c">
					    <td>${status.count}</td>
					    <td class="text-l">${p.name}</td>
					    <td class="text-l">${p.date}</td>
					    <td class="text-l">${p.phone}</td>
					    <td class="text-l">${p.time}</td>
						<td class="edit">
						    <c:if test="${p.time == 0}">
						    <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/AdminServlet?method=deleteUser&id=${p.id}'">注销</button>
                            </c:if>
                            <c:if test="${p.time != 0}">
                                   <span class="label label-success radius" style="color:red;">未结算</span>
                            </c:if>
                        </td>
                        <td></td>
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
