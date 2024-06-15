package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class TestCartPage extends BaseTest{

	@Test(priority = 0,description="Verify Cart Page")
	public void VerifyCartPage() {
		
		logger.info("Verify Cart Page Title Test Started...");

		// Start extent test
		extentReport.createTest("Verify Cart Page Title", "Verify flipkart Cart Page");
		
		// initializing home page
		HomePage homePage = new HomePage(driver);

		// opening flipkartwebsite
		homePage.openHomePage("https://www.flipkart.com/");
		
		//initialize cart
		CartPage cartPage = new CartPage(driver);
		
		//Click Cart
		cartPage.ClickCartLink();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com";
		
		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the Cart Page is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Cart Page title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Cart Page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "CartPage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}
		
		logger.info("Verify Cart Page Title Test completed successfully");
	}

}
