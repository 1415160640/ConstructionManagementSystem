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
<title>员工不良记录</title>
</head>
<body>
<div class="pd-20">
  <div class="Huiform">
    <form action="${pageContext.request.contextPath}/AdminServlet?method=addBad" method="post">
      <table class="table table-bg">
        <tbody>
           <tr>
            <th class="text-r">员工姓名：</th>
            <td><input type="text" style="width:300px" class="input-text" value="" placeholder="" id="user-tel" name="name"></td>
           </tr>
             <tr>
            <th  class="text-r">原因：</th>
            <td><input type="text" style="width:200px" class="input-text" value="" placeholder="" id="user-name" name="type" datatype="*2-16" nullmsg="项目名不能为空"></td>
          </tr>
          <tr>
            <th class="text-r">日期：</th>
            <td><input type="date" style="width:300px" class="input-text" value="" placeholder="" id="user-tel" name="date"></td>
          </tr>
          <tr>
            <th class="text-r">类型：</th>
            <td>
                  <select name="cid">
						 <option value="1">施工延时</option>
						 <option value="2">缺勤</option>
				  </select>
            </td>
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