package com.TestNG.SampleTestNG;



import org.openqa.selenium.WebDriver;
import com.TestNG.Utility.BrowserFactory;

import pages.Homepage;
import pages.LoginPage;
import pages.SMSReport;
import pages.SendSMSPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;



public class walksinScenario {
	public WebDriver driver = null;
	
	@Test(dataProvider = "testdata", groups = {"Scenario1"})
	public void ScenarioOne(String username, String password) {
		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://dev.trackwalkins.com/");
		
		LoginPage loginpage = new LoginPage(driver);
		Homepage homepage = loginpage.login(username, password, driver);
		Boolean pageTitle = homepage.takePageTitle(driver);
		assert(pageTitle);
	}
	
	@Test(dataProvider = "testdata", groups = {"Scenario2"})
	public void loginScenario(String username, String password) {
		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://dev.trackwalkins.com/");
		
		LoginPage loginpage = new LoginPage(driver);
		Homepage homepage = loginpage.login(username, password, driver);
		Boolean pageTitle = homepage.takePageTitle(driver);
		assert(pageTitle);
		SendSMSPage smspage = homepage.clickOnSendSMS(driver);
		smspage.selectSMSType(driver, "Picture");
		smspage.selectPicture(driver);
		smspage.validateAndClickSelectButton(driver);
		smspage.selectManualPOST(driver);
		smspage.enterNumber(driver, "9975101904");
		smspage.selectTemplate(driver, "test");
		smspage.enterSMSText(driver, "9975101904");
		smspage.sendSMS(driver);
		SMSReport smsreport = smspage.confirmingPopup(driver,"No");
		Boolean result = smsreport.validateRecentSMS(driver, "9975101904");
		assertTrue(result);
	}
	
	@DataProvider(name = "testdata")
	public Object[][] testdata(){
		Object[][] data = {{"demo@mailinator.com","walkins@123"}};
		return data;
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}
