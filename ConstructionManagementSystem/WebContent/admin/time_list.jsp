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
    <title>时间管理</title>
</head>

<body onload="Workload()">
<div class="title"><h2>时间管理</h2></div>
<div class="query">
设置按月计算奖励起算工时<br />
设置每天工作时间<br />
该月超过限定次数不合格的员工不给予相应奖励
</div>
<div class="table-operate ue-clear">
</div>
<div class="table-box">
   <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="100">编号</th>
					<th width="250">描述</th>
					<th width="100">数据（小时）</th>
					<th width="200">设置</th>
					<th ></th>
				    </tr>
					</thead>
					
					<tbody>
					<c:forEach items="${time}" var="p"  varStatus="status">
				      <tr class="text-c">
					    <td>${status.count}</td>
					    <td class="text-l">${p.name}</td>
					    <td>${p.num}</td>
					    <td> 
					        <form action="${pageContext.request.contextPath}/AdminMoneyServlet?method=updateTimeNum&id=${p.id}" method="post">
                            <input type="text"  name="num" />
                            <button type="submit">修改</button>
                            </form>
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
