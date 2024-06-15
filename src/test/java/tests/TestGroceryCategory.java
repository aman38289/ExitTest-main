package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GroceryPage;
import pages.HomePage;
import utils.ExcelReader;

public class TestGroceryCategory extends BaseTest {

	@Test(priority = 0, description = "Verify Grocery Category")
	public void VerifyGroceryCategory() {

		logger.info("VerifyGroceryCategoryTitle Test Started...");

		// Start extent test
		extentReport.createTest("Verify Grocery Category Title", "Verify the title of Flipkart Grocery page");

		// initializing home page
		HomePage homePage = new HomePage(driver);

		// opening flipkartwebsite
		homePage.openHomePage("https://www.flipkart.com/");

		// initialize GroceryPage
		GroceryPage groceryPage = new GroceryPage(driver);

		// click groceryIcon
		groceryPage.clickGroceryPageLink();

		// Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com";

		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the grocery page is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Grocery page title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Grocery page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "GroceryPage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		logger.info("verifyGroceryPageTitle Test completed successfully");

	}

	@Test(priority = 1, description = "Verify Pincode Enter")
	public void VerifyPincodeEnter() throws InterruptedException {

		// initialize GroceryPage
		GroceryPage groceryPage = new GroceryPage(driver);

		// Enter pincode
		groceryPage.enterPincode("208002");

	}

	@Test(priority = 2, description = "Verify Searching of Product in Grocery")
	public void VerifySearchProduct() throws InterruptedException {
		
		
		logger.info("VerifySearchProductTitle Test Started...");

		// Start extent test
		extentReport.createTest("Verify Search Product Title", "Verify the title of Search Product page");
	

		// initialize GroceryPage
		GroceryPage groceryPage = new GroceryPage(driver);
		
		Thread.sleep(2000);
		// search Product
		ExcelReader excelReader = new ExcelReader();
		groceryPage.searchProduct(excelReader.getGroceryProduct());
		
		Thread.sleep(2000);
		//System.out.println(driver.getTitle());
		String actualTitle = driver.getTitle();
		String expectedTitle ="Atta- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		
		
		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the Atta page is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Atta page title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Atta page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "AttaPage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}
		
		logger.info("VerifySearchProductTitle Test completed successfully");

	}

}
