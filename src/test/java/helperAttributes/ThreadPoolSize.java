package helperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSize {
	@Test(invocationCount = 6,threadPoolSize = 0)
	
	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("executed",true);
		Thread.sleep(3000);
		driver.quit();
	}

}
