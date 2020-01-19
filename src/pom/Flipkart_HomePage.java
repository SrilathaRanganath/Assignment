package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_HomePage {
	
	@FindBy(xpath="//button[.='✕']")
	private WebElement close_icon;

	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement searchbox_textfield;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchicon_button;
	
	public Flipkart_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
   
	
	public void closeSignupWindow()
	{
		close_icon.click();
	}
	
	public void searchForProduct(String text)
	{
		searchbox_textfield.sendKeys(text);
	}
	
	public void clickOnSearchIcon()
	{
		searchicon_button.click();
	}
	
}
