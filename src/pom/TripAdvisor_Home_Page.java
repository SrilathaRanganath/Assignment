package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripAdvisor_Home_Page {
	
public WebDriver driver;
	
    @FindBy(xpath="//span[.='Search']")
	private WebElement searchicon;
    
	
	@FindBy(id="mainSearch")
	private WebElement searchtextbox;
	
	@FindBy(xpath="//div[.='Search']")
	private WebElement searchbutton;
	
	
	public TripAdvisor_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickOnSearchIcon()
	{
		searchicon.click();
	}
	
	
	public void enterHotelName(WebDriver driver,String text)
	{
		   WebDriverWait wait=new WebDriverWait(driver,15);
		   wait.until(ExpectedConditions.visibilityOf(searchtextbox));
		   searchtextbox.sendKeys(text);
	}
	
	public void clickOnSearchButton()
			
	{
		searchbutton.click();
	}
		


}
