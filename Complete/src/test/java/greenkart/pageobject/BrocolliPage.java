package greenkart.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrocolliPage {
	
	public WebDriver driver;
	
	public BrocolliPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
By product_Brocolli_ele=By.xpath("//h4[text()='Brocolli - 1 Kg']");
public WebElement product_Brocolli_method()
{
	return driver.findElement(product_Brocolli_ele);
	
}
By product_Brocolli_addtocart_ele=By.xpath("//h4[text()='Brocolli - 1 Kg']/following-sibling::div[2]/button");
public WebElement product_Brocolli_addtocart_method()
{
	return driver.findElement(product_Brocolli_addtocart_ele);
}

}
