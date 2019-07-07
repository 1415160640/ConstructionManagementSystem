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
    <title>工资结算</title>
</head>

<body onload="Workload()">
<div class="title"><h2>工资结算</h2></div>
<div class="query">
查询30天内员工不良记录综合预支工资情况奖励设置得出应支付工资(当前设定为不超过${time[2].num}次/月)<br />
全勤与无延时奖励工时需要大于限定工时才会计入(当前设定为${time[0].num}小时/月)<br />
其他按天计算奖励参照每天设置工作时间计算(当前设定为${time[1].num}小时/天)
</div>
<div class="table-operate ue-clear">
</div>
<div class="table-box">
   <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="80">编号</th>
					<th width="150">员工</th>
					<th width="150">已预支工资</th>
					<th width="150">未结算工时</th>
					<th width="150">延时施工次数</th>
					<th width="100">缺勤次数</th>
					<th>工资计算</th>
					<th width="120">应付工资</th>
					<th width="80">结算</th>
				    </tr>
					</thead>
					
					<tbody>
					<c:forEach items="${wages}" var="p"  varStatus="status">
				      <tr class="text-c">
					    <td>${status.count}</td>
					    <td>${p.name}</td>
					    <td>${p.borrow.money}</td>
					    <td>${p.time}</td>
					    <td>${p.badwork}</td>
					    <td>${p.baddate}</td>
					    <td>
					        工时工资（${p.workdatemoney}）+施工无延时奖励（${p.badworkmoney}）+全勤奖励（${p.baddatemoney}）+其他奖励（${p.othermoney}）-已预支工资（${p.borrow.money}）
					    </td>
					    <td>${p.count}</td>
					    <td> 
					        <c:if test="${p.count != 0}">
                            <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/AdminMoneyServlet?method=endMoney&id=${p.id}&count=${p.count}&bid=${p.borrow.id}'">结算</button>
                            </c:if>
                            <c:if test="${p.count == 0}">
                            <span class="label label-success radius" style="color:green;">已结算</span>
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
