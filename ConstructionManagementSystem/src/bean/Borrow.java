package bean;
//预支工资数据模型
public class Borrow {
	private String id;
	private double money;
	private String uid;
	private User user;
	private double max;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public Borrow(String id, double money, String uid, User user, double max) {
		super();
		this.id = id;
		this.money = money;
		this.uid = uid;
		this.user = user;
		this.max = max;
	}
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", money=" + money + ", uid=" + uid + ", user=" + user + ", max=" + max + "]";
	}
	
	

}
