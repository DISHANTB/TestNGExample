package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class indexPage{
	
	@FindBy(how = How.CLASS_NAME, using = "login")
	WebElement login;
	public indexPage(WebDriver driver) {
		//Initialing required page objects using PageFactory
		PageFactory.initElements(driver, this);
	}
	
	//Clicking on Sign in link
	public authPage clickOnSignIn(WebDriver driver){
		if(login != null) {
			login.click();
		}
		return new authPage(driver);
	}
	
}
