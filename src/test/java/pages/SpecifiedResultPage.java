package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SpecifiedResultPage {
	public SpecifiedResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getting page title of the WebPage
	public String getPageTitle(WebDriver driver){
		return driver.getTitle().toString();
	}
}
