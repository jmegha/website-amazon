package com.qa.testPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pageObjects.HomePage;
import com.qa.basePackage.BaseClass;
import com.qa.util.Util;

public class HomeTestPage  extends BaseClass {
HomePage homePage; 
Util utilClass;
	
	@BeforeClass
	public void beforeMethod() {
	
	homePage = new HomePage(driver);
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Home page title not matched");
	}
	
	@Test(priority=2)
	public void testDeliverTo() throws InterruptedException, IOException{
		utilClass = new Util(driver);
		homePage.clickDeliveryTo(utilClass);
		
		String popupId= Util.switchToWindowPopup();
		//System.out.println("popupId_1:"+popupId);
		driver.switchTo().window(popupId);
		homePage.updateDeliveryPinCode(popupId);
		
		
	//	testUtil.switchToFrame();
		//Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
}
