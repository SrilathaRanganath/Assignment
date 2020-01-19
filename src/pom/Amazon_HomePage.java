package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_HomePage {
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbox_textfield;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchicon_button;
	
	
	
	public Amazon_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//Searching for the Product
	public void searchForProduct(String text)
	{
		searchbox_textfield.sendKeys(text);
	}
	
	//Performing click action
    public void clickOnSearchIcon()
    {
    	searchicon_button.click();
    }

}
