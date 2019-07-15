package pages;

import static org.testng.Assert.assertTrue;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SendSMSPage {
		
	public SendSMSPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectSMSType(WebDriver driver, String type) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(type.toLowerCase().equals("picture")) {
			WebElement radiobutton = driver.findElement(By.id("mat-radio-3-input"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click()",radiobutton);
			WebElement selectPictureButton = driver.findElement(By.xpath("//span[text()=' Select picture']"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", selectPictureButton);
		}else if(type.toLowerCase().equals("simple")) {
			
		}
		
	}
	
	public void selectPicture(WebDriver driver) {
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys("C:\\Users\\DISHANT\\Desktop\\Sample.png");
		System.out.println(fileInput.getText());
		WebElement Preview = driver.findElement(By.xpath("//img[@class='send-sms-img ng-star-inserted']"));
		assertTrue(Preview.isDisplayed());
		
	}


	public void validateAndClickSelectButton(WebDriver driver) {
		WebElement submitButton = driver.findElement(By.xpath("//span[text()='select']"));
		assertTrue(submitButton.isEnabled());
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", submitButton);
		WebElement editButton = driver.findElement(By.xpath("//span[text()=' Edit picture']"));
		assertTrue(editButton.isDisplayed());
		
	}
	
	public void selectManualPOST(WebDriver driver) {
		WebElement manual = driver.findElement(By.xpath("//mat-button-toggle[@value=2]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", manual);
	
	}
	
	public void enterNumber(WebDriver driver, String number) {
		List<WebElement> numberHolders = driver.findElements(By.xpath("//textarea"));
		numberHolders.get(0).sendKeys(number);
		WebElement addNumberButton = driver.findElement(By.xpath("//button[text()='ADD NUMBERS']"));
		assertTrue(addNumberButton.isEnabled());
		addNumberButton.click();
	}
	
	public void selectTemplate(WebDriver driver, String template) {
		List<WebElement> dropdowns = driver.findElements(By.xpath("//select"));
		Select templateDropdown = new Select(dropdowns.get(2));
		templateDropdown.selectByVisibleText(template);
	}


	public void enterSMSText(WebDriver driver, String message) {
		List<WebElement> textareas = driver.findElements(By.xpath("//textarea"));
		textareas.get(3).sendKeys(message);
	}


	public void sendSMS(WebDriver driver) {
		WebElement sendNowButton = driver.findElement(By.xpath("//span[text()='Send Now']"));
		sendNowButton.click();
		
	}


	public SMSReport confirmingPopup(WebDriver driver, String option) {
		if(option.toLowerCase().equals("no")) {
			WebElement noButton = driver.findElement(By.xpath("//button[text()='No']"));
			noButton.click();
		}else if(option.toLowerCase().equals("yes")) {
			WebElement yesButton = driver.findElement(By.xpath("//button[text()='Yes']"));
			yesButton.click();
		}
		return new SMSReport(driver);
	}
			
		
}
	

