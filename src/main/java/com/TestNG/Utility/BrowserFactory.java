package com.TestNG.Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public WebDriver getDriver(String BrowserName){
		WebDriver driver = null;
		if(BrowserName.toLowerCase().equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C://Users//DISHANT//Downloads//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BrowserName.toLowerCase().equals("firefox")){
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
