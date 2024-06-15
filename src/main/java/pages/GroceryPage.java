package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroceryPage{
	
    WebDriver driver;

    // Constructor
    public GroceryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    // Locators
    @FindBy(xpath = "//img[contains(@class, '_2puWtW') and contains(@class, '_3a3qyb') and @alt='Grocery']")
    WebElement groceryPageLink;
    
    @FindBy(xpath = "//input[@type='text' and @title='Enter pincode']")
    WebElement pincodeField;
    
    @FindBy(xpath="//input[@class='zDPmFV' and @type='text' and @title='Search grocery products' and @name='q' and @placeholder='Search grocery products']")
    WebElement searchField;
    
    
    public void clickGroceryPageLink() {
    	groceryPageLink.click();
    }
    
    public void enterPincode(String pincode) {
    	pincodeField.sendKeys(pincode+Keys.ENTER);
    }
    
    public void searchProduct(String product) {
    	searchField.sendKeys(product+Keys.ENTER);
    }

}
