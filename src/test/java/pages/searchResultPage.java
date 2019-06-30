package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class searchResultPage {
	
	
	public searchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Clicking on Specified URL
	public SpecifiedResultPage clickonspecifiedURL(WebDriver driver,Integer number){
		WebElement resultdiv = driver.findElement(By.id("rso"));
		List<WebElement> listofURLS = resultdiv.findElements(By.tagName("a"));
		WebElement specifiedURL = listofURLS.get(number);
		specifiedURL.click();
		return new SpecifiedResultPage(driver);
	}
	
	
}
