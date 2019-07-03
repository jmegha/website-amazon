package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Config {
	private static Properties prop = new Properties();
	
	public static void loadProperties() throws IOException{
		FileInputStream iop=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
		prop.load(iop);
	}
	
	public static String getPropertyValue(String key){
		return prop.getProperty(key);
	} 
	
}
