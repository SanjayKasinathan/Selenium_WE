package Com.Demoworkshop_GenericUtility;

public interface frameWorkConstants {
	
	
	JavaUtility javaUtlity = new JavaUtility();
	
	String propertyPath = "./src/test/resources/Data/data.properties";
	
	String execlPath ="./src/test/resources/Data/Test Data.xlsx";
	
	String screenshotPath ="./screenShot/"+ javaUtlity.dateAndTime()+".png";
	
	String reportsPath ="./reports/"+javaUtlity.dateAndTime()+".html";

}
