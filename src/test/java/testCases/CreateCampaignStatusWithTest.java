package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CampaignPage;
import POM.HomePage;
import POM.loginPage;
import baseclass.BaseClass;
import excelFileUtility.ExcelUtility;
import javaUtility.JavaUtility;
import propertiesFileUtility.PropertiesUtility;
import webDriverUtility.WebDriverUtility;
@Listeners(listeners.ListenerImplementation.class)
public class CreateCampaignStatusWithTest extends BaseClass {
	@Test(groups = "Smoke")

	public  void  CreateCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException {

	
			
		// read data from excel
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
		String status = eutil.getDataFromExcel("Campaign", 1, 4);

	WebDriverUtility wutil = new WebDriverUtility();
	System.out.println("hi");
	
	//WebDriver driver = new ChromeDriver();
	

	
	JavaUtility jutil = new JavaUtility();
	
	// create campaign
	HomePage hp = new HomePage(driver);
	hp.getCreatecampaign().click();
	
	CampaignPage cp = new CampaignPage(driver);
	cp.getCampaignName().sendKeys(campname);
	cp.getTargetsizeTF().sendKeys(size);
	cp.getCampaignstatus().sendKeys(status);
	cp.getCreatecampaignsubmitBtn().click();
	
	
	// validation
	Thread.sleep(3000);
	WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
	
	wutil.waitforVisibilityofElement(driver, toastmsg);
			
	String msg = toastmsg.getText();
	 Assert.assertTrue(msg.contains(campname));
		Thread.sleep(3000);
	

driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	// logout
	
}
}

