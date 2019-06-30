package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	@FindBy(how = How.NAME, using ="q")
	private WebElement searchBox;
	
	public GoogleSearchPage(WebDriver driver){
		//Initialing required page objects using PageFactory
		PageFactory.initElements(driver, this);
	}
	
	//Performing search after opening Google
	public searchResultPage performSearch(String searchKey, WebDriver driver){
		driver.get("http://www.google.com");
		searchBox.sendKeys(searchKey);
		searchBox.sendKeys(Keys.ENTER);		
		return new searchResultPage(driver);
		
	}
	
}
