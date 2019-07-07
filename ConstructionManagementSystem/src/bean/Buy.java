package bean;

import java.util.Date;

public class Buy {
	private String id;
	private double money;
	private double count;
	private int cid;
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
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
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
	public Buy(String id, double money, double count, int cid, Date date, String name) {
		super();
		this.id = id;
		this.money = money;
		this.count = count;
		this.cid = cid;
		this.date = date;
		this.name = name;
	}
	public Buy() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Buy [id=" + id + ", money=" + money + ", count=" + count + ", cid=" + cid + ", date=" + date + ", name="
				+ name + "]";
	}
	
	

}
