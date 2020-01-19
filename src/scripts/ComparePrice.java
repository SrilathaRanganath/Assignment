package scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Property;
import pom.Amazon_HomePage;
import pom.Amazon_PhonePrice_Page;
import pom.Flipkart_HomePage;
import pom.Flipkart_PhonePrice_Page;

public class ComparePrice extends generic.Generic_Methods  implements generic.Constant_Variables{
	
	
	@Test
	public void compare_price() throws FileNotFoundException, IOException
	{
		
	  	
	  	//Amazon Application
		String amazonurl=Property.get_Property(PropertyFile_PATH, "amazonurl");
		driver.get(amazonurl);
	  	driver.manage().window().maximize();
	    //Fetching implicit wait time from the Property file using Property class
	    String implicitwait=Property.get_Property(PropertyFile_PATH, "implicitwait");
	  	Long iw=Long.parseLong(implicitwait);
	  	driver.manage().timeouts().implicitlyWait(iw, TimeUnit.SECONDS);
	  	
	  	//Searching iPhone XR(64GB-Yellow) product in Amazon
	  	Amazon_HomePage amazonhomepage = new Amazon_HomePage(driver);
	  	
	  	amazonhomepage.searchForProduct("iPhone XR(64GB)-Yellow");
	  	amazonhomepage.clickOnSearchIcon();
	  	
	  	//Fetching the price of the iPhone
	  	Amazon_PhonePrice_Page amazonphonepricepage = new Amazon_PhonePrice_Page(driver);
	  	
	  	int amazon_price = amazonphonepricepage.fetching_iPhone_Price();
	  	Reporter.log("Price in Amazon is : "+amazon_price,true);
		
	  	//Flipkart Application
	  	String flipkarturl=Property.get_Property(PropertyFile_PATH, "flipkarturl");
		driver.get(flipkarturl);
	  
	  	//Searching iPhone XR(64GB-Yellow) product in Flipkart
	  	Flipkart_HomePage fkarthomepage = new Flipkart_HomePage(driver);
	  	
	  	try{
	  		fkarthomepage.searchForProduct("iPhone XR(64GB)-Yellow");
	  		fkarthomepage.clickOnSearchIcon();
	  		}
	  	catch(Exception e)
	  	{
	  		fkarthomepage.closeSignupWindow();
	  		fkarthomepage.searchForProduct("iPhone XR(64GB)-Yellow");
		  	fkarthomepage.clickOnSearchIcon();
	  	}
	  	
	  	
	  	
	  //Fetching the price of the iPhone
	  	Flipkart_PhonePrice_Page fkartphonepricepage = new Flipkart_PhonePrice_Page(driver);
	  	
	  	int flipkart_Price = fkartphonepricepage.fetching_iPhone_Price();
	  	Reporter.log("Price in Flipkart is : "+flipkart_Price,true);
	  	
	  	if(amazon_price>flipkart_Price)
	  	{
	  		Reporter.log("Product iPhone XR(64GB)-Yellow price is lesser in Flipkart than Amazon",true);
	  	}
	  	else
	  	{
	  		Reporter.log("Product iPhone XR(64GB)-Yellow price is lesser in Amazon than Flipkart",true);
	  	}
	}  	
	
	

}
