import static org.junit.Assert.*;

import org.junit.Test;

public class AddProductTest {

	@Test
	public void test1() {
		Admin a = new Admin();
		AddProdcutPage instance = new AddProdcutPage(a);
		
		boolean result = instance.TestHelp("Intel-i7", "CPU", "INTEL", "C://IMAGES//ImG.PNG", "225.5", "awsome cpu");
		
		assertFalse(result);
	}
	
	@Test
	public void test2() {
		Admin a = new Admin();
		AddProdcutPage instance = new AddProdcutPage(a);
		
		boolean result = instance.TestHelp("Intel-i7", "CPU", "INTEL", "C://IMAGES//ImG.PNG", "", "awsome cpu");
		
		assertFalse(result);
	}
	
	@Test
	public void test3() {
		Admin a = new Admin();
		AddProdcutPage instance = new AddProdcutPage(a);
		
		boolean result = instance.TestHelp("", "", "", "", "", "");
		
		assertFalse(result);
	}

}
