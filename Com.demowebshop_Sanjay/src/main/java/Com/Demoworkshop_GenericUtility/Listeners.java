package Com.Demoworkshop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	

	
	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot) BaseTest.sDriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(frameWorkConstants.screenshotPath);
		
		try {
			
			FileHandler.copy(temp, dest);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
	}
	
	
}
