package com.DemoWebShop_TestScript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Com.DemoWebShop_POM.AddressesPage;
import Com.Demoworkshop_GenericUtility.BaseTest;

public class TC_002_VerifyUserIsAbleZToDeleteAddressorNot_Test  extends BaseTest

{
	@Test
	public void deleteAddress() throws InterruptedException {
		
		Thread.sleep(2000);
		webdriverutility.javaScriptScrollToElement(driver, homepage.getAddressesBtn());
		homepage.getAddressesBtn().click();
		
		AddressesPage addresspage = new AddressesPage(driver);
		addresspage.getDeleteBtn().click();
		
		
		Thread.sleep(2000);
		webdriverutility.Alertaccept(driver);
	}

}
