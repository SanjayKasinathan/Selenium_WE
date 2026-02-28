package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
	
	public AddressesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Add new']")
	private WebElement addNewBtn;

	@FindBy(xpath = "(//input[@value='Delete'])[1]")
	private WebElement deleteBtn;

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

}
