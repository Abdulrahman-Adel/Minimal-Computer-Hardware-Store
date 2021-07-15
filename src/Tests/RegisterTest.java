import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterTest {

	@Test
	public void test() {
		RegisterPage instance = new RegisterPage();
		
		boolean result = instance.TestHelp("Ahmed", "01146631026", "Ahme033019$", "Ahme033019$", "Alaml", "ahmed98@gmail.com");
		
		assertTrue(result);
	}
	
	@Test
	public void test2() {
		RegisterPage instance = new RegisterPage();
		
		boolean result = instance.TestHelp("", "01146631026", "Ahme033019$", "Ahme033019$", "Alaml", "ahmed@gmail.com");
		
		assertFalse(result);
	}
	
	@Test
	public void test3() {
		RegisterPage instance = new RegisterPage();
		
		boolean result = instance.TestHelp("Ahmed", "01146631026", "Ahme033019$", "Ahme03301", "Alaml", "ahmed98@gmail.com");
		
		assertFalse(result);
	}
	
	@Test
	public void test4() {
		RegisterPage instance = new RegisterPage();
		
		boolean result = instance.TestHelp("Ahmed", "01146631026", "Ahme033019$", "Ahme033019$", "Alaml", "ahmed.98");
		
		assertFalse(result);
	}

}
