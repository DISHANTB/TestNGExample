package pages;



import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class tshirtPage {
	@FindBy(how = How.XPATH, using = "//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement item1;
	
	public tshirtPage(WebDriver driver) {
		//Initialing required page objects using PageFactory
		PageFactory.initElements(driver, this);
	}
	
	//Adding Item to the cart
	public void addTShirtToCart(WebDriver driver){
		item1.click();
		driver.switchTo().frame(0);
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='exclusive']"));
		addToCartButton.click();
		driver.switchTo().defaultContent();
	}
	
	//Validating Cart Details
	public void validateCartDetails(WebDriver driver){
			
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart_product_title']")));
	
		WebElement successMessage = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2"));
		assertTrue(successMessage.getAttribute("innerHTML").contains("Product successfully added to your shopping cart"));
		
		WebElement productName = driver.findElement(By.xpath("//*[@id='layer_cart_product_title']"));
		assertTrue(productName.getAttribute("textContent").contains("Faded Short Sleeve T-shirts"));
		

		WebElement productQuantity = driver.findElement(By.xpath("//*[@id='layer_cart_product_quantity']"));
		assertTrue(productQuantity.getAttribute("textContent").contains("1"));
		
		
		WebElement productColor = driver.findElement(By.xpath("//*[@id='layer_cart_product_attributes']"));
		assertTrue(productColor.getAttribute("textContent").contains("Orange"));
		
		WebElement totalBill = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[3]/span"));
		assertTrue(totalBill.getAttribute("innerHTML").contains("18.51"));
		
		WebElement basePrice = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span"));
		assertTrue(basePrice.getAttribute("innerHTML").contains("16.51"));
		
	}
}
