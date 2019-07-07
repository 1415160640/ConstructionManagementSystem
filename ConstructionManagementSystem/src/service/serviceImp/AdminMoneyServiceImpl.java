package service.serviceImp;

import java.util.List;

import bean.Borrow;
import bean.Money;
import bean.Spring;
import bean.Time;
import bean.Wages;
import dao.AdminDao;
import service.AdminMoneyService;
import utils.BeanFactory;
import dao.AdminMoneyDao;
//财务管理业务层实现
public class AdminMoneyServiceImpl implements AdminMoneyService {
	AdminMoneyDao AdminMoneyDao=(AdminMoneyDao)BeanFactory.createObject("AdminMoneyDao");
	//保存账单
	@Override
	public void saveMoney(Money mon) throws Exception {
		AdminMoneyDao.saveMoney(mon);
	}
	//查询项目收入
	@Override
	public List<Money> findMoney(int i) throws Exception {
		return AdminMoneyDao.findMoney(i);
	}
	//删除账单
	@Override
	public void deleteMoney(String id) throws Exception {
		AdminMoneyDao.deleteMoney(id);
		
	}
	//查询账单
	@Override
	public List<Money> SearMoney(int a) throws Exception {
		return AdminMoneyDao.SearMoney(a);
	}
	//查询奖励列表
	@Override
	public List<Spring> findSpring() throws Exception {
		return AdminMoneyDao.findSpring();
	}
	//通过id查询奖励
	@Override
	public Spring findSpringById(String id) throws Exception {
		return AdminMoneyDao.findSpringById(id);
	}
	//更新奖励
	@Override
	public void updateSpring(Spring spring) throws Exception {
		AdminMoneyDao.updateSpring(spring);
	}
	//增加奖励内容
	@Override
	public void saveSpring(Spring spring) throws Exception {
		AdminMoneyDao.saveSpring(spring);
	}
	//删除奖励内容
	@Override
	public void deleteSpring(String id) throws Exception {
		AdminMoneyDao.deleteSpring(id);
	}
	//员工预支列表
	@Override
	public List<Borrow> findBorrow() throws Exception {
		return AdminMoneyDao.findBorrow();
	}
	//创建借钱账户
	@Override
	public void saveBorrow(Borrow bo) throws Exception {
		AdminMoneyDao.saveBorrow( bo);
	}
	//通过id查询预支记录
	@Override
	public Borrow findBorrowById(String id) throws Exception {
		return AdminMoneyDao.findBorrowById(id);
	}
	//更新预支记录
	@Override
	public void updateBorrow(Borrow borrow) throws Exception {
		AdminMoneyDao.updateBorrow(borrow);
	}
	//员工工资表
	@Override
	public List<Wages> findWorkMoney() throws Exception {
		return AdminMoneyDao.findWorkMoney();
	}
	//查询时间设置列表
	@Override
	public List<Time> findTime() throws Exception {
		return AdminMoneyDao.findTime();
	}
	//根据id查询时间设定项
	@Override
	public Time findTimeById(String id) throws Exception {
		return AdminMoneyDao.findTimeById(id);
	}
	//更新时间设定项
	@Override
	public void updateTime(Time time) throws Exception {
		AdminMoneyDao.updateTime(time);
	}

}
