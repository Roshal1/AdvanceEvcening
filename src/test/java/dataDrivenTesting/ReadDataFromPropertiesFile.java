package dataDrivenTesting;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	//import PropertiesFileUtility.PropertiesUtility;

	public class ReadDataFromPropertiesFile  {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			//FileInputStream fis = new FileInputStream("C:\\Users\\Shrinivas Anant\\Documents\\ninzaCrmCommondata.properties");
			FileInputStream fis= new FileInputStream("./ConfigData/ninzaCrmCommondata.properties");
	       //create object of properties file
		Properties prop = new Properties();
			//load all keys
		prop.load(fis);
		//get properties
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
			String USERNAME = prop.getProperty("Username");
			String PASSWORD = prop.getProperty("Password");
		
			
			
			WebDriver driver = null;
			
			if(BROWSER.equals("Edge"))
			{
				driver= new EdgeDriver();
			}
			if(BROWSER.equals("Chrome"))
			{
				driver= new ChromeDriver();
			}
			if(BROWSER.equals("Firefox"))
			{
				driver= new FirefoxDriver();
			}
		}
}
