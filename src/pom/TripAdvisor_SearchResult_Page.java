package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisor_SearchResult_Page {
	
	@FindBy(xpath="//div[@class='ui_columns is-mobile result-content-columns']/div[2]/div[1]/div[1]")
	private WebElement clickOnFirstResultlink;
	
	public TripAdvisor_SearchResult_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickOnFirstResult()
	{
		clickOnFirstResultlink.click();
	}

}
