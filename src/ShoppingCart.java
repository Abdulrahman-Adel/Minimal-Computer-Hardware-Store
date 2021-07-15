
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

public class ShoppingCart {
	private String Cart_ID;
	private ArrayList<Product> product_list;
	private Double Total_price = 0.0;
	
	ShoppingCart()
	{
		this.generateID();
		this.product_list = new ArrayList<>();
	}
	
	private void generateID() {
		// TODO Auto-generated method stub
		this.Cart_ID = UUID.randomUUID().toString();
	}
	
	public String getID()
	{
		return this.Cart_ID;
	}

	public void AddItem(Product pr)
	{
		product_list.add(pr);
		
		JOptionPane.showMessageDialog(null, "Product Added!");
	}
	
	public void removeItem(Product pr)
	{
		for(int i = 0; i < product_list.size(); i++)
		{
			if(product_list.get(i).getID().equals(pr.getID()))
			{
				product_list.remove(product_list.get(i));
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Product removed!");
	}
	public void UpdateQuantity(Product pr, int q)
	{
		for(int i = 0; i < product_list.size(); i++)
		{
			if(product_list.get(i).getID().equals(pr.getID()))
			{
				product_list.get(i).setQuan(q);
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Quantity Updated!");
	}
	
	public int getLength()
	{
		int length  = product_list.size();
		return length;
	}

	public String printItems() {
		// TODO Auto-generated method stub
		String items = "";
		for(int i = 0; i < product_list.size(); i++)
		{
			items += "Product_name: "+ product_list.get(i).getName() + "\tQuantity: " + product_list.get(i).getQuan() + "\tPrise: " + product_list.get(i).getPrice() + "\n";
		}
		return items;
	}
	
	public Double getTotal_price()
	{
		this.Total_price = 0.0;
		
		for(int i = 0; i < product_list.size(); i++)
		{
			Total_price += product_list.get(i).getPrice() * product_list.get(i).getQuan();
		}
		
		return this.Total_price;
	}
	
	public boolean SearchProduct(Product pr)
	{	
		for(int i = 0; i < product_list.size(); i++)
		{
			if(product_list.get(i).getID().equals(pr.getID()))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Product> getProduct_list()
	{
		return this.product_list;
	}
	
	
}
