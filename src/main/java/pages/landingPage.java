package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class landingPage {
	@FindBy(how = How.CLASS_NAME, using = "page-heading")
	private WebElement LandingHeader;
	@FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']//a[@title='Women']")
	private WebElement WomenMainMenu;
	
	public landingPage(WebDriver driver) {
		//Initialing required page objects using PageFactory
		PageFactory.initElements(driver, this);
	}
	
	//Validating Page Header
	public void validateHeader() {
		String headertext = LandingHeader.getText();
		if(headertext.toLowerCase().equals("my account")) {
			System.out.println("Correct Header text is displayed on Landing page");
		}else {
			System.out.println("Incorrect Header text is displayed on Landing page");
		}
	}
	
	//Selecting TShirt submenu from Women main menu
	public tshirtPage selectingTshirtpage(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(WomenMainMenu).build().perform();
		WebElement womenTShirtlink = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		womenTShirtlink.click();
		return new tshirtPage(driver);
	}
}
