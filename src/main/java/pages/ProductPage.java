package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {
	private WebDriver driver;

	// Locators
	private By productNameLocator = By.xpath("//span[contains(text(), 'Apple iPhone 15 Plus (Black, 256 GB)')]");
	private By productPriceLocator = By.xpath("//div[@class = 'Nx9bqj _4b5DiR' and contains(text(), '₹91,999')]");

	// Constructor
	public ProductPage(WebDriver webDriver) {
		this.driver = webDriver;
	}

	// Method to get product name
	public String getProductName() {
		return driver.findElement(productNameLocator).getText();
	}

	// Method to get product price
	public String getProductPrice() {
		return driver.findElement(productPriceLocator).getText();
	}

	// Click on the "Add to Cart" button
	public void clickAddToCartButton() {
		WebElement addToCartButton = driver.findElement(By.xpath("//li[@class='col col-6-12']//button[@class='QqFHMw vslbG+ In9uk2']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(addToCartButton).click().perform();
		
	}

	public String isProductAddedToCart() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

}