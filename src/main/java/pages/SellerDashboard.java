package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

////input[@data-testid='test-input' and @placeholder='Enter Mobile Number']
public class SellerDashboard {
	
	WebDriver driver;

    // Constructor
    public SellerDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//input[@data-testid='test-input' and @placeholder='Enter Mobile Number']")
    WebElement username;
    
    @FindBy(xpath="//input[@data-testid='test-input' and @placeholder='Enter Email ID']")
    WebElement emailId;
    
    @FindBy(xpath="//input[@data-testid='test-input' and @placeholder='Enter GSTIN']")
    WebElement gstInfield;
    
    
    public boolean isUsernamefield() {
    	return username.isDisplayed();
    }
    
    public boolean isemaiIdfield() {
    	return emailId.isDisplayed();
    }
    
    public boolean isgstField() {
    	return gstInfield.isDisplayed();
    }

}
