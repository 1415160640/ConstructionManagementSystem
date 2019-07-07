package bean;
//工资模型
public class Wages {
	private String id;
	private String name;
	private double time;
	private int badwork;//当月延时施工次数
	private int baddate;//当月缺勤次数
	private Borrow borrow;//员工预支工资
	private double workdatemoney;//工时工资
	private double badworkmoney;//无延时奖励
	private double baddatemoney;//全勤奖励
	private double othermoney;//其他奖励
	private double count;//总计工资
	
	public double getOthermoney() {
		return othermoney;
	}
	public void setOthermoney(double othermoney) {
		this.othermoney = othermoney;
	}
	public Borrow getBorrow() {
		return borrow;
	}
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
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
	public int getBadwork() {
		return badwork;
	}
	public void setBadwork(int badwork) {
		this.badwork = badwork;
	}
	public int getBaddate() {
		return baddate;
	}
	public void setBaddate(int baddate) {
		this.baddate = baddate;
	}
	public double getWorkdatemoney() {
		return workdatemoney;
	}
	public void setWorkdatemoney(double workdatemoney) {
		this.workdatemoney = workdatemoney;
	}
	public double getBadworkmoney() {
		return badworkmoney;
	}
	public void setBadworkmoney(double badworkmoney) {
		this.badworkmoney = badworkmoney;
	}
	public double getBaddatemoney() {
		return baddatemoney;
	}
	public void setBaddatemoney(double baddatemoney) {
		this.baddatemoney = baddatemoney;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public Wages() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Wages [id=" + id + ", name=" + name + ", time=" + time + ", badwork=" + badwork + ", baddate=" + baddate
				+ ", borrow=" + borrow + ", workdatemoney=" + workdatemoney + ", badworkmoney=" + badworkmoney
				+ ", baddatemoney=" + baddatemoney + ", othermoney=" + othermoney + ", count=" + count + "]";
	}
	public Wages(String id, String name, double time, int badwork, int baddate, Borrow borrow, double workdatemoney,
			double badworkmoney, double baddatemoney, double othermoney, double count) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.badwork = badwork;
		this.baddate = baddate;
		this.borrow = borrow;
		this.workdatemoney = workdatemoney;
		this.badworkmoney = badworkmoney;
		this.baddatemoney = baddatemoney;
		this.othermoney = othermoney;
		this.count = count;
	}
	
	
	
	

}
