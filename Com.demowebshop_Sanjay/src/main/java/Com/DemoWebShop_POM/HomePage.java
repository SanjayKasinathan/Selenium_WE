package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Log out")
	private WebElement logOutBtn;

	@FindBy(partialLinkText = "Addresses")
	private WebElement addressesBtn;

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getAddressesBtn() {
		return addressesBtn;
	}

}
