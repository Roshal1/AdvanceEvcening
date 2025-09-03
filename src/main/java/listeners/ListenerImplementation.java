package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.BaseClass;

public class ListenerImplementation implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
        Reporter.log("Report Configuration",true);
		Date d = new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReports/report_"+newDate+".html");
		spark.config().setDocumentTitle("NinzaCRM TestResults");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Edge");
	}
    @Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		Reporter.log("Report Backup",true);
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"==="+result.getMethod().getMethodName()+"execution Started");	
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("===="+result.getMethod().getMethodName()+"execution Success=====",true);
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		Reporter.log("===="+testName+"FAILURE======",true);
		Date d = new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		//File temp = ts.getScreenshotAs(OutputType.FILE);
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,testName+newDate);
		test.log(Status.FAIL,"==="+testName+"FAILURE====");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	

}
