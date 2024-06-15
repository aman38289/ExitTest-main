package tests;

import pages.HomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchFunctionality extends BaseTest{

	@Test(priority = 0, description = "Verify Test Search Functionality")
    public void testSearchFunctionality() {
		
		logger.info("verifySearchFunctionality Test Started...");

		// Start extent test
        extentReport.createTest("Verify SearchFunctionality", "Verify SearchFunctionality");
		
		//Initialize Homepage
		HomePage homePage = new HomePage(driver);
		
        // Open Flipkart website
		homePage.openHomePage("https://www.flipkart.com/");
        
        // Perform search
        homePage.search("mobile");

        // Verify search results
        String actualTitle = driver.getTitle();
        
        //System.out.println(pageTitle);
        String expectedTitle = "Mobile- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
        
        try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Mobile- Buy Products Online at Best Price in India is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Mobile- Buy Products Online at Best Price in India title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Mobile- Buy Products Online at Best Price in India page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "MobilePage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}
		
		logger.info("verifySearchFunctionalityTitle Test completed successfully");
        
                
    }
	
}
