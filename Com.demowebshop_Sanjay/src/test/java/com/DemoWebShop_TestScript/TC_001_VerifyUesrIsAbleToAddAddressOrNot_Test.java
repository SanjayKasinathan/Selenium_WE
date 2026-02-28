package com.DemoWebShop_TestScript;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_POM.AddNewAddressPage;
import Com.DemoWebShop_POM.AddressesPage;
import Com.Demoworkshop_GenericUtility.BaseTest;


public class TC_001_VerifyUesrIsAbleToAddAddressOrNot_Test  extends BaseTest
{
	
	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Thread.sleep(2000);
		
		webdriverutility.javaScriptScrollToElement(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
		
		AddressesPage addressPage = new AddressesPage(driver);
		Thread.sleep(2000);
		webdriverutility.javaScriptScrollToElement(driver, addressPage.getAddNewBtn());
		addressPage.getAddNewBtn().click();
		
		AddNewAddressPage newAddressPage = new AddNewAddressPage(driver);
		newAddressPage.getFirstNameTextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 0));
		newAddressPage.getLastNameTextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 1));
		newAddressPage.getEmailTextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 2));
		
		webdriverutility.selectByVisibleText(newAddressPage.getCountryDD(), fileutility.readDataFromExcelfile("Sheet1", 1, 3));
		
		newAddressPage.getCityTextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 4));
		newAddressPage.getAddress1TextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 5));
		newAddressPage.getZipCodeTextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 6));
		newAddressPage.getPhoneNumberTextField().sendKeys(fileutility.readDataFromExcelfile("Sheet1", 1, 7));
		newAddressPage.getSaveBtn().click();
		
		Thread.sleep(2000);
		webdriverutility.webPageScreenshot(driver);
		
		
	}
	

}
