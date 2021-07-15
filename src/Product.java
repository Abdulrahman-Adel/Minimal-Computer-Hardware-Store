import java.util.UUID;

public class Product {
	
	private String Name;
	private String category;
	private String company;
	private String Description;
	private String product_ID;
	private String ImagePath;
	private Double Price;
	private int Quantity = 1;

	
	public void setName(String n)
	{
		this.Name = n;
	}
	
	public void setCat(String cat)
	{
		this.category = cat;
	}
	
	public void setCompany(String com)
	{
		this.company = com;
	}
	
	public void setDes(String des)
	{
		this.Description = des;
	}
	
	public void setImagePath(String ip)
	{
		this.ImagePath = ip;
	}
	
	public void setPrice(double p)
	{
		this.Price = p;
	}
	
	public void generateID()
	{
		this.product_ID = UUID.randomUUID().toString();
	}
	
	public void setID(String id)
	{
		this.product_ID = id;
	}
	
	public void setQuan(int q)
	{
		this.Quantity = q;
	}
	
	public String getImagePath() {
		// TODO Auto-generated method stub
		return this.ImagePath;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.Name;
	}

	public Double getPrice() {
		// TODO Auto-generated method stub
		return this.Price;
	}

	public String getDes() {
		// TODO Auto-generated method stub
		return this.Description;
	}

	public String getCompany() {
		// TODO Auto-generated method stub
		return this.company;
	}

	public String getCat() {
		// TODO Auto-generated method stub
		return this.category;
	}
	
	public int getQuan() {
		// TODO Auto-generated method stub
		return this.Quantity;
	}
	
	public String getID()
	{
		return this.product_ID;
	}
}
