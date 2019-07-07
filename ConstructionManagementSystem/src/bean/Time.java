package bean;
//时间设定
public class Time {
	private String id;
	private double num;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Time(String id, double num, String name) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Time [id=" + id + ", num=" + num + ", name=" + name + "]";
	}
	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
