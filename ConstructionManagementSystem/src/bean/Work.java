package bean;

import java.util.Date;

public class Work {
	private String  id;
	private String  name;
	private Date start;
	private Date end;
	private String uid;
	private User user;
	private int state;//1未开始  2施工中   3已延期   4已完成
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Work(String id, String name, Date start, Date end, String uid, User user, int state) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.uid = uid;
		this.user = user;
		this.state = state;
	}
	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Work [id=" + id + ", name=" + name + ", start=" + start + ", end=" + end + ", uid=" + uid + ", user="
				+ user + ", state=" + state + "]";
	}
	

}
