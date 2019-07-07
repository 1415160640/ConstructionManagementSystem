package dao.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.Admin;
import dao.UserDao;
import utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
   //管理员登入
	@Override
	public Admin userLogin(Admin admin) throws Exception {
		String sql="select * from admin where username=?  and password= ?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),admin.getUsername(),admin.getPassword());
	}
    //更改管理员密码
	@Override
	public void updatePass(Admin user2) throws Exception {
		String sql="update admin set password=? where username=?";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,user2.getPassword(),user2.getUsername());
	}

}
