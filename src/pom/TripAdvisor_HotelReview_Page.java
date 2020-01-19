package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripAdvisor_HotelReview_Page {
	
	
	  @FindBy(xpath="//a[.='Write a review']")
	  private WebElement reviewbutton;
	  
	  
	  public TripAdvisor_HotelReview_Page(WebDriver driver)
	  {
		  PageFactory.initElements(driver,this);
	  }
	  
	  public void clickOnWriteReviewButton(WebDriver driver)
	  {
		  /*WebDriverWait wait=new WebDriverWait(driver,30);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(reviewbutton));*/
		  reviewbutton.click();
	  }
	 


}
