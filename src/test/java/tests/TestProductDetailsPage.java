package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class TestProductDetailsPage extends BaseTest {

	@Test(description = "Verify Product Details Page")
	public void verifyProductDetailsPage() throws InterruptedException {
		
		logger.info("verifyProductDetails Test Started...");

		// Start extent test
        extentReport.createTest("verify Product Details Product", "verify Product Details Product");
		
		// Create HomePage object
		HomePage homePage = new HomePage(driver);

		// Open Flipkart website
		homePage.openHomePage("https://www.flipkart.com/");

		// Search for a product
		homePage.search("Apple iPhone 15 Plus (Black, 256 GB)"); // Replace "Your Product Name" with the actual product

		String actualTitle = driver.getTitle();
		String expectedTitle = "Apple IPhone 15 Plus (Black, 256 GB)- Buy Products Online at Best Price in India - All Categories | Flipkart.com";

		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Apple IPhone 15 Plus (Black, 256 GB) is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Apple IPhone 15 Plus (Black, 256 GB) title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Apple IPhone 15 Plus (Black, 256 GB) page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "ProductPage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}
		
		logger.info("verifyProductDetailsPageTitle Test completed successfully");
		
		
	}

}
