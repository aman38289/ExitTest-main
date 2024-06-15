package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyntraPage;

public class TestMyntraPage extends BaseTest {

	@Test(description = "Test Myntra page is Openable or not")
	public void VerifyMyntraPage() throws InterruptedException {
		
		logger.info("verifyMyntraPageTitle Test Started...");

		// Start extent test
        extentReport.createTest("Verify Flipkart Myntra Page Title", "Verify the title of Flipkart Myntra page");
        
		// initialize homepage
		HomePage homePage = new HomePage(driver);

		// Open homePage
		homePage.openHomePage("https://www.flipkart.com/");

		// initialize Myntra page
		MyntraPage myntraPage = new MyntraPage(driver);

		myntraPage.clickMyntraLink();
		
		// Get the title of the new tab
		String actualTitle = myntraPage.getNewTabTitle();
		String expectedTitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";

		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the Myntra page is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Myntra page title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Myntra page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "MyntraPage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		logger.info("verifyMyntraPageTitle Test completed successfully");

	}

}
