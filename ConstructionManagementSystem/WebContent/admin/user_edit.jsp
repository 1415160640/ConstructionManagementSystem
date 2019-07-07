<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/static/h-ui.admin/css/H-ui.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/static/h-ui.admin/css/H-ui.admin.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/static/h-ui.admin/font/font-awesome.min.css"/>
<title>编辑用户</title>
</head>
<body>
<div class="pd-20">
  <div class="Huiform">
    <form action="${pageContext.request.contextPath}/AdminServlet?method=editUser" method="post">
      <table class="table table-bg">
          
        <tbody>
          <tr>
            <th  class="text-r">姓名：</th>
            <td>
              <input type="hidden" value="${user.id}" name="id" />
              <input type="hidden" value="${user.date}" name="date" />
              <input type="text" style="width:200px" class="input-text" value="${user.name}" id="user-name" name="name" datatype="*2-16" >
            </td>
          </tr>
          <tr>
            <th class="text-r">住址：</th>
            <td><input type="text" style="width:300px" class="input-text" value="${user.address}" placeholder="" id="user-tel" name="address"></td>
          </tr>
          <tr>
            <th class="text-r">身份证号码：</th>
            <td><input type="text" style="width:300px" class="input-text" value="${user.pid}" placeholder="" id="user-tel" name="pid"></td>
          </tr>
           <tr>
            <th class="text-r">联系电话：</th>
            <td><input type="text" style="width:300px" class="input-text" value="${user.phone}" placeholder="" id="user-tel" name="phone"></td>
          </tr>
          <tr>
             <th class="text-r">&nbsp;&nbsp;&nbsp;入职时间：&nbsp;&nbsp;&nbsp;${user.date}</th>
          </tr>
          <tr>
            <th class="text-r">&nbsp;&nbsp;&nbsp;未结算工时：&nbsp;&nbsp;&nbsp;${user.time}</th>
          </tr>
          <tr>
            <th></th>
            <td><button class="btn btn-success radius" type="submit"><i class="icon-ok"></i> 确定</button></td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</div>
</body>
</html>