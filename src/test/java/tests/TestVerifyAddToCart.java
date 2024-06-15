package tests;

import pages.HomePage;
import pages.ProductPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVerifyAddToCart extends BaseTest {

	@Test(description = "Verify Add to Cart Functionality", priority = 0)
	public void verifyAddToCart() throws InterruptedException {

		logger.info("verifyAddToCart Test Started...");

		// Start extent test
		extentReport.createTest("verify AddToCart Product", "Verify AddToCart Product");

		HomePage homePage = new HomePage(driver);

		// Open Flipkart website
		homePage.openHomePage("https://www.flipkart.com/");

		// Search for a product
		homePage.search("Canon R100 Mirrorless Camera RF-S 18-45mm f/4.5-6.3 IS STM");

		// Click on the product
		ProductPage productPage = homePage.clickCamera();

		// Click on the "Add to Cart" button
		productPage.clickAddToCartButton();

		Thread.sleep(2000);
		// System.out.println("inside test:-"+driver.getTitle());
		// Get the title of the page
		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		String expectedTitle = "Shopping Cart | Flipkart.com";

		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the home page is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Verified Add to Cart Functionality");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Not Verified Add to Cart Functionality");

			try {
				String screenshotPath = captureScreenshot(driver, "AddToCart_Product_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		logger.info("Verified Add to Cart Functionality successfully");

	}

}
