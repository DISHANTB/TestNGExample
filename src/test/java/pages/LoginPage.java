package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(how=How.XPATH, using="/html/body/div[1]/app-login/div/div/div[2]/div[2]/div/div[1]/input")
	WebElement username;
	@FindBy(how=How.XPATH, using="/html/body/div[1]/app-login/div/div/div[2]/div[2]/div/div[2]/input")
	WebElement password;
	@FindBy(how=How.CLASS_NAME, using="mat-button-wrapper")
	WebElement SubmitButton;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public Homepage login(String usernametext, String passwordtext, WebDriver driver) {
		username.sendKeys(usernametext);
		password.sendKeys(passwordtext);
		SubmitButton.click();
		
		return new Homepage(driver);
	}
	
	
	
}
