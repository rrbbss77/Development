package hello;

public class MyProp {

	private String name;
	private String address;
	
	public MyProp(AppProp appProp)
	{
		this.setName(appProp.getName());
		this.setAddress(appProp.getAddress());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String prop1) {
		this.name = prop1;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
