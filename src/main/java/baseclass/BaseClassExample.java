package baseclass;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassExample {
	
	@Test
	
	public void TC001() {
		Reporter.log("Testcases ", true);
	}
	@BeforeMethod
	public void beforemethod() {
		Reporter.log("login",true);
	}
	@AfterMethod
	public void aftermethod() {
		Reporter.log("logout",true);
	}
	@BeforeClass
	public void beforeclass() {
		Reporter.log("launching browser",true);
	}
	@AfterClass
	public void afterclass() {
		Reporter.log("closing browser",true);
	}
	@BeforeTest
	public void beforetest() {
		Reporter.log("pre condition",true);
	}
	@AfterTest
	public void aftertest() {
		Reporter.log("post condition",true);
	}
	@BeforeSuite
	public void beforesuite() {
		Reporter.log("database open",true);
	}
	@AfterSuite
	public void aftersuite() {
		Reporter.log("databas eclose",true);
	}

}
