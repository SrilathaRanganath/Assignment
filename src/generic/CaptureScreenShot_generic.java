package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot_generic {
		
	   //Generic Method to Capture ScreenShot
		public static void get_ScreenShot(WebDriver driver) throws IOException
		{
			String photo="./Screenshots/";
			Date dt=new Date();
			String date=dt.toString().replaceAll(":","-");
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			File fs= new File(photo+date+".jpeg");
			FileUtils.copyFile(src,fs);
		}

	}

