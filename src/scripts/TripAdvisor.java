package scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import generic.Property;
import pom.TripAdvisor_Home_Page;
import pom.TripAdvisor_HotelReview_Page;
import pom.TripAdvisor_Ratings_Page;
import pom.TripAdvisor_SearchResult_Page;

public class TripAdvisor extends generic.Generic_Methods  implements generic.Constant_Variables{
	
	
		@Test
		public void ratingsForClubMahindra() throws InterruptedException, FileNotFoundException, IOException
		{
	        
			//Launch TripAdvisor Application 
			String tripadvisorurl=Property.get_Property(PropertyFile_PATH, "tripadvisorurl");
			System.out.println(tripadvisorurl);
			driver.get(tripadvisorurl);
		  	driver.manage().window().maximize();
		    //Fetching implicit wait time from the Property file using Property class
			String implicitwait=Property.get_Property(PropertyFile_PATH, "implicitwait");
			Long iw=Long.parseLong(implicitwait);
			
		  	driver.manage().timeouts().implicitlyWait(iw, TimeUnit.SECONDS);
	       
	       
		  	//Search for ClubMahindra
		  	TripAdvisor_Home_Page tahomepage = new TripAdvisor_Home_Page(driver);
		  	tahomepage.clickOnSearchIcon();
		  	tahomepage.enterHotelName(driver,"Club Mahindra");
		  	tahomepage.clickOnSearchButton();
		  	
		  	//Selecting first hotel of the result
		  	TripAdvisor_SearchResult_Page tasearchpage = new TripAdvisor_SearchResult_Page(driver);
		  	tasearchpage.clickOnFirstResult();
		  	System.out.println("clicked on first result");
		  	Thread.sleep(5000);
			
			Set<String> alltabs = driver.getWindowHandles();
			ArrayList<String> arraytabs = new ArrayList<String>(alltabs);
			String hotelreviewtab = arraytabs.get(1);
			String hreviewtabtitle = driver.switchTo().window(hotelreviewtab).getTitle();
			
			
			TripAdvisor_HotelReview_Page taHotelReviewPage = new TripAdvisor_HotelReview_Page(driver);
			taHotelReviewPage.clickOnWriteReviewButton(driver);
					
			Thread.sleep(5000);
					
			Set<String> totaltabs = driver.getWindowHandles();
			ArrayList<String> arraytotaltabs = new ArrayList<String>(totaltabs);
			String ratingtab = arraytotaltabs.get(2);
			String ratingtabtitle = driver.switchTo().window(ratingtab).getTitle();
					
			TripAdvisor_Ratings_Page taratings=new TripAdvisor_Ratings_Page(driver);
			taratings.selectRating(driver);
			taratings.enterReviewTitle("Some Title");
			taratings.enterReview("Some Review");
			taratings.clickOnServiceRating(driver);
					
					
		}
				
 }




