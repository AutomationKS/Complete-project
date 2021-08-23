package greenkart.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// For new page create a constructor and add respective web element methods


public class SearchPage {
	public WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
By searchs=By.xpath("//input[@class='search-keyword']");
public WebElement search_product()
{
	return driver.findElement(searchs);
	
}
}
