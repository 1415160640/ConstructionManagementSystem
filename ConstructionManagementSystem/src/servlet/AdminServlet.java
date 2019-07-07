package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;

import bean.Bad;
import bean.Borrow;
import bean.Buy;
import bean.Cate;
import bean.Money;
import bean.Project;
import bean.User;
import bean.Work;
import service.AdminMoneyService;
import service.AdminService;
import service.serviceImp.AdminMoneyServiceImpl;
import service.serviceImp.AdminServiceImpl;
import utils.MyBeanUtils;

/**
管理servlet
**/
public class AdminServlet extends BaseServlet {
	//初始化界面
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService admin1 = new AdminServiceImpl();
		List<Project> pro = admin1.findProject();
		pro = admin1.findProjectStart();
		List<Work> work = admin1.findWork();
		work = admin1.findWorkStart();
		request.setAttribute("pro", pro);
		request.setAttribute("work", work);
		return "/admin/home.jsp";
	}
	
	//查找所有工程
	public String findProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService admin = new AdminServiceImpl();
		List<Project> pro = admin.findProject();
		int count = admin.ProjectCount();
		request.setAttribute("count",count);
		request.setAttribute("pro", pro);
		return "/admin/project_list.jsp";	
	}
    //更新状态
	public void UpdateProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService admin = new AdminServiceImpl();
		String id=request.getParameter("id");
		Project pro1 = admin.findProjectById(id);
	    pro1.setState(4);
	    admin.updateProject(pro1);
	    Money mon = new Money();
	    mon.setCid(1);
	    mon.setName("工程收入："+pro1.getName());
	    mon.setDate(new Date());
	    mon.setMoney(pro1.getMoney());
	    AdminMoneyService adminmon = new AdminMoneyServiceImpl();
	    adminmon.saveMoney(mon);
	    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findProject");	
	}
	//添加项目
	public void addProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
			AdminService admin = new AdminServiceImpl();
			Project pro = new Project();
			MyBeanUtils.populate(pro, request.getParameterMap());
		    pro.setState(1);
		    admin.addProject(pro);
		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findProject");	
	}
	//查询项目
    public String SearProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
				AdminService admin = new AdminServiceImpl();
				String time = request.getParameter("date");
				List<Project> pro = admin.SearProject(time);
				request.setAttribute("pro", pro);
			    return "/admin/project_list.jsp";	
	 }
    //跳转到编辑项目界面
    public String editProjectUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	        AdminService admin = new AdminServiceImpl();
		        String id=request.getParameter("id");
		        Project pro1 = admin.findProjectById(id);
				request.setAttribute("pro", pro1);
			    return "/admin/project_edit.jsp";	
	 }
    //编辑项目
  	public void eidtProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
  			AdminService admin = new AdminServiceImpl();
  			Project pro = new Project();
  			MyBeanUtils.populate(pro, request.getParameterMap());
  		    admin.updateProject(pro);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findProject");	
  	}
    //删除项目
  	public void deleteProject(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteProject(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findProject");	
  	}
  	//查找未开始项目
  	public String findProjectNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Project> pro = admin.findProjectNo();
  		request.setAttribute("pro", pro);
  		return "/admin/project_list.jsp";	
  	}
   //查找施工项目
  	public String findProjectStart(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Project> pro = admin.findProjectStart();
  		request.setAttribute("pro", pro);
  		return "/admin/project_list.jsp";	
  	}
    //查找完成项目
  	public String findProjectEnd(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Project> pro = admin.findProjectEnd();
  		request.setAttribute("pro", pro);
  		return "/admin/project_list.jsp";	
  	}
    //查找分类
  	public String findCate(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Cate> cate = admin.findCate();
  		request.setAttribute("cate", cate);
  		return "/admin/cate_list.jsp";	
  	}
    //出库材料数量
  	public void addCateNum(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		double a=Double.parseDouble(request.getParameter("num"));
  		String id=request.getParameter("id");
  		AdminService admin = new AdminServiceImpl();
  		Cate cate = admin.findCateById(id);
        cate.setCount(cate.getCount()-a);
        admin.updateCate(cate);
  		response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findCate");		
  	}
  	//添加分类
  	public void addCate(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		String name=request.getParameter("name");
  		AdminService admin = new AdminServiceImpl();
        admin.addCate(name);
  		response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findCate");		
  	}
  	//删除分类
  	public void deleteCate(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteCate(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findCate");	
  	}
    //查找材料采购记录
  	public String findBuy(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Buy> buy = admin.findBuy();
  		request.setAttribute("buy", buy);
  		return "/admin/buy_list.jsp";	
  	}
  	//跳转到增加采购记录界面
  	public String addBuyUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Cate> cate = admin.findCate();
  		request.setAttribute("cate", cate);
  		return "/admin/buy_add.jsp";	
  	}
    //添加采购记录
  	public void addBuy(HttpServletRequest request, HttpServletResponse response) throws Exception {
  			AdminService admin = new AdminServiceImpl();
  			Buy buy = new Buy();
  			ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
  			MyBeanUtils.populate(buy, request.getParameterMap());
  			String id=request.getParameter("cid");
  	  		Cate cate = admin.findCateById(id);
  	  		
  	  	    cate.setCount(cate.getCount()+buy.getCount());
            admin.updateCate(cate);
            
  	  		buy.setName(cate.getName());
  		    admin.addBuy(buy);
  		    
  		    Money mon = new Money();
  	        mon.setCid(2);
  	        mon.setName("采购支出："+cate.getName());
  	        mon.setDate(new Date());
  	        mon.setMoney(buy.getMoney());
  	        AdminMoneyService adminmon = new AdminMoneyServiceImpl();
  	        adminmon.saveMoney(mon);
  	        
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findBuy");	
  	}
    //删除分类
  	public void deleteBuy(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteBuy(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findBuy");	
  	}
    //查找所有施工
  	public String findWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Work> work = admin.findWork();
  		request.setAttribute("work", work);
  		return "/admin/work_list.jsp";	
  	 }
    //更新状态
  	public void UpdateWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		String id=request.getParameter("id");
  		Work work = admin.findWorkById(id);
  		if(work.getState() == 3) {
  			Bad bad = new Bad();
  	  	    bad.setUid(work.getUid());
  	  	    bad.setCid(1);
  	  	    bad.setDate(new Date());
  	  	    bad.setType("施工延期:"+work.getName());;
  	  	    admin.saveBad(bad); 
  		}
  		work.setState(4);
  	    admin.updateWork(work);
  	    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findWork");	
  	}
    //跳转到增加施工界面
  	public String addWorkUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<User> users = admin.findUser();
  		request.setAttribute("user", users);
  		return "/admin/work_add.jsp";	
  	}
    //添加施工计划
  	public void addWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
  			AdminService admin = new AdminServiceImpl();
  			Work work = new Work();
  			ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
  			MyBeanUtils.populate(work, request.getParameterMap());
            work.setState(1);
  		    admin.addWork(work);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findWork");	
  	}
   //删除施工计划
  	public void deleteWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteWork(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findWork");	
  	}
    //查询施工计划
    public String SearWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
				AdminService admin = new AdminServiceImpl();
				String time = request.getParameter("date");
				List<Work> work = admin.SearWork(time);
				request.setAttribute("work", work);
			    return "/admin/work_list.jsp";	
	 }
    //查找正在施工
  	public String findWorkStart(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Work> pro = admin.findWorkStart();
  		request.setAttribute("work", pro);
  		return "/admin/work_list.jsp";	
  	}
    //查找已完成施工
  	public String findWorkEnd(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Work> pro = admin.findWorkEnd();
  		request.setAttribute("work", pro);
  		return "/admin/work_list.jsp";	
  	}
  	//施工延期记录
  	public String findBadWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Bad> bad = admin.findBadWork(1);
  		request.setAttribute("bad", bad);
  		return "/admin/bad_list.jsp";	
  	}
    //删除施工延期记录
  	public void deleteBadWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteBadWork(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findBadWork");	
  	}
    //查询施工计划
    public String SearBadWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
				AdminService admin = new AdminServiceImpl();
				String name = request.getParameter("name");
				User user = admin.findUserByName(name);
				List<Bad> bad = admin.SearBadWork(user.getId());
				request.setAttribute("bad", bad);
				return "/admin/bad_list.jsp";	
	 }
    //查找所有员工
  	public String findUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<User> users = admin.findUser();
  		request.setAttribute("user", users);
  		return "/admin/user_list.jsp";	
  	}
    //员工办理离职
  	public String findOutUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<User> users = admin.findUser();
  		request.setAttribute("user", users);
  		return "/admin/out_list.jsp";	
  	}
    //添加用户
  	public void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		User user = new User();
  		MyBeanUtils.populate(user, request.getParameterMap());
        admin.addUser(user);
        User user1 = admin.findUserByName(user.getName());
        Borrow bo = new Borrow();
        bo.setUid(user1.getId());
        bo.setMoney(0);
        AdminMoneyService admin1 = new AdminMoneyServiceImpl();
        admin1.saveBorrow(bo);
  		response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findUser");		
  	}
	//注销用户
  	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteUser(id);
  		    admin.deleteBorrow(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findOutUser");	
  	}
    //编辑用户界面
    public String editUserUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	        AdminService admin = new AdminServiceImpl();
		        String id=request.getParameter("id");
		        User user = admin.findUsertById(id);
				request.setAttribute("user", user);
			    return "/admin/user_edit.jsp";	
	 }
    //编辑用户
  	public void editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
  			AdminService admin = new AdminServiceImpl();
  			User pro = new User();
  			MyBeanUtils.populate(pro, request.getParameterMap());
  		    admin.updateUser(pro);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findUser");	
  	}
  	//查找员工工时
  	public String findWorkDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<User> users = admin.findUser();
  		request.setAttribute("user", users);
  		return "/admin/workdate_list.jsp";	
  	}
  	//添加员工工时
  	public void addWorkDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		double a=Double.parseDouble(request.getParameter("num"));
  		String id=request.getParameter("id");
  		AdminService admin = new AdminServiceImpl();
  		User user = admin.findUsertById(id);
        user.setTime(user.getTime()+a);
        admin.updateUser(user);;
  		response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findWorkDate");		
  	}
   //编辑用户工时界面
    public String editWorkDateUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	        AdminService admin = new AdminServiceImpl();
		        String id=request.getParameter("id");
		        User user = admin.findUsertById(id);
				request.setAttribute("user", user);
			    return "/admin/workdate_edit.jsp";	
	 }
   //编辑用户工时
  	public void editWorkDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
  			AdminService admin = new AdminServiceImpl();
  			User pro = new User();
  			MyBeanUtils.populate(pro, request.getParameterMap());
  		    admin.updateUser(pro);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findWorkDate");	
  	}
    //施工延期记录
  	public String findBadTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		List<Bad> bad = admin.findBadWork(2);
  		request.setAttribute("bad", bad);
  		return "/admin/bad_list.jsp";	
  	}
    //添加员工不良记录
  	public void addBad(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminService admin = new AdminServiceImpl();
  		Bad Bad = new Bad();
  		MyBeanUtils.populate(Bad, request.getParameterMap());
  		String name=request.getParameter("name").trim();
  		User user = admin.findUserByName(name);
  		Bad.setUid(user.getId());
  		admin.saveBad(Bad); 
  		response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findBadTime");		
  	}
    //删除施工延期记录
  	public void deleteBadTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminService admin = new AdminServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteBadWork(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminServlet?method=findBadTime");	
  	}
  	

}
