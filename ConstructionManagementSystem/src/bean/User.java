package bean;

import java.util.Date;

public class User {
	private String  id;
	private String  name;
	private double time;
	private Date date;
	private String  address;
	private String  pid;
	private String phone;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, double time, Date date, String address, String pid, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.date = date;
		this.address = address;
		this.pid = pid;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", time=" + time + ", date=" + date + ", address=" + address
				+ ", pid=" + pid + ", phone=" + phone + "]";
	}
    
	

}
