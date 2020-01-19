package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Property implements Constant_Variables{
		
		@Test
		public static String get_Property(String path,String key) throws FileNotFoundException, IOException
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			
			String data=p.getProperty(key);
			return data;
		}

}


