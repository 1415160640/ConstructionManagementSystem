package service;

import java.util.List;

import bean.Borrow;
import bean.Money;
import bean.Spring;
import bean.Time;
import bean.Wages;
//财务管理业务层接口
public interface AdminMoneyService {

	void saveMoney(Money mon) throws Exception;

	List<Money> findMoney(int i) throws Exception;

	void deleteMoney(String id) throws Exception;

	List<Money> SearMoney(int a)throws Exception;

	List<Spring> findSpring() throws Exception;

	Spring findSpringById(String id) throws Exception;

	void updateSpring(Spring spring) throws Exception;

	void saveSpring(Spring spring) throws Exception;

	void deleteSpring(String id) throws Exception;

	List<Borrow> findBorrow() throws Exception;

	void saveBorrow(Borrow bo) throws Exception;

	Borrow findBorrowById(String id) throws Exception;

	void updateBorrow(Borrow borrow) throws Exception;

	List<Wages> findWorkMoney() throws Exception;

	List<Time> findTime() throws Exception;

	Time findTimeById(String id) throws Exception;

	void updateTime(Time time) throws Exception;

}
