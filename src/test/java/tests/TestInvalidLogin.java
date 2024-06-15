package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ExcelReader;

import java.io.IOException;

import org.testng.Assert;

public class TestInvalidLogin extends BaseTest {

	LoginPage loginPage;

	@Test(description = "Verify Invalid Login")
	public void verifyInvalidLogin() throws InterruptedException {

		logger.info("verifyInvalidLogin Test Started...");

		// Start extent test
		extentReport.createTest("verify Invalid Login", "verify Invalid Login.");

		// Initialize LoginPage
		LoginPage loginPage = new LoginPage(driver);
		
		//initialize Excel reader
		ExcelReader excelReader = new ExcelReader();

		// Open Flipkart website
		loginPage.openHomePage("https://www.flipkart.com/");

		Thread.sleep(2000);
		loginPage.clickLoginLink();

		Thread.sleep(2000);
		loginPage.loginWithInvalidCredentials(excelReader.getPhoneNumber());

		Thread.sleep(3000);
		boolean isAlertDisplayed = loginPage.isSignUpPopupDisplayed();

		try {

			// Assertion
			Assert.assertTrue(isAlertDisplayed, "Alert is displayed");
			// Log a pass status in extent report
			extentReport.logPass("After entering not registered number alert popedup.");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("After entering not register number alert not popedup.");

			try {
				String screenshotPath = captureScreenshot(driver, "Alert_NotRegistered_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}

		logger.info("verify Invalid Login Test successfully");

	}

}
