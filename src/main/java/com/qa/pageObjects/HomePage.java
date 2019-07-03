package com.qa.pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bsh.util.Util;

public class HomePage {
	 WebDriver driver = null;
	
	@FindBy(xpath="//div[@id='nav-global-location-slot']//a")
	WebElement deliveryTo;
	
	@FindBy(id="nav-link-shopall")
	WebElement shopByCategory;
	
	@FindBy(xpath="//a[contains(text(), \"Today's Deals\")]")
	WebElement todatsDeal;
	
	@FindBy(xpath="//a[contains(text(), \"Coupons\")]")
	WebElement coupons;
	
	@FindBy(xpath="//a[contains(text(), \"AmazonBasics\")]")
	WebElement amazonBasics;
	
	@FindBy(xpath="//a[contains(text(), \"Best Sellers\")]")
	WebElement bestSellers;
	
	@FindBy(xpath="//a[contains(text(), \"Gift Ideas\")]")
	WebElement giftIdeas;
	 
	@FindBy(xpath="//a[contains(text(), \"New Releases\")]")
	WebElement newReleases;
	
	@FindBy(xpath="//input[@type=\"submit\"][@aria-label=\"Sign in to see your addresses\"]")
	WebElement DeliverToSignIn;
	
	@FindBy(id="GLUXZipUpdateInput")
	WebElement DeliverToInput;
	
	@FindBy(xpath="//input[@type='submit'][@aria-labelledby='GLUXZipUpdate-announce']")
	WebElement DeliverToApply;
	@FindBy(xpath="//input[@type='submit'][@aria-labelledby='GLUXConfirmClose-announce']")
	//@FindBy(id="GLUXConfirmClose")
	WebElement DeliverToContinue;
	
	 public HomePage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	 
	 public String verifyHomePageTitle(){
			return driver.getTitle();
	}
	 public void handlePopup(){
		 deliveryTo.click();
	 }
	 
	 public void clickDeliveryTo(com.qa.util.Util utilClass2) throws IOException{
		 deliveryTo.click();
		 utilClass2.takeScreenshotAtEndOfTest("DeiverToPopup");
		 //takeScreenshotAtEndOfTest("DeiverToPopup");
	 }
	 
	 public TodaysDealPage clickOnTodaysDealLink(){
		 todatsDeal.click();
		 return new TodaysDealPage();
	 }
	 
	 public TodaysDealPage clickOnCouponLink(){
		 todatsDeal.click();
		 return new TodaysDealPage();
	 }
	 
	 public BestSellers bestSellersLink(){
		 todatsDeal.click();
		 return new BestSellers();
	 }
	 
	 public GiftIdeas giftIdeasLink(){
		 todatsDeal.click();
		 return new GiftIdeas();
	 }
	 
	 public NewReleases newReleasesLink(){
		 todatsDeal.click();
		 return new NewReleases();
	 }

	public void updateDeliveryPinCode(String popupId) throws InterruptedException {
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			Assert.assertEquals(DeliverToSignIn.isDisplayed(), true);
		} catch (AssertionError e) {
		    System.out.println("Already loggedin");
		    throw e;
		}
		System.out.println("User is not loggedin!");
		
	

		DeliverToInput.sendKeys("474009");
		DeliverToApply.click();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("no of iframes: "+size);
		//driver.switchTo().window(popupId);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='a-popover-footer']//input[@type='submit'][@aria-labelledby='GLUXConfirmClose-announce']")))).click();
		
		
		
		
	}
}
