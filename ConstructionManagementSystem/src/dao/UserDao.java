package dao;

import bean.Admin;

//用户dao接口
public interface UserDao {

	Admin userLogin(Admin admin) throws Exception;

	void updatePass(Admin user2) throws Exception;

}
