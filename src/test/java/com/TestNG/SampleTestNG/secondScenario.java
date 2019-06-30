package com.TestNG.SampleTestNG;


import org.testng.annotations.Test;

import com.TestNG.Utility.BrowserFactory;

import pages.GoogleSearchPage;
import pages.SpecifiedResultPage;
import pages.searchResultPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class secondScenario {	
	//Scenario Description: Launching google. Searching with First Name and Last Name and clicking on 3rd link.
	WebDriver driver =  null;
	
	@Test(dataProvider = "testData")
	public void Scenario2(String FirstName, String LastName, String ExpectedpageTitle) {
		System.out.println("Scenario2 Started ======");
	    
		//Launching Google
		GoogleSearchPage searchpage = new GoogleSearchPage(driver);
		
		//performing search
		searchResultPage results = searchpage.performSearch(FirstName + " " + LastName, driver);
		
		//Navigating to specific result
		SpecifiedResultPage resultpage = results.clickonspecifiedURL(driver, 2);
		assert(resultpage.getPageTitle(driver).contains(ExpectedpageTitle));
	  
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BoforeMethod ---");
		//Creating driver object from BrowserFactory class
		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver("Chrome");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod ---");
		//Closing the driver
		driver.close();
	}


	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
		new Object[] { "Dishant","Bhadresha","Dishant Bhadresha" },
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
