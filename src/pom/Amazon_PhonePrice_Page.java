package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_PhonePrice_Page {
	
	@FindBy(xpath="//a[contains(@href,'/Apple-iPhone-XR-64GB-Yellow/dp/')]/span[1]/span[2]")
	private WebElement iphone_price;
  
	public Amazon_PhonePrice_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Method to fetch the price of the iphone
	public int fetching_iPhone_Price()
	{
		    String price = iphone_price.getText().replaceAll("[₹,]","");
		    int amazone_Price = Integer.parseInt(price);
		    return amazone_Price;
	}

}
