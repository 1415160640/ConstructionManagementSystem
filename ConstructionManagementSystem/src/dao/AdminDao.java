package dao;

import java.util.Date;
import java.util.List;

import bean.Bad;
import bean.Buy;
import bean.Cate;
import bean.Project;
import bean.User;
import bean.Work;
//管理dao层接口
public interface AdminDao {

	List<Project> findProject() throws Exception;

	void updateProject(Project pro) throws Exception;

	int ProjectCount() throws Exception;

	Project findProjectById(String id) throws Exception;

	void addProject(Project pro) throws Exception;

	List<Project> SearProject(String date) throws Exception;

	void deleteProject(String id) throws Exception;

	List<Project> findProjectStart() throws Exception;

	List<Project> findProjectEnd() throws Exception;

	List<Project> findProjectNo() throws Exception;

	List<Cate> findCate() throws Exception;

	Cate findCateById(String id) throws Exception;

	void updateCate(Cate cate) throws Exception;

	void addCate(String name) throws Exception;

	void deleteCate(String id) throws Exception;

	List<Buy> findBuy() throws Exception;

	void addBuy(Buy buy) throws Exception;

	void deleteBuy(String id) throws Exception;

	List<Work> findWork() throws Exception;

	void updateWork(Work pro) throws Exception;

	Work findWorkById(String id) throws Exception;

	void saveBad(Bad bad) throws Exception;

	List<User> findUser() throws Exception;

	void addWork(Work work) throws Exception;

	void deleteWork(String id) throws Exception;

	List<Work> SearWork(String time) throws Exception;

	List<Work> findWorkStart() throws Exception;

	List<Work> findWorkEnd() throws Exception;

	List<Bad> findBadWork(int cid) throws Exception;

	void deleteBadWork(String id) throws Exception;

	User findUserByName(String name) throws Exception;

	List<Bad> SearBadWork(String id) throws Exception;

	void addUser(User user) throws Exception;

	void deleteUser(String id) throws Exception;

	User findUsertById(String id) throws Exception;

	void updateUser(User pro) throws Exception;

	void deleteBorrow(String id) throws Exception;


}
