package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TermsAndConditionPage;

public class TestTermsAndCondition extends BaseTest {

	@Test(priority = 0, description = "Verify TermsAndCondition")
	public void testTermsAndConditions() throws InterruptedException {
		
		// save logs 
    	logger.info("verifyTermsAndConditions Test Started...");
    	
        // Start extent test
        extentReport.createTest("Verify TermsAndConditions page", "Ensure TermsAndConditions are present");


		// HomePage Initialization
		HomePage homePage = new HomePage(driver);

		// Open flipKart
		homePage.openHomePage("https://www.flipkart.com/");

		// Initialize Terms And Conditions Pages
		TermsAndConditionPage termsAndConditionPage = new TermsAndConditionPage(driver);

		// click terms and conditions
		termsAndConditionPage.ClickTermsAndConditionsLink();

		Thread.sleep(2000);

		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		String expectedTitle = "Terms Store Online - Buy Terms Online at Best Price in India | Flipkart.com";

		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the TermsAndConditions is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("TermsAndConditions page title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("TermsAndConditions page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "TermsAndConditions_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}
		
		logger.info("verifyTermsAndConditionsPageTitle Test completed successfully");

	}

}
