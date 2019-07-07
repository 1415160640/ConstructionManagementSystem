package bean;
//员工奖励数据模型
public class Spring {
	private String id;
	private String name;
	private double num;
	private String apart;
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
	public  double getNum() {
		return num;
	}
	public void setNum( double num) {
		this.num = num;
	}
	public String getApart() {
		return apart;
	}
	public void setApart(String apart) {
		this.apart = apart;
	}
	public Spring(String id, String name,  double num, String apart) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.apart = apart;
	}
	public Spring() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Spring [id=" + id + ", name=" + name + ", num=" + num + ", apart=" + apart + "]";
	}
	

}
