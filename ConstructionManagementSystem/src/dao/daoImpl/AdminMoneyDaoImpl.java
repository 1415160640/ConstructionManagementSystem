package dao.daoImpl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Borrow;
import bean.Money;
import bean.Project;
import bean.Spring;
import bean.Time;
import bean.User;
import bean.Wages;
import dao.AdminDao;
import dao.AdminMoneyDao;
import utils.BeanFactory;
import utils.JDBCUtils;
//财务管理dao层实现
public class AdminMoneyDaoImpl implements AdminMoneyDao {
    //保存账单
	@Override
	public void saveMoney(Money mon) throws Exception {
		String sql="insert into money SET money=? ,date=? ,cid=?,name=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={mon.getMoney(),mon.getDate(),mon.getCid(),mon.getName()};
		qr.update(sql,params);	
	}
	//查询项目收入
	@Override
	public List<Money> findMoney(int i) throws Exception {
		String sql="select * from money where cid=? order by date desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Money>(Money.class),i);
	}
	//删除账单
	@Override
	public void deleteMoney(String id) throws Exception {
		String sql="delete from money where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
	}
	//查询账单
	@Override
	public List<Money> SearMoney(int a) throws Exception {
		String sql="select * from money where cid=? and DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(date) order by date desc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Money>(Money.class),a);
	}
	//查询奖励列表
	@Override
	public List<Spring> findSpring() throws Exception {
		String sql="select * from spring  order by id asc";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Spring>(Spring.class));
	}
	//通过id查询奖励
	@Override
	public Spring findSpringById(String id) throws Exception {
		String sql="select * from spring  where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Spring>(Spring.class),id);
	}
	//更新奖励
	@Override
	public void updateSpring(Spring spring) throws Exception {
		String sql="UPDATE spring SET name=? ,num=? ,apart= ? WHERE id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={spring.getName(),spring.getNum(),spring.getApart(),spring.getId()};
		qr.update(sql,params);	
	}
	//增加奖励内容
	@Override
	public void saveSpring(Spring spring) throws Exception {
		String sql="insert into spring SET name=? ,num=? ,apart= ?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={spring.getName(),spring.getNum(),spring.getApart()};
		qr.update(sql,params);	
	}
	//删除奖励内容
	@Override
	public void deleteSpring(String id) throws Exception {
		String sql="delete from spring where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,id); 
		
	}
	//员工预支列表
	@Override
	public List<Borrow> findBorrow() throws Exception {
		String sql="select * from borrow";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Borrow> list = qr.query(sql, new BeanListHandler<Borrow>(Borrow.class));
		for(Borrow bo : list){
			String sql1="select * from user where id=?";
			User user = qr.query(sql1, new BeanHandler<User>(User.class),bo.getUid());
			bo.setUser(user); 
		}
		return list;
	}
	//创建借钱账户
	@Override
	public void saveBorrow(Borrow bo) throws Exception {
		String sql="insert into borrow SET uid=? ,money=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={bo.getUid(),bo.getMoney()};
		qr.update(sql,params);	
	}
	//通过id查询预支记录
	@Override
	public Borrow findBorrowById(String id) throws Exception {
		String sql="select * from borrow  where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Borrow>(Borrow.class),id);
	}
	//更新预支记录
	@Override
	public void updateBorrow(Borrow borrow) throws Exception {
		String sql="UPDATE borrow SET uid=? ,money=? WHERE id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={borrow.getUid(),borrow.getMoney(),borrow.getId()};
		qr.update(sql,params);	
	}
	//员工工资表
	@Override
	public List<Wages> findWorkMoney() throws Exception {
		String sql="select * from user";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		List<Wages> list = qr.query(sql, new BeanListHandler<Wages>(Wages.class));
		for(Wages bo : list){
			String sql1="select count(*) from bad where uid=? and cid=1 and DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(date)";
			Long num1=(Long)qr.query(sql1, new ScalarHandler(),bo.getId());
			bo.setBadwork(num1.intValue());
			String sql2="select count(*) from bad where uid=? and cid=2 and DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(date)";
			Long num2=(Long)qr.query(sql2, new ScalarHandler(),bo.getId());
			bo.setBaddate(num2.intValue());
			String sql3="select * from borrow  where uid=?";
			bo.setBorrow(qr.query(sql3, new BeanHandler<Borrow>(Borrow.class),bo.getId()));	
		}
		return list;
	}
	//查询时间设置列表
	@Override
	public List<Time> findTime() throws Exception {
		String sql="select * from time";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Time>(Time.class));
	}
	//根据id查询时间设定项
	@Override
	public Time findTimeById(String id) throws Exception {
		String sql="select * from time  where id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Time>(Time.class),id);
	}
	//更新时间设定项
	@Override
	public void updateTime(Time time) throws Exception {
		String sql="UPDATE time SET name=? ,num=?  WHERE id=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		Object[] params={time.getName(),time.getNum(),time.getId()};
		qr.update(sql,params);	
	}

}
