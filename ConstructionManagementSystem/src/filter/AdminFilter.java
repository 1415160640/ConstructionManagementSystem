package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import bean.Admin;



/**
 *  管理端权限过滤
 */
public class AdminFilter implements Filter {

	 public AdminFilter() {
	     
	    }

		public void destroy() {
		}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest myReq=(HttpServletRequest)request;
			//判断当前的session中是否存在已经登录成功的用户
			Admin user=(Admin)myReq.getSession().getAttribute("Admin");
			if(null!=user){
				//如果存在,放行
				chain.doFilter(request, response);
			}else{
				//如果不存在,转入到提示页面
				myReq.setAttribute("msg", "请先登录");
				//转入到提示页面
				myReq.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}

		/**
		 * @see Filter#init(FilterConfig)
		 */
		public void init(FilterConfig fConfig) throws ServletException {
			// TODO Auto-generated method stub
		}
}
