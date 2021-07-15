
public class Customer extends User {
	
	private String Address;
	private String PhoneNumber;
	
	public void setAdd(String add)
	{
		this.Address = add;
	}
	public String getAdd()
	{
		return this.Address;
	}
	
	public void setNo(String PN)
	{
		this.PhoneNumber = PN;
	}
	
	public String getNo()
	{
		return this.PhoneNumber;
	}
}

