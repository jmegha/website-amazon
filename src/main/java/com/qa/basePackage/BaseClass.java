package com.qa.basePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.qa.util.Config;

//Class contains all basic functions which are required to test all pages
public class BaseClass {
	
	//Instance of WebDriver
	protected static WebDriver driver;
	
	@BeforeSuite
	public void loadApplication() throws IOException {
		Config.loadProperties();
		launchBrowser(Config.getPropertyValue("browser"));
	}
	
	public static void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getPropertyValue("url"));
	}
}
