package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerPage {
	
    WebDriver driver;

    // Constructor
    public SellerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // Locators
    @FindBy(xpath = "//a[@title='Become a Seller' and text()='Become a Seller']")
    WebElement sellerIcon;
    
    @FindBy(xpath="//button[@data-testid='button' and text()='Start Selling']")
    WebElement startSellingIcon;
    
    
    public void sellerIconClick() {
    	sellerIcon.click();
    }
    
    public void startSellingIconClick() {
    	startSellingIcon.click();
    }

}
