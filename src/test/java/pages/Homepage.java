package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public Boolean takePageTitle(WebDriver driver) {
		
		WebDriverWait wait =  new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Summary of your walkins account')]")));
			
		WebElement WelcomeText = driver.findElement(By.xpath("//span[contains(text(),'Summary of your walkins account')]"));
		
		Boolean flag = WelcomeText.isDisplayed();
		
		//String pageTitle = driver.findElement(By.tagName("title")).getAttribute("innerText");
		return flag;
		
	}
	
	public SendSMSPage clickOnSendSMS(WebDriver driver) {
		List<WebElement> menu = driver.findElements(By.tagName("mat-expansion-panel"));
		menu.get(2).click();
		WebElement submenu = driver.findElement(By.linkText("Send SMS"));
		submenu.click();
		return new SendSMSPage(driver);
	}
	
	
}
