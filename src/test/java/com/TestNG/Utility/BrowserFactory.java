package com.TestNG.Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public WebDriver getDriver(String BrowserName){
		WebDriver driver = null;
		if(BrowserName.toLowerCase().equals("chrome")){
			String systemPath = System.getProperty("user.dir");
			System.out.println(systemPath);
			System.setProperty("webdriver.chrome.driver",systemPath.trim()+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BrowserName.toLowerCase().equals("firefox")){
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
