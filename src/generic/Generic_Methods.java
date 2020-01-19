package generic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Generic_Methods implements Constant_Variables{
	
	static
	{
		System.setProperty(Gecko_key,Gecko_value);
		
	}
	public WebDriver driver;
	@BeforeMethod
	public void Open_App() 
	{
			driver=new FirefoxDriver();
			
	}
	
	@AfterMethod
	public void Close_App(ITestResult res) throws IOException
	{
		int status=res.getStatus();
		
		if(status==res.FAILURE)
		{
			CaptureScreenShot_generic.get_ScreenShot(driver);
			
		}

      driver.quit();
	}

}


