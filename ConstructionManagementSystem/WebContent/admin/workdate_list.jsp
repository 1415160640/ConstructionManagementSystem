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
    <title>员工工时</title>
</head>

<body onload="Workload()">
<div class="title"><h2>员工工时</h2></div>
<div class="query">
</div>
<div class="table-operate ue-clear">
</div>
<div class="table-box">
   <table class="table" id="tbRecord">
					<thead>
					<tr >
					<th width="200">编号</th>
					<th width="280">员工姓名</th>
					<th width="280">当前未结算工时(小时)</th>
					<th width="250"><div id="time"></div></th>
					<th width="250">操作</th>
					<th ></th>
				    </tr>
					</thead>
					
					<tbody>
					<c:forEach items="${user}" var="p"  varStatus="status">
				      <tr class="text-c">
					    <td>${status.count}</td>
					    <td class="text-l">${p.name}</td>
					    <td>${p.time}</td>
					    <td> 
					        <form action="${pageContext.request.contextPath}/AdminServlet?method=addWorkDate&id=${p.id}" method="post">
                            <input type="text" placeholder="输入员工今日工时"  name="num" />
                            <button type="submit">添加</button>
                            </form>
					    </td>
						<td class="edit">
						    <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/AdminServlet?method=editWorkDateUI&id=${p.id}'">修改</button>
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
<script>
window.onload=function(){

//定时器每秒调用一次fnDate()
setInterval(function(){
fnDate();
},1000);
}
//js 获取当前时间
function fnDate(){
var oDiv=document.getElementById("time");
var date=new Date();
var year=date.getFullYear();//当前年份
var month=date.getMonth();//当前月份
var data=date.getDate();//天
var hours=date.getHours();//小时
var minute=date.getMinutes();//分
var second=date.getSeconds();//秒
var time="当前日期:"+year+"/"+fnW((month+1))+"/"+fnW(data);
oDiv.innerHTML=time;
}
//补位 当某个字段不是两位数时补0
function fnW(str){
var num;
str>10?num=str:num="0"+str;
return num;
} 
</script>
<script src="${pageContext.request.contextPath}/admin/js/layer_v2.1/layer/layer.js"></script>
</html>
