package service;

import bean.Admin;

//用户管理业务层接口
public interface UserService {

	Admin Login(Admin admin) throws Exception;

	void updatePass(Admin user2) throws Exception;

}
