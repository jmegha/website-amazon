package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class Util {
	 static WebDriver driver = null;
	 public static long PAGE_LOAD_TIMEOUT = 20;
	 public static long IMPLICIT_WAIT = 20;
	 //static JavascriptExecutor js;
	 public Util(){
			//driver = webDriver;
			//PageFactory.initElements(driver, this);
		}
	 public Util(WebDriver webDriver){
			driver = webDriver;
			//PageFactory.initElements(driver, this);
		}
	public static String switchToWindowPopup(){
		String Popup= driver.getWindowHandle();
		//driver.switchTo().window(Popup);
		return Popup;
	} 
	

	public void takeScreenshotAtEndOfTest(String screenShotName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File fileName=new File(currentDir + "/screenshots/"+screenShotName+"_" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(scrFile, fileName);
		Reporter.log("<br><img src='"+fileName+"' height='400' width='400'/><br/>");
	}
	
	
}
