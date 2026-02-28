package Com.Demoworkshop_GenericUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	
	public String dateAndTime() 
	{
		
		String value = LocalDateTime.now().toString().replace(".", "").replace(":","").replace("-", "");
		return value;
		
	}

}
