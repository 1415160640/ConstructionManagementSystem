<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
</head>
<body>
           <form action="${pageContext.request.contextPath}/AdminUserServlet?method=updatePass" method="post" target="_parent">
		    <div >
						<label >原密码</label>
						<div >
								<input type="text" id="user-name" required
										placeholder="原密码" name="password" />
						</div>
			</div>
							<div >
								<label >新密码</label>
								<div >
									<input type="text" id="user-name" required
										placeholder="新密码" name="newpass" />
								</div>
							</div>
							<div >
								<div >
									<input type="submit"value="修改" />
								</div>
			</div>
</form>
</body>
</html>