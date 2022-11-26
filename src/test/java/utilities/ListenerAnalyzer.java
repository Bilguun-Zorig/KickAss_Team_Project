package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerAnalyzer extends CaptureScreenshot implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Method name is " + result.getName());
		System.out.println("onTestStart");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of execution is " + result.getStatus());
		System.out.println("onTestSuccess");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure taking SS");
		try {
			getScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}
}
