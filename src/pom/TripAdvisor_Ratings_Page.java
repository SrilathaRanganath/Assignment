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
	
	
	
	//Selecting Fifth Rating
	public void selectRating(WebDriver driver)
	{
		Actions act=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ratingradiobutton));
		
		for(int i=10;i<50;i=i+10)
		{
		  act.moveToElement(ratingradiobutton,i,0).perform();
		}
		act.moveToElement(ratingradiobutton,50,0).click().build().perform();

	}
	
	//Enter the Review title 
	public void enterReviewTitle(String text)
	{
		titletextbox.sendKeys(text);
	}
	
	//Enter the Review
	public void enterReview(String text)
	{
		reviewtextbox.sendKeys(text);
	}
	
	 //Select Service Rating
	 public void clickOnServiceRating(WebDriver driver)
	 {
		   Actions act=new Actions(driver);
		   WebDriverWait wait=new WebDriverWait(driver,20);
		 try
		  {
			  wait.until(ExpectedConditions.visibilityOf(hotelratingsradiobutton));
			  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='qid12_bubbles']")));
			   
			   int x = hotelratingsradiobutton.getLocation().getX();
			   int y = hotelratingsradiobutton.getLocation().getY();
			   
			   JavascriptExecutor js=(JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy("+x+","+y+")");  
		   
			   for(int i=10;i<50;i=i+10)
				{
				  act.moveToElement(hotelratingsradiobutton,i,0).perform();
				}
				act.moveToElement(hotelratingsradiobutton,50,0).click().build().perform();			
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
