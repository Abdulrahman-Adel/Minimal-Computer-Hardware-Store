import static org.junit.Assert.*;

import org.junit.Test;

public class CartTest {

	@Test
	public void SearchProducttest() {
		
		Product p = new Product();
		p.generateID();
		Product p2 = new Product();
		p2.generateID();
		
		ShoppingCart instance = new ShoppingCart();
		instance.AddItem(p);
		
		boolean result = instance.SearchProduct(p2);
		
		assertFalse(result);
	}
	
	@Test
	public void SearchProducttest2() {
		
		Product p = new Product();
		p.generateID();
		
		ShoppingCart instance = new ShoppingCart();
		instance.AddItem(p);
		
		boolean result = instance.SearchProduct(p);
		
		assertTrue(result);
	}
	
	@Test
	public void SearchProducttest3() {
		
		Product p = new Product();
		p.generateID();
		
		ShoppingCart instance = new ShoppingCart();
		instance.AddItem(p);
		
		instance.removeItem(p);
		
		boolean result = instance.SearchProduct(p);
		
		assertFalse(result);
	}

}
