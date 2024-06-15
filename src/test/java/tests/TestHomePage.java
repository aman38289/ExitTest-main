package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.ConfigReader;
import pages.HomePage;
import utils.BrowserFactory;
import utils.ExtentReportManager;

public class TestHomePage extends BaseTest{


	@Test(priority = 1, description = "Verify Flipkart Home Page Title")
	public void verifyHomePageTitle() {
		
		logger.info("verifyHomePageTitle Test Started...");

		// Start extent test
        extentReport.createTest("Verify Flipkart Home Page Title", "Verify the title of Flipkart home page");
        
        HomePage homePage = new HomePage(driver);
        
        // Open Flipkart website
        homePage.openHomePage("https://www.flipkart.com/");
        
        // Get the title of the page
        String actualTitle = homePage.getHomePageTitle();
        //System.out.println(actualTitle);
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        
        try {
            
        	// Assertion
            Assert.assertEquals(actualTitle, expectedTitle, "Title of the home page is incorrect");
            // Log a pass status in extent report
            extentReport.logPass("Home page title is correct");
        
        } catch (AssertionError e) {
           
        	// Log a fail status and capture screenshot on assertion failure
            extentReport.logFail("Home page title is incorrect");
            
            try {
                String screenshotPath =   captureScreenshot(driver, "HomePage_Title_Failure");
                extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // Re-throw the assertion error to mark the test as failed in TestNG
            throw e;
        }
        
        logger.info("verifyHomePageTitle Test completed successfully");
        
	}

	
	
	
	

}
