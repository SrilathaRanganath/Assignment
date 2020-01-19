package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action_generic {
	
		Actions act;
		public Action_generic(WebDriver driver)
		{
			Actions act=new Actions(driver);
		}
		
		public void mouseHover(WebElement ele,int i)
		{
			act.moveToElement(ele,i,0).perform();
		}

}
