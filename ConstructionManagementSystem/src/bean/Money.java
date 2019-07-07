package bean;

import java.util.Date;

public class Money {
	private String id;
	private double money;
	private int cid;//1项目款收入 2采购支出  3员工支出   4其他支出
	private Date date;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Money() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Money(String id, double money, int cid, Date date, String name) {
		super();
		this.id = id;
		this.money = money;
		this.cid = cid;
		this.date = date;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Money [id=" + id + ", money=" + money + ", cid=" + cid + ", date=" + date + ", name=" + name + "]";
	}
	

	
	
	

}
