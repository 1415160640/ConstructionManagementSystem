package dao.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Admin;
import bean.Bad;
import bean.Buy;
import bean.Cate;
import bean.Project;
import bean.User;
import bean.Work;
import dao.AdminDao;
import utils.JDBCUtils;
import utils.TextUtils;
//管理dao层实现
public class AdminDaoImpl implements AdminDao {
    //查询所有工程
	@Override
	public List<Project> findProject() throws Exception {
		String sql="select * from project order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Project>(Project.class));
	}
    //更新项目状态
	@Override
	public void updateProject(Project pro) throws Exception {
		String sql="UPDATE project SET name=? ,start=? ,end= ?, money=?,state=? WHERE id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={pro.getName(),pro.getStart(),pro.getEnd(),pro.getMoney(),pro.getState(),pro.getId()};
		qr.update(sql,params);
	}
	//查询所有工程数量
	@Override
	public int ProjectCount() throws Exception {
		String sql="select count(*) from project ";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Long num=(Long)qr.query(sql, new ScalarHandler());
		return num.intValue();
	}
	//根据id查询工程
	@Override
	public Project findProjectById(String id) throws Exception {
		String sql="select * from project where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Project>(Project.class),id);
	}
	//添加工程
	@Override
	public void addProject(Project pro) throws Exception {
		String sql="insert into project SET name=? ,start=? ,end= ?, money=?,state=? ";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={pro.getName(),pro.getStart(),pro.getEnd(),pro.getMoney(),pro.getState()};
		qr.update(sql,params);
		
	}
	//模糊查询项目
	@Override
	public List<Project> SearProject(String date) throws Exception {
		String sql = "select * from project where start>?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Project>(Project.class),date);
	}
	//删除项目
	@Override
	public void deleteProject(String id) throws Exception {
		String sql="delete from project where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
	//查询使用项目
	@Override
	public List<Project> findProjectStart() throws Exception {
		String sql="select * from project where state=2 or state=3 order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Project>(Project.class));
	}
	//查询完成项目
	@Override
	public List<Project> findProjectEnd() throws Exception {
		String sql="select * from project where state=4 order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Project>(Project.class));
	}
	//查询未开始
	@Override
	public List<Project> findProjectNo() throws Exception {
		String sql="select * from project where state=1 order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Project>(Project.class));
	}
	//查找材料分类
	@Override
	public List<Cate> findCate() throws Exception {
		String sql="select * from cate  order by count desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Cate>(Cate.class));
	}
	//根据ID查询分类
	@Override
	public Cate findCateById(String id) throws Exception {
		String sql="select * from cate  where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Cate>(Cate.class),id);
	}
	//更新分类
	@Override
	public void updateCate(Cate cate) throws Exception {
		String sql="UPDATE cate SET name=?,count=? WHERE id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params= {cate.getName(),cate.getCount(),cate.getId()};
		qr.update(sql,params);
	}
	//添加材料分类
	@Override
	public void addCate(String name) throws Exception {
		String sql="insert into cate SET name=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,name);
	}
	//删除分类
	@Override
	public void deleteCate(String id) throws Exception {
		String sql="delete from cate where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
	//查询材料采购记录
	@Override
	public List<Buy> findBuy() throws Exception {
		String sql="select * from buy  order by date desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Buy>(Buy.class));
	}
	//添加采购记录
	@Override
	public void addBuy(Buy buy) throws Exception {
		String sql="insert into buy SET name=?,date=?,count=?,cid=?,money=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params= {buy.getName(),buy.getDate(),buy.getCount(),buy.getCid(),buy.getMoney()};
		qr.update(sql,params);
	}
	//删除采购记录
	@Override
	public void deleteBuy(String id) throws Exception {
		String sql="delete from buy where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
	//查询所有施工计划
	@Override
	public List<Work> findWork() throws Exception {
		String sql="select * from work order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Work> list = qr.query(sql, new BeanListHandler<Work>(Work.class));
		for(Work work : list) {
			String sql1="select * from user where id=?";
			User user = qr.query(sql1, new BeanHandler<User>(User.class),work.getUid());
			work.setUser(user);
		}
		return list;
	}
	//更新施工
	@Override
	public void updateWork(Work pro) throws Exception {
		String sql="UPDATE work SET name=? ,start=? ,end= ?, state=? WHERE id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={pro.getName(),pro.getStart(),pro.getEnd(),pro.getState(),pro.getId()};
		qr.update(sql,params);	
	}
	//根据id查询施工计划
	@Override
	public Work findWorkById(String id) throws Exception {
		String sql="select * from work where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Work work = qr.query(sql, new BeanHandler<Work>(Work.class),id);
	    String sql1="select * from user where id=?";
	    User user = qr.query(sql1, new BeanHandler<User>(User.class),work.getUid());
		work.setUser(user);
		return work;
	}
	//添加员工不良记录
	@Override
	public void saveBad(Bad bad) throws Exception {
		String sql="insert into bad SET type=?,date=?,uid=?,cid=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params= {bad.getType(),bad.getDate(),bad.getUid(),bad.getCid()};
		qr.update(sql,params);
	}
	//查询所有员工
	@Override
	public List<User> findUser() throws Exception {
		String sql="select * from user";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}
	//新增施工计划
	@Override
	public void addWork(Work work) throws Exception {
		String sql="insert into work SET name=? ,start=? ,end= ?,state=?,uid=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={work.getName(),work.getStart(),work.getEnd(),work.getState(),work.getUid()};
		qr.update(sql,params);
	}
	//删除施工计划
	@Override
	public void deleteWork(String id) throws Exception {
		String sql="delete from work where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
	//模糊查询施工计划
	@Override
	public List<Work> SearWork(String time) throws Exception {
		String sql = "select * from work where start>?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Work>(Work.class),time);
	}
	//查找正在施工
	@Override
	public List<Work> findWorkStart() throws Exception {
		String sql="select * from work where state=2 or state=3 order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Work> list = qr.query(sql, new BeanListHandler<Work>(Work.class));
		for(Work work : list) {
			String sql1="select * from user where id=?";
			User user = qr.query(sql1, new BeanHandler<User>(User.class),work.getUid());
			work.setUser(user);
		}
		return list;
	}
	//查找已完成施工
	@Override
	public List<Work> findWorkEnd() throws Exception {
		String sql="select * from work where state=4 order by end desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Work> list = qr.query(sql, new BeanListHandler<Work>(Work.class));
		for(Work work : list) {
			String sql1="select * from user where id=?";
			User user = qr.query(sql1, new BeanHandler<User>(User.class),work.getUid());
			work.setUser(user);
		}
		return list;
	}
	//施工延期记录
	@Override
	public List<Bad> findBadWork(int cid) throws Exception {
		String sql="select * from bad where cid=? order by date desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Bad> list = qr.query(sql, new BeanListHandler<Bad>(Bad.class),cid);
		for(Bad bad : list) {
			String sql1="select * from user where id=?";
			User user = qr.query(sql1, new BeanHandler<User>(User.class),bad.getUid());
			bad.setUser(user);
		}
		return list;
	}
	//删除施工延期记录
	@Override
	public void deleteBadWork(String id) throws Exception {
		String sql="delete from bad where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
	//根据名字查询员工
	@Override
	public User findUserByName(String name) throws Exception {
		String sql="select * from user where name=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<User>(User.class),name);
	}
	//根据员工id查询不良记录
	@Override
	public List<Bad> SearBadWork(String id) throws Exception {
		String sql="select * from bad where uid=? order by date desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Bad> list = qr.query(sql, new BeanListHandler<Bad>(Bad.class),id);
		for(Bad bad : list) {
			String sql1="select * from user where id=?";
			User user = qr.query(sql1, new BeanHandler<User>(User.class),bad.getUid());
			bad.setUser(user);
		}
		return list;
	}
	//添加用户
	@Override
	public void addUser(User user) throws Exception {
		String sql="insert into user SET name=?,date=?,pid=?,address=?,phone=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={user.getName(),user.getDate(),user.getPid(),user.getAddress(),user.getPhone()};
		qr.update(sql,params);
	}
	//删除用户
	@Override
	public void deleteUser(String id) throws Exception {
		String sql="delete from user where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
		
	}
	//编辑用户
	@Override
	public User findUsertById(String id) throws Exception {
		String sql="select * from user where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<User>(User.class),id);
	}
	//更新用户
	@Override
	public void updateUser(User pro) throws Exception {
		String sql="UPDATE user SET name=?,date=?,pid=?,address=?,phone=?,time=? where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={pro.getName(),pro.getDate(),pro.getPid(),pro.getAddress(),pro.getPhone(),pro.getTime(),pro.getId()};
		qr.update(sql,params);
	}
	//删除用户预支表数据
	@Override
	public void deleteBorrow(String id) throws Exception {
		String sql="delete from borrow where uid=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
}
