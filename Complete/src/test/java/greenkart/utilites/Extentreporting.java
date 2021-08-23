package greenkart.utilites;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreporting {
	static ExtentReports extent;
	
	public static ExtentReports getreport()
	{
		String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportpath=System.getProperty("User.dir")+"/reports/"+timestamp+"index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportpath);
		reporter.config().setReportName("automation result Kumar");
		reporter.config().setDocumentTitle("Test results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("test", "Kumar");
		return extent;
		
		
	}

}
