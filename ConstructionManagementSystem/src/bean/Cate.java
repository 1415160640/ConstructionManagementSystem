package bean;

public class Cate {
	private String id;
	private String name;
	private double count;
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
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public Cate(String id, String name, double count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	public Cate() {
		super();
	}
	@Override
	public String toString() {
		return "Cate [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	

}
