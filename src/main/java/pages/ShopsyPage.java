package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopsyPage {

	WebDriver driver;

	// Constructor
	public ShopsyPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
    // Locators
    @FindBy(xpath = "//input[@data-testid='test-input' and @type='text' and @placeholder='Enter Full Name' and @label='Enter Full Name' and @name='fullName']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@data-testid='test-input' and @type='text' and @placeholder='Enter Mobile Number / Email ID' and @label='Enter Mobile Number / Email ID' and @name='contactInformation']")
    WebElement userMobileEmailField;
    
    @FindBy(xpath ="//input[@data-testid='test-input' and @type='text' and @placeholder='Type Your Messsage' and @label='Type Your Messsage' and @name='message']")
    WebElement messageField;
    
    @FindBy(xpath="//button[@data-testid='button' and text()='Send Query']")
    WebElement submitButton;
    
    @FindBy(xpath="//div[@role='alert']/div[contains(text(), 'Form Submitted Successfully.')]")
    WebElement alert;
	
    
    public boolean isMessageField() {
    	return messageField.isDisplayed();
    }
	
    public boolean isuserMobileEmailField() {
    	return userMobileEmailField.isDisplayed();
    }
    
    public boolean isuserNameField() {
    	return userNameField.isDisplayed();
    }
    
    public void enterUserName(String userName) {
    	userNameField.sendKeys(userName);
    }
    
    public void enterMessage(String msg) {
    	messageField.sendKeys(msg);
    }
    
    public void enterUserMobileOrEmail(String input) {
    	userMobileEmailField.sendKeys(input);
    }
    
    public void submitButtonClick() {
    	submitButton.click();
    }
    
    public boolean isAlertVisible() {
    	return alert.isDisplayed();
    }
    
    

}
