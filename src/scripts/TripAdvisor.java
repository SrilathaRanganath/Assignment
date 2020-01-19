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
			
			Set<String> tabs = driver.getWindowHandles();
			ArrayList<String> atabs = new ArrayList<String>(tabs);
			
			String wh = atabs.get(1);
		    Thread.sleep(2000);
			String windowTitle = driver.switchTo().window(wh).getTitle();
			System.out.println(windowTitle);
			if(windowTitle.contains("Review"))
			    {
					System.out.println(windowTitle+"Page is displayed");
					TripAdvisor_HotelReview_Page taHotelReviewPage = new TripAdvisor_HotelReview_Page(driver);
					taHotelReviewPage.clickOnWriteReviewButton(driver);
					
					Thread.sleep(5000);
					
					Set<String> childtabs = driver.getWindowHandles();
					ArrayList<String> childatabs = new ArrayList<String>(childtabs);
					System.out.println(childatabs);
					String childwh = childatabs.get(2);
				    Thread.sleep(2000);
					String childwindowTitle = driver.switchTo().window(childwh).getTitle();
					System.out.println(childwindowTitle);
					
							TripAdvisor_Ratings_Page taratings=new TripAdvisor_Ratings_Page(driver);
							taratings.selectRating(driver);
		 
					
					
				}
				
	
			
			/*Iterator<String> itr = tabs.iterator();
			
			String prnt = itr.next();
			String child = itr.next();
			driver.switchTo().window(child);
			
			Review r=new Review(driver);
			
			r.clickReview(driver);
			Thread.sleep(2000);
	        Set<String> tabs1 = driver.getWindowHandles();
			
			Iterator<String> itr1 = tabs1.iterator();
			
			String prnt1 = itr1.next();
			String child1 = itr1.next();
			String child2=itr1.next();
			driver.switchTo().window(child2);
			
			
			Rating R=new Rating(driver);
			
			R.selectRating(driver);
			R.reviewTitle("Place to visit");
			R.urReview("Good place");
			R.servicerating(driver);*/
		   
		}

	}



