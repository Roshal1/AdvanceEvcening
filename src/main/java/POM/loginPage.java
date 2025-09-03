package POM;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
  WebDriver driver;
  public loginPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  

	}
  
  @FindBy(id="username")
  private WebElement UN;
  
  @FindBy(id="inputPassword")
  private WebElement PW;
  
  @FindBy(xpath="//button[text()='Sign In']")
  private WebElement loginbtn;
  
  
public WebElement getUN() {
	return UN;
}

public WebElement getPW() {
	return PW;
}

public WebElement getLoginbtn() {
	return loginbtn;
}
  
//  public WebElement getUN() {
 // return UN;
  
 // }
 // public WebElement getPW() {
//	  return PW;
	  
	//  }
 // public WebElement getloginbtn() {
//	  return loginbtn;
	  
	  }
  

