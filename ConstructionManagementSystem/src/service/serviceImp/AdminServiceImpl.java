package service.serviceImp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import bean.Bad;
import bean.Buy;
import bean.Cate;
import bean.Project;
import bean.User;
import bean.Work;
import dao.UserDao;
import service.AdminService;
import utils.BeanFactory;
import dao.AdminDao;
//管理业务层实现类
public class AdminServiceImpl implements AdminService {
	AdminDao AdminDao=(AdminDao)BeanFactory.createObject("AdminDao");
	//查询所有分类
	@Override
	public List<Project> findProject() throws Exception {
		List<Project> list = AdminDao.findProject();
		Date date = new Date(System.currentTimeMillis());
		for(Project pro : list) {
			if(pro.getStart().before(date) && pro.getState() == 1) {
				pro.setState(2);
				AdminDao.updateProject(pro);
			}
			if(pro.getEnd().before(date) && pro.getState() == 2) {
				pro.setState(3);
				AdminDao.updateProject(pro);
			}
		}
		return list;
	}
	//查询工程数量
	@Override
	public int ProjectCount() throws Exception {
		return AdminDao.ProjectCount();
	}
	//根据id查询工程
	@Override
	public Project findProjectById(String id) throws Exception {
		return AdminDao.findProjectById(id);
	}
	//更新工程信息
	@Override
	public void updateProject(Project pro1) throws Exception {
		AdminDao.updateProject(pro1);
	}
    //添加项目
	@Override
	public void addProject(Project pro) throws Exception {
		AdminDao.addProject(pro);
		
	}
	//模糊查询项目
	@Override
	public List<Project> SearProject(String date) throws Exception {
		return AdminDao.SearProject(date);
	}
	//删除项目
	@Override
	public void deleteProject(String id) throws Exception {
		AdminDao.deleteProject(id);
		
	}
	//查询施工项目
	@Override
	public List<Project> findProjectStart() throws Exception {
		return AdminDao.findProjectStart();
	}
	//查询完成项目
	@Override
	public List<Project> findProjectEnd() throws Exception {
		return AdminDao.findProjectEnd();
	}
	//查询未开始项目
	@Override
	public List<Project> findProjectNo() throws Exception {
		return AdminDao.findProjectNo();
	}
	//查找分类
	@Override
	public List<Cate> findCate() throws Exception {
		return AdminDao.findCate();
	}
    //根据id查询分类
	@Override
	public Cate findCateById(String id) throws Exception {
		return AdminDao.findCateById(id);
	}
	//保存分类信息
	@Override
	public void updateCate(Cate cate) throws Exception {
		AdminDao.updateCate(cate);
	}
	//添加材料分类
	@Override
	public void addCate(String name) throws Exception {
		AdminDao.addCate(name);	
	}
	//删除分类
	@Override
	public void deleteCate(String id) throws Exception {
		AdminDao.deleteCate(id);	
	}
	//查找所有采购记录
	@Override
	public List<Buy> findBuy() throws Exception {
		return AdminDao.findBuy();
	}
	//添加采购记录
	@Override
	public void addBuy(Buy buy) throws Exception {
		AdminDao.addBuy(buy);
		
	}
	//删除订单
	@Override
	public void deleteBuy(String id) throws Exception {
		AdminDao.deleteBuy(id);	
		
	}
	//查询所有施工计划
	@Override
	public List<Work> findWork() throws Exception {
		List<Work> list = AdminDao.findWork();
		Date date = new Date(System.currentTimeMillis());
		for(Work pro : list) {
			if(pro.getStart().before(date) && pro.getState() == 1) {
				pro.setState(2);
				AdminDao.updateWork(pro);
			}
			if(pro.getEnd().before(date) && pro.getState() == 2) {
				pro.setState(3);
				AdminDao.updateWork(pro);
			}
		}
		return list;
	}
	//根据id查询施工计划
	@Override
	public Work findWorkById(String id) throws Exception {
		return AdminDao.findWorkById(id);
	}
	//添加员工不良记录
	@Override
	public void saveBad(Bad bad) throws Exception {
		AdminDao.saveBad(bad);
	}
	//更新施工计划
	@Override
	public void updateWork(Work work) throws Exception {
		AdminDao.updateWork(work);
	}
	//查询所有员工
	@Override
	public List<User> findUser() throws Exception {
		return AdminDao.findUser();
	}
	//增加施工计划
	@Override
	public void addWork(Work work) throws Exception {
		AdminDao.addWork(work);
	}
	//删除施工计划
	@Override
	public void deleteWork(String id) throws Exception {
		AdminDao.deleteWork(id);
	}
	//查询施工计划
	@Override
	public List<Work> SearWork(String time) throws Exception {
		return AdminDao.SearWork(time);
	}
	//查找正在施工
	@Override
	public List<Work> findWorkStart() throws Exception {
		return AdminDao.findWorkStart();
	}
	//查找已完成施工
	@Override
	public List<Work> findWorkEnd() throws Exception {
		return AdminDao.findWorkEnd();
	}
	//施工延期记录
	@Override
	public List<Bad> findBadWork(int cid) throws Exception {
		return AdminDao.findBadWork(cid);
	}
	//删除施工延期记录
	@Override
	public void deleteBadWork(String id) throws Exception {
		AdminDao.deleteBadWork(id);
		
	}
	//根据名字查询员工
	@Override
	public User findUserByName(String name) throws Exception {
		return AdminDao.findUserByName(name);
	}
	//根据员工id查询不良记录
	@Override
	public List<Bad> SearBadWork(String id) throws Exception {
		return AdminDao.SearBadWork(id);
	}
	//添加用户
	@Override
	public void addUser(User user) throws Exception {
		AdminDao.addUser(user);	
	}
	//删除用户
	@Override
	public void deleteUser(String id) throws Exception {
		AdminDao.deleteUser(id);
	}
	//根据id查找用户
	@Override
	public User findUsertById(String id) throws Exception {
		return AdminDao.findUsertById(id);
	}
	//更新用户
	@Override
	public void updateUser(User pro) throws Exception {
		AdminDao.updateUser(pro);
	}
	//删除预支表用户数据
	@Override
	public void deleteBorrow(String id) throws Exception {
		AdminDao.deleteBorrow(id);
	}

}
