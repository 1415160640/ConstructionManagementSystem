package service.serviceImp;

import bean.Admin;
import dao.UserDao;
import service.UserService;
import utils.BeanFactory;
//用户管理实现
public class UserServiceImpl implements UserService {
	UserDao userdao=(UserDao)BeanFactory.createObject("UserDao");
	 //登入
	@Override
	public Admin Login(Admin admin) throws Exception {
		Admin user = userdao.userLogin(admin);
		if(user != null) {
			return user;
		}
		return null;
	}
	//更新密码
	@Override
	public void updatePass(Admin user2) throws Exception {
		userdao.updatePass(user2);
	}

}
