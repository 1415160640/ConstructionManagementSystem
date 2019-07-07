package bean;

import java.util.Date;
//工程类
public class Project {
	private String  id;
	private String  name;
	private Date start;
	private Date end;
	private double money;
	private int state;//1未开始  2施工中   3已延期   4已完成
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String id, String name, Date start, Date end, double money, int state) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.money = money;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", start=" + start + ", end=" + end + ", money=" + money
				+ ", state=" + state + "]";
	}
    
	

}
