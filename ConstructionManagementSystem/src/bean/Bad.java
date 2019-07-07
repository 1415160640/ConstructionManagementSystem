package bean;

import java.util.Date;

public class Bad{
	private String id;
	private String type;
	private Date date;
	private String uid;
	private User user;
	private int cid;//1施工延迟 2缺勤
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bad() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bad [id=" + id + ", type=" + type + ", date=" + date + ", uid=" + uid + ", user=" + user + ", cid="
				+ cid + "]";
	}
	public Bad(String id, String type, Date date, String uid, User user, int cid) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.uid = uid;
		this.user = user;
		this.cid = cid;
	}
	
	
	

}
