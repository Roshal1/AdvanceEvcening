package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {
	@Test(priority = 0)
	
	public void amazon()
	{
		Reporter.log("Amazon executed",true);
	}
@Test(priority = 2)
	
	public void bookMyShow()
	{
		Reporter.log("BMS executed",true);
	}
@Test(priority = -4)

public void flipkart()
{
	Reporter.log("flipkart executed",true);
}

}
