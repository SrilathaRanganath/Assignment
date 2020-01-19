package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_PhonePrice_Page {
	
	@FindBy(xpath="//a[contains(@href,'/apple-iphone-xr-yellow-64-gb')]/div[2]/div[2]/div[1]/div[1]/div[1]")
	private WebElement iphone_price;
	
	public Flipkart_PhonePrice_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Method to fetch the price of the iphone
		public int fetching_iPhone_Price()
		{
			    String price = iphone_price.getText().replaceAll("[₹,]","");
			    int flipkart_Price = Integer.parseInt(price);
			    return flipkart_Price;
		}


}
