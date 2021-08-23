package greenkart.testcase;

import java.io.IOException;

import org.testng.annotations.Test;
import greenkart.pageobject.BrocolliPage;

public class TC_BrocolliTest extends Base {
	
	@Test
	public void brocolliTest() throws IOException
	{
		

		
		
		BrocolliPage p=new BrocolliPage(driver);
		logger.info("print the text from the product");
		System.out.println(p.product_Brocolli_method().getText());
		logger.info("Add the product to cart");
		p.product_Brocolli_addtocart_method().click();
		
		
		
		
		
	}
}
	
	


