package com.TestNG.SampleTestNG;

import org.testng.annotations.Test;

import com.TestNG.Utility.BrowserFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.*;
import pages.*;

public class firstScenario {
	//Scenation Description: Login in to application, adding item to the Cart and Reviewing Cart details.
	
	WebDriver driver = null;
  
	//Test Case - Scenario1
	@Test(dataProvider = "testData")
	public void Scenario1(String Username, String Password){
	  
		System.out.println("Scenario1 Started ======");
	  
	  
		//Navigating to URL
		driver.get("http://automationpractice.com");
	  
		//Login in to application
		indexPage index = new indexPage(driver);
		authPage auth = index.clickOnSignIn(driver);
		auth.validateHeader();
		landingPage landingpage = auth.login(Username, Password, driver);
	  
		//Landing Page and Menu navigation
		landingpage.validateHeader();
		tshirtPage tshirtpage = landingpage.selectingTshirtpage(driver);
		
		//Adding T-Shirt to the cart
		tshirtpage.addTShirtToCart(driver);
	  
		//Validating Cart Details
		tshirtpage.validateCartDetails(driver);
	}
  
	@BeforeMethod
  	public void beforeMethod() {
	  System.out.println("Before Method ---");
	  
	  //Creating driver object from BrowserFactory class
	  BrowserFactory bf = new BrowserFactory();
	  driver = bf.getDriver("Chrome");
	  driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
	  System.out.println("After Method ---");
	  
	//closing driver
	  driver.close();
	}

	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			new Object[] { "gtl_test@thegatewaycorp.com", "Gtl@123" },
		};
	}
  
	@BeforeClass
	public void beforeClass() {
	  System.out.println("Before Class ---");
	}

	@AfterClass
	public void afterClass() {
	  System.out.println("After Class ---");
	}

	@BeforeTest
	public void beforeTest() {
	  System.out.println("Before Test ---");
	  
	}

	@AfterTest
	public void afterTest() {
	  System.out.println("After Test ---");
	  
	}

	@BeforeSuite
	public void beforeSuite() {
	  System.out.println("Before Suite ---");
	}

	@AfterSuite
    public void afterSuite() {
	  System.out.println("After Suite ---");
    }

}
