package helperAttributes;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertExample {
	@Test
	
	public void demo() {
		String expectedTitle = "Facebook – log in or sign upp";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		@Nullable
		String actualTitle = driver.getTitle();
		
		//Assert.assertEquals(actualTitle, expectedTitle);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle);
		System.out.println("step1");
		System.out.println("step2");
		soft.assertAll();
	}

}
