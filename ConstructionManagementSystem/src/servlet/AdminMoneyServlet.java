package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bad;
import bean.Borrow;
import bean.Cate;
import bean.Money;
import bean.Project;
import bean.Spring;
import bean.Time;
import bean.User;
import bean.Wages;
import service.AdminMoneyService;
import service.AdminService;
import service.serviceImp.AdminMoneyServiceImpl;
import service.serviceImp.AdminServiceImpl;
import utils.MyBeanUtils;

/**
 * 财务管理servlet
 */
public class AdminMoneyServlet extends BaseServlet {
	//查询项目收入
  	public String findMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		int a=Integer.parseInt(request.getParameter("num"));
  		List<Money> money = admin.findMoney(a);
  		double count=0;
  		for(Money mon: money) {
  			count+=mon.getMoney();
  		}
  		request.setAttribute("cid", a);
  		request.setAttribute("count", count);
  		request.setAttribute("money", money);
  		return "/admin/money_list.jsp";	
  	}
  	 //删除账单
  	public void deleteMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminMoneyService admin = new AdminMoneyServiceImpl();
            String id=request.getParameter("id");
            int a=Integer.parseInt(request.getParameter("cid"));
  		    admin.deleteMoney(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findMoney&num="+a);	
  	}
    //查询账单
    public String SearMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
				AdminMoneyService admin = new AdminMoneyServiceImpl();
				int a=Integer.parseInt(request.getParameter("cid"));
				List<Money> money = admin.SearMoney(a);
				double count=0;
		  		for(Money mon: money) {
		  			count+=mon.getMoney();
		  		}
		  		request.setAttribute("cid", a);
		  		request.setAttribute("count", count);
				request.setAttribute("money", money);
			    return "/admin/money_list.jsp";	
	 }
    //增加其他支出
    public void addMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
				AdminMoneyService admin = new AdminMoneyServiceImpl();
				Money money = new Money();
				MyBeanUtils.populate(money, request.getParameterMap());
		  	    admin.saveMoney(money);
				response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findMoney&num="+4);	
	 }
    //查询奖励列表
  	public String findSpring(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		List<Spring> spring = admin.findSpring();
  		request.setAttribute("spring", spring);
  		return "/admin/spring_list.jsp";	
  	}
    //修改奖励数值
  	public void addSpringNum(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		double a=Double.parseDouble(request.getParameter("num"));
  		String id=request.getParameter("id");
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		Spring spring = admin.findSpringById(id);
  		spring.setNum(a);
        admin.updateSpring(spring);
  		response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findSpring");		
  	}
     //增加奖励内容
    public void addSpring(HttpServletRequest request, HttpServletResponse response) throws Exception {
				AdminMoneyService admin = new AdminMoneyServiceImpl();
				Spring spring = new Spring();
				MyBeanUtils.populate(spring, request.getParameterMap());
				spring.setApart("元/天");
		  	    admin.saveSpring(spring);
				response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findSpring");	
	 }
    //删除奖励内容
  	public void deleteSpring(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		    AdminMoneyService admin = new AdminMoneyServiceImpl();
            String id=request.getParameter("id");
  		    admin.deleteSpring(id);
  		    response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findSpring");	
  	}
  	//员工预支列表
  	public String findBorrow(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		List<Borrow> borrow = admin.findBorrow();
  		List<Spring> spring = admin.findSpring();
  		for(Borrow bo : borrow) {
  			    bo.setMax(bo.getUser().getTime()*spring.get(0).getNum()*spring.get(1).getNum()/100);
  		}
  		request.setAttribute("borrow", borrow);
  		return "/admin/borrow_list.jsp";	
  	}
    //员工预支工资
  	public void addBorrowNum(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		double a=Double.parseDouble(request.getParameter("num"));
  		String id=request.getParameter("id");
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		Borrow borrow = admin.findBorrowById(id);
  		borrow.setMoney(borrow.getMoney()+a);
        admin.updateBorrow(borrow);
  		response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findBorrow");		
  	}
    //员工工资表
  	public String findWorkMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		List<Wages> wages = admin.findWorkMoney();
  		List<Spring> spring = admin.findSpring();
  		List<Time> time = admin.findTime();
  		for(Wages bo : wages) {
  			    //工时工资
  			    bo.setWorkdatemoney(bo.getTime()*spring.get(0).getNum());
  			    //无延时奖励
  			    if(bo.getBadwork()<time.get(2).getNum() && bo.getTime()>=time.get(0).getNum()) {
  			    	 bo.setBadworkmoney(spring.get(2).getNum());
  			    }
  			    //全勤奖励
  			    if(bo.getBaddate()<time.get(2).getNum() && bo.getTime()>=time.get(0).getNum()) {
			    	 bo.setBaddatemoney(spring.get(3).getNum());
			    }
  			    //其他奖励
  			    for(int i = 4;i<spring.size();i++) {
  			    	bo.setOthermoney(bo.getOthermoney()+(((int)(bo.getTime()/time.get(1).getNum()))*spring.get(i).getNum()));
  			    }
  			    //总工资
  			    bo.setCount(bo.getWorkdatemoney()+bo.getBaddatemoney()+bo.getBadworkmoney()+bo.getOthermoney()-bo.getBorrow().getMoney());  
  		}
  		request.setAttribute("time", time);
  		request.setAttribute("wages", wages);
  		return "/admin/wages_list.jsp";	
  	}
  	//员工预支工资
  	public void endMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		double a=Double.parseDouble(request.getParameter("count"));
  		String bid=request.getParameter("bid");
  		String id=request.getParameter("id");
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		//清空用户预支数据
  		Borrow borrow = admin.findBorrowById(bid);
  		borrow.setMoney(0);System.out.println(borrow);
  		admin.updateBorrow(borrow);
  		//更新用户工时
  		AdminService admin1 = new AdminServiceImpl();
  		User user = admin1.findUsertById(id);
  		user.setTime(0);System.out.println(user);	
  		admin1.updateUser(user);
         //记账
        Money mon = new Money();
	    mon.setCid(3);
	    mon.setName(user.getName()+"：工资支出");
	    mon.setDate(new Date());
	    mon.setMoney(a);
	    admin.saveMoney(mon);
    	
  		response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findWorkMoney");		
  	 }
      //查询时间设置列表
  	 public String findTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
  		AdminMoneyService admin = new AdminMoneyServiceImpl();
  		List<Time> time = admin.findTime();
  		request.setAttribute("time", time);
  		return "/admin/time_list.jsp";	
  	 }
  	 //修改奖励数值
   	 public void updateTimeNum(HttpServletRequest request, HttpServletResponse response) throws Exception {
   		double a=Double.parseDouble(request.getParameter("num"));
   		String id=request.getParameter("id");
   		AdminMoneyService admin = new AdminMoneyServiceImpl();
   		Time time = admin.findTimeById(id);
   		time.setNum(a);
        admin.updateTime(time);
   		response.sendRedirect("/ConstructionManagementSystem/AdminMoneyServlet?method=findTime");		
   	}
     //查询月账单
     public String findAllMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
 				AdminMoneyService admin = new AdminMoneyServiceImpl();
 				List<Money> money1 = admin.SearMoney(1);
 				List<Money> money2 = admin.SearMoney(2);
 				List<Money> money3= admin.SearMoney(3);
 				List<Money> money4 = admin.SearMoney(4);
 				double count=0,count1=0,count2=0,count3=0,count4=0;
 		  		for(Money mon: money1) {
 		  			count1+=mon.getMoney();
 		  		}
 		  		for(Money mon: money2) {
 		  			count2+=mon.getMoney();
 		  		}
 		  		for(Money mon: money3) {
 		  			count3+=mon.getMoney();
 		  		}
 		  		for(Money mon: money4) {
 		  			count4+=mon.getMoney();
 		  		}
 		  		count=count1-count2+count3+count4;
 		  		request.setAttribute("count", count);
 		  		request.setAttribute("count1", count1);
 		  		request.setAttribute("count2", count2);
 		  		request.setAttribute("count3", count3);
 		  		request.setAttribute("count4", count4);
 				request.setAttribute("money1", money1);
 				request.setAttribute("money2", money2);
 				request.setAttribute("money3", money3);
 				request.setAttribute("money4", money4);
 			    return "/admin/Allmoney_list.jsp";	
 	 }

}
