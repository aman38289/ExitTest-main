package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ShopsyPage;

public class TestShopsyPage extends BaseTest {

	@Test(priority = 0, description = "Verify Shopsy page", enabled = true)
	public void VerifyShopsyPage() {

		logger.info("VerifyShopsyDashboardTitle Test Started...");

		// Start extent test
		extentReport.createTest("Verify Shopsy Seller Dashboard Title", "Verify the title of Shopsy Seller Dashboard.");

		// initialize Homepage
		HomePage homePage = new HomePage(driver);

		// open Shopsy tab
		homePage.openHomePage("https://seller.flipkart.com/shopsy");

		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		String expectedTitle = "Start Your Business on Shopsy With 0% Commission | Flipkart Seller Hub";

		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the seller Shopsy is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("shopsy Dashboard title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("shopsy Dashboard title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "shopsyDashboard_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		logger.info("verifyShopsyDashboardTitle Test completed successfully");

	}

	@Test(priority = 1, description = "Verify send Query Form")
	public void VerifyShopsyQueryFormElements() {
		// save logs
		logger.info("VerifyShopsyQueryFormElements Test Started...");

		// Start extent test
		extentReport.createTest("Verify Shopsy Query Form Elements",
				"Ensure all elements on the Query Form are present");

		// initialize Shopsy Page
		ShopsyPage shopsyPage = new ShopsyPage(driver);

		// Check for presence of Fields.
		boolean usernameFieldDisplayed = shopsyPage.isuserNameField();
		boolean userMobileEmailFieldDisplayed = shopsyPage.isuserMobileEmailField();
		boolean queryFormDisplayed = shopsyPage.isMessageField();

		try {

			// Assertion
			Assert.assertTrue(usernameFieldDisplayed, "Username field is not displayed");
			Assert.assertTrue(userMobileEmailFieldDisplayed, "Mobile Email Field is not displayed");
			Assert.assertTrue(queryFormDisplayed, "query Form is not displayed");
			// Log a pass status in extent report
			extentReport.logPass("shopsy Query form has all fields");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("shopsy Query form has not required fields");

			try {
				String screenshotPath = captureScreenshot(driver, "shopsyQueryForm_Fields_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		// Log a pass status in extent report
		extentReport.logPass("All elements are present on the login page");

		// save logs
		logger.info("VerifyShopsyQueryFormElements Test completed successfully");

	}

	@Test(priority = 2, description = "Verification of Sending Query using form")
	public void sendQueryForm() throws InterruptedException {

		// save logs
		logger.info("Verification of Send Query form Test Started...");

		// Start extent test
		extentReport.createTest("Verifying Query sending", "Ensure Query has been sent or not");

		// initialize Shopsy Page
		ShopsyPage shopsyPage = new ShopsyPage(driver);

		shopsyPage.enterMessage("abs");
		Thread.sleep(2000);
		shopsyPage.enterUserMobileOrEmail("9876543210");
		Thread.sleep(2000);
		shopsyPage.enterUserName("Name");
		Thread.sleep(2000);

		shopsyPage.submitButtonClick();
		Thread.sleep(2000);

		boolean isAlertVisible = shopsyPage.isAlertVisible();

		try {
			// Assertion
			Assert.assertTrue(isAlertVisible, "Query not sent");
			// Log a pass status in extent report
			extentReport.logPass("Query sent successfully");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Query not sent successfully");

			try {
				String screenshotPath = captureScreenshot(driver, "shopsyQuery_Sent_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		// save logs
		logger.info("VerifySendQuery Test completed successfully");

	}

}
