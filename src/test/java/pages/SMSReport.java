package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SMSReport {

	public SMSReport(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean validateRecentSMS(WebDriver driver, String enteredNumber) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement table = driver.findElement(By.xpath("//table"));
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Picture SMS ']")));
		
		List<WebElement> Rows = table.findElements(By.tagName("tr"));	
		List<WebElement> columns = Rows.get(1).findElements(By.tagName("td"));
		if((columns.get(2).getAttribute("innerHTML").contains(enteredNumber))){
			return true;
		}else {
			return false;
		}
	}
}
