package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.Action_generic;

public class TripAdvisor_Ratings_Page {
	
	@FindBy(id="bubble_rating")
	private WebElement ratingradiobutton;
	
	@FindBy(name="ReviewTitle")
	private WebElement titletextbox;
	  
    @FindBy(name="ReviewText")
	private WebElement reviewtextbox;
	  

	
	@FindBy(xpath="//div[.='Hotel Ratings']")
	private WebElement hotelratingsradiobutton;

	@FindBy(xpath="//span[@id='qid12_bubbles']")
	private WebElement serviceradiobutton;
 
	
	@FindBy(name="noFraud")
	private WebElement submitchkbox;

	public TripAdvisor_Ratings_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectRating(WebDriver driver)
	{
		
		Action_generic actiongen = new Action_generic(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ratingradiobutton));
		
		for(int i=10;i<50;i=i+10)
		{
		 actiongen.mouseHover(ratingradiobutton,i);
		}
		/*Actions act=new Actions(driver);
 	    WebDriverWait wait=new WebDriverWait(driver,30);
 	    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bubble_rating")));
			
	    wait.until(ExpectedConditions.elementToBeClickable(ratingradiobutton));
		
		act.moveToElement(ratingradiobutton,10, 0).perform();
		
		act.moveToElement(ratingradiobutton,20, 0).perform();
        
		act.moveToElement(ratingradiobutton,30, 0).perform();
		
		act.moveToElement(ratingradiobutton,40, 0).perform();
		
        act.moveToElement(ratingradiobutton,50, 0).click().build().perform();*/
        
        
	}
	public void enterReviewTitle(String text)
	{
		titletextbox.sendKeys(text);
	}
	public void enterReview(String text)
	{
		reviewtextbox.sendKeys(text);
	}
	
	
	 public void clickOnServiceRating(WebDriver driver)
	 {
		   WebDriverWait wait=new WebDriverWait(driver,20);
			
		   
		  try
		  {wait.until(ExpectedConditions.visibilityOf(hotelratingsradiobutton));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='qid12_bubbles']")));
		   
		   int x = hotelratingsradiobutton.getLocation().getX();
		   int y = hotelratingsradiobutton.getLocation().getY();
		   
		   JavascriptExecutor js=(JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy("+x+","+y+")");
			Actions act=new Actions(driver);
       
			act.moveToElement(serviceradiobutton,10, 0).perform();
			
			act.moveToElement(serviceradiobutton,20, 0).perform();
	        
			act.moveToElement(serviceradiobutton,30, 0).perform();
			
			act.moveToElement(serviceradiobutton,40, 0).perform();
			
	        act.moveToElement(serviceradiobutton,50,0).click().build().perform();
	        
	      }
		  catch(Exception e)
		  {
			  System.out.println("Hotel Rating section is not available");
		  }
		   
		 
	 }  
		
	 public void clickOnSubmitChkbox()
	 {
		 submitchkbox.click();
	 }

}
