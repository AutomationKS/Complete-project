package greenkart.utilites;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import greenkart.testcase.Base;

public class Listeners extends Base implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent=Extentreporting.getreport();
	ThreadLocal <ExtentTest>extenttest=new ThreadLocal<ExtentTest>();
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	test=extent.createTest(result.getMethod().getMethodName());
	extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().generateLog(Status.PASS, "test pass successfully");
		
		String filename=result.getMethod().getMethodName();
		
	//Take screen shots and store in the project
		try {
			getscreenshot(filename, "Pass", driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
// Take screen shots and store in the project and 
		
		try {
			extenttest.get().addScreenCaptureFromPath(getscreenshot(filename,"Pass", driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {		
			extenttest.get().fail(result.getThrowable()); 
		String testmethodname= result.getMethod().getMethodName();;
		try {
			getscreenshot(testmethodname, "Faill", driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extenttest.get().addScreenCaptureFromPath(getscreenshot(testmethodname,"Faill", driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 }

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		  extent.flush();
	}

}
