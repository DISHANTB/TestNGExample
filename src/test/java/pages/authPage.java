package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class authPage {
	@FindBy(how = How.CLASS_NAME, using = "page-heading")
	private WebElement AuthHeader;
	private WebElement email;
	private WebElement passwd;
	private WebElement SubmitLogin;
	
	public authPage(WebDriver driver) {
		//Initialing required page objects using PageFactory
		PageFactory.initElements(driver, this);
	}
	
	//Validating Header of the page
	public void validateHeader() {
		String headertext = AuthHeader.getText();
		if(headertext.toLowerCase().equals("authentication")) {
			System.out.println("Correct Header text is displayed on Authentication page");
		}else {
			System.out.println("Incorrect Header text is displayed on Authentication page");
		}
	}
	
	//Login Operation
	public landingPage login(String Username, String Password, WebDriver driver){
		email.sendKeys(Username);
		passwd.sendKeys(Password);
		SubmitLogin.click();
		return new landingPage(driver);
	}
}
