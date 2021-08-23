package greenkart.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import greenkart.utilites.Readconfig;

public class Base {
	public static WebDriver driver;
	Readconfig r = new Readconfig();

	public static Logger logger;

	public WebDriver intializedriver(String S) {

	
		if (S.contentEquals("Chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", r.chromepath());
			ChromeOptions o=new ChromeOptions();
			o.addArguments("headless");
			driver = new ChromeDriver(o);
			logger.info("Chrome Webdriver initialise with headless mode");
		}
		else if(S.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", r.chromepath());
			driver = new ChromeDriver();
			logger.info("Chrome Webdriver initialise");
		}

		else if (S.contentEquals("IE")) {

		}

		else if (S.contentEquals("Firefox")) {

		}
		return driver;

	}

	@BeforeTest

	public void Starttest() {
		logger = Logger.getLogger("greenkart");
		PropertyConfigurator.configure("Log4j.properties");
		driver = intializedriver("Chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(r.Url());
		logger.info("Open webpage");

	}

	@AfterTest
	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	public String getscreenshot(String testcasename,String Status, WebDriver driver) throws IOException {
String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		String filename = System.getProperty("User.dir") + "/reports/" + testcasename +Status+timestamp+ ".png";
		FileUtils.copyFile(f, new File(filename));
		logger.info("Screenshots taken");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return filename;
		

	}

}
