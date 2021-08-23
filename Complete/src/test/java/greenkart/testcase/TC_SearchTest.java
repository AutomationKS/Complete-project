package greenkart.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import greenkart.pageobject.SearchPage;
import greenkart.utilites.Readexcel;

// For new test case extend the base class and create object of page object class and perform actions
// Add the class in test NG file 
public class TC_SearchTest extends Base {
	@Test
	public void searchTestcase() throws IOException
	{
		Readexcel r=new Readexcel();
		logger.info("Search the object");
		
		SearchPage s=new SearchPage(driver);
		s.search_product().sendKeys(r.readdata(1, 1));
	}

}
