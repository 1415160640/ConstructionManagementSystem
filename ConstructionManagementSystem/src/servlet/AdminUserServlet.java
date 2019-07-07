package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.Admin;
import bean.Project;
import bean.Work;
import service.AdminService;
import service.UserService;
import service.serviceImp.AdminServiceImpl;
import service.serviceImp.UserServiceImpl;



/**
 *用户管理
 */
public class AdminUserServlet extends BaseServlet {
    
	//登入
	public String Login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Admin admin = new Admin();
		BeanUtils.populate(admin, request.getParameterMap());
		UserService userservice = new UserServiceImpl();
		Admin user = null;
		try {
			user = userservice.Login(admin);
			request.getSession().setAttribute("Admin", user);
			request.setAttribute("msg", user.getUsername());
			return "/admin/index.jsp";
		} catch (Exception e) {
			request.setAttribute("msg", "登入失败");
			return "/index.jsp";
		}
		
	}
   //用户退出
	public String adminOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	  //清除session
	  request.getSession().invalidate();
	  return "/index.jsp";
	} 
	
	//修改密码
    public String updatePass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Admin admin = (Admin) request.getSession().getAttribute("Admin");
		admin.setPassword(request.getParameter("password"));
		UserService userservice = new UserServiceImpl();
		String pass = request.getParameter("newpass");
		Admin user2 = null;
		try {
			user2 = userservice.Login(admin);;
			if(user2 != null) {
				user2.setPassword(pass);
				userservice.updatePass(user2);
				//清除session
				request.getSession().invalidate();
				request.setAttribute("msg", "修改密码成功，请重新登入");
				return "/index.jsp";
			}else {
				request.setAttribute("msg", "修改密码失败");
				return "/admin/info.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("msg", "修改密码失败");
			return "/admin/info.jsp";
		}
		
	}
   

}
