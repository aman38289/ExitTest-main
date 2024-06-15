package tests;


import org.testng.annotations.Test;
import org.testng.Assert;


import pages.LoginPage;

public class TestLoginPageElements extends BaseTest {

    @Test(priority = 0, description = "Verify Login Page Elements")
    public void verifyLoginPageElements() {
    	
    	// save logs 
    	logger.info("verifyLoginPageElements Test Started...");
    	
        // Start extent test
        extentReport.createTest("Verify Login Page Elements", "Ensure all elements on the login page are present");

        // Initialize LoginPage
        LoginPage loginPage = new LoginPage(driver);
        
        // Open Flipkart website
        loginPage.openHomePage("https://www.flipkart.com/");

        // Click on the "Login" link
        loginPage.clickLoginLink();

        // Check for presence of username input fields, send Otp button.
        boolean usernameFieldDisplayed = loginPage.isUsernameFieldDisplayed();
        boolean loginButtonDisplayed = loginPage.isLoginButtonDisplayed();

        // Assertion
        Assert.assertTrue(usernameFieldDisplayed, "Username field is not displayed");
        Assert.assertTrue(loginButtonDisplayed, "Login button is not displayed");
        
        // Log a pass status in extent report
        extentReport.logPass("All elements are present on the login page");
        
        //save logs
        logger.info("verifyLoginPageElements Test completed successfully");
    }

  
}
