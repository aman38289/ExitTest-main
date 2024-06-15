package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//a[@title = 'Login' and @href='/account/login?ret=/']")
    WebElement loginLink;

    @FindBy(xpath = "//span[contains(text(),'Enter Email/Mobile number')]")
    WebElement usernameField;
    
    @FindBy(xpath ="//input[@type='text' and @class='r4vIwl BV+Dqf']")
    WebElement phonenumberField;

    @FindBy(xpath = "//button[contains(text(),'Request OTP')]")
    WebElement loginButton;
    
    @FindBy(xpath = "//div[contains(text(),'You are not registered with us. Please sign up.')]")
    WebElement signUpPopup;

    // Methods
    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public boolean isUsernameFieldDisplayed() {
        return usernameField.isDisplayed();
    }
    
    public void enterUsername(String username) {
    	phonenumberField.sendKeys(username);
    }
    
    
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
    
    // Method to check if the sign-up popup is displayed
    public boolean isSignUpPopupDisplayed() {
        return signUpPopup.isDisplayed();
    }
    
    // Method to perform login with invalid credentials
    public void loginWithInvalidCredentials(String username) {
    	phonenumberField.sendKeys(username);;
    	loginButton.click();
    }
}
