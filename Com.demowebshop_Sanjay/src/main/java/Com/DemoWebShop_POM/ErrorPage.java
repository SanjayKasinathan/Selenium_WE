package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {
	
	
	public  ErrorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id ="details-button")
	private WebElement advanced;
	
	@FindBy(id="proceed-link")
	private WebElement proceedLink;
	
	public WebElement getAdvanced() {
		
		return advanced;
	}
	
	public WebElement getProceedLink()
	{
		return proceedLink;
	}
	

}
