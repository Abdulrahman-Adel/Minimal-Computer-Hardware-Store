import java.util.UUID;

public class Order {
	private String Order_ID;
	private String Cart_ID;
	private String Shipping_Info;
	private String PaymentDetails;
	private String Customer_feedback;
	
	
	public void setPayment(String method)
	{
		this.PaymentDetails = method;
	}
	
	public void generateID() {
		// TODO Auto-generated method stub
		this.Order_ID = UUID.randomUUID().toString();
	}
	
	public String getPayment()
	{
		return this.PaymentDetails;
	}
	
	public void setShipping(String region)
	{
		this.Shipping_Info = region;
	}
	
	public String getShipping()
	{
		return this.Shipping_Info;
	}

	public String getCustomer_feedback() {
		return Customer_feedback;
	}

	public void setCustomer_feedback(String customer_feedback) {
		Customer_feedback = customer_feedback;
	}

	public String getCart_ID() {
		return Cart_ID;
	}

	public void setCart_ID(String id) {
		Cart_ID = id;
	}

	public String getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(String order_ID) {
		Order_ID = order_ID;
	}
	
	
}
