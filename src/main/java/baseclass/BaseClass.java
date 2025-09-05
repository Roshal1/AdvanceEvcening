package baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM.HomePage;
import POM.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import propertiesFileUtility.PropertiesUtility;

import propertiesFileUtility.PropertiesUtility;

public class BaseClass {
		public WebDriver driver = null;
		public static WebDriver sdriver = null;
		public PropertiesUtility putil = new PropertiesUtility();
		
		@BeforeSuite(groups = {"Smoke","Regression"})
		public void beforesuite() {
			Reporter.log("DB Connectivity open",true);
		}
		
		@BeforeTest(groups = {"Smoke","Regression"})
		public void beforetest() {
			System.out.println("preconditions");
		}
		@BeforeClass(groups = {"Smoke","Regression"})
		public void beforeclass() throws IOException {
			String BROWSER = putil.getdatafromPropertiesfile("Browser");
			if(BROWSER.equals("Edge")) {
				WebDriverManager.edgedriver();
				driver= new EdgeDriver();
			}
			if(BROWSER.equals("Chrome")) {
				driver= new ChromeDriver();
			}
			if(BROWSER.equals("Firefox")) {
				driver= new FirefoxDriver();
			}
			sdriver=driver;
			System.out.println("launching Browser");
			driver.manage().window().maximize();


		}
		@BeforeMethod(groups = {"Smoke","Regression"})
		public void beforeMethod() throws IOException {
			String BROWSER = putil.getdatafromPropertiesfile("Browser");
			String URL = putil.getdatafromPropertiesfile("Url");
			String USERNAME = putil.getdatafromPropertiesfile("Username");
			String PASSWORD = putil.getdatafromPropertiesfile("Password");
			driver.get(URL);
			loginPage lp = new loginPage(driver);
			lp.getUN().sendKeys(USERNAME);
			lp.getPW().sendKeys(PASSWORD);
			lp.getLoginbtn().click();
			System.out.println("LOGIN DONE");
			
		}
		@AfterMethod(groups = {"Smoke","Regression"})
		public void aftermethod() {
			HomePage hp = new HomePage(driver);
			hp.getUserIcon().click();
			hp.getLogoutBtn().click();
			System.out.println("Logout Done");
			
		}
		@AfterClass(groups = {"Smoke","Regression"})
		public void afterclass() {
			driver.quit();
		}
		@AfterTest(groups = {"Smoke","Regression"})
		public void aftertest() {
			System.out.println("Post Condition");
		}
		@AfterSuite(groups = {"Smoke","Regression"})
		public void afterSuite() {
			System.out.println("Close DB Connectivity");
		}
		

	}


