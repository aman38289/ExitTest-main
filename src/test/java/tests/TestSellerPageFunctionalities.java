package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SellerDashboard;
import pages.SellerPage;


public class TestSellerPageFunctionalities extends BaseTest{
	
	
	@Test(priority=0,description="Verify click of Become Seller Icon")
	public void VerifyBecomeSellerIcon() {
		
		logger.info("verifySellerPageTitle Test Started...");

		// Start extent test
        extentReport.createTest("Verify Flipkart Seller Page Title", "Verify the title of Flipkart Seller page");
		
		//HomePage initialization
		HomePage homePage = new HomePage(driver);
		
		//Open flipkart website
		homePage.openHomePage("https://www.flipkart.com/");
		
		//Seller Page Initialization
		SellerPage sellerPage = new SellerPage(driver);
		
		//click to Icon of Beacome seller
		sellerPage.sellerIconClick();
		
		String expectedTitle = driver.getTitle();
		String actualTitle = "Sell Online - Start Selling Online on Flipkart Seller Hub";
		
		 try {
	            
	        	// Assertion
	            Assert.assertEquals(actualTitle, expectedTitle, "Title of the seller page is incorrect");
	            // Log a pass status in extent report
	            extentReport.logPass("Seller page title is correct");
	        
	        } catch (AssertionError e) {
	           
	        	// Log a fail status and capture screenshot on assertion failure
	            extentReport.logFail("Seller page title is incorrect");
	            
	            try {
	                String screenshotPath =   captureScreenshot(driver, "SellerPage_Title_Failure");
	                extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	            // Re-throw the assertion error to mark the test as failed in TestNG
	            throw e;
	        }
	        
	        logger.info("verifySellerPageTitle Test completed successfully");
	}
	
	@Test(priority = 1,description="Verify Start selling page")
	public void VerifyStartSellingDashboard() {
		
		logger.info("verifySellerDashboardTitle Test Started...");

		// Start extent test
        extentReport.createTest("Verify Flipkart Seller Dashboard Title", "Verify the title of Flipkart Seller Dashboard.");
		
		//Seller Page Initialization
		SellerPage sellerPage = new SellerPage(driver);
		
		//click start selling button
		sellerPage.startSellingIconClick();
		
		String expectedTitle = driver.getTitle();
		String actualTitle = "Seller Dashboard";
		
		 try {
	            
	        	// Assertion
	            Assert.assertEquals(actualTitle, expectedTitle, "Title of the seller Dashboard is incorrect");
	            // Log a pass status in extent report
	            extentReport.logPass("Seller Dashboard title is correct");
	        
	        } catch (AssertionError e) {
	           
	        	// Log a fail status and capture screenshot on assertion failure
	            extentReport.logFail("Seller Dashboard title is incorrect");
	            
	            try {
	                String screenshotPath =   captureScreenshot(driver, "SellerDashboard_Title_Failure");
	                extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	            // Re-throw the assertion error to mark the test as failed in TestNG
	            throw e;
	        }
	        
	        logger.info("verifySellerDashboardTitle Test completed successfully");
	}
		
	@Test(priority= 2,description = "Verify Selling DashBoard Login WebElement")
	public void VerifySellingDashBoardLogin() {
		
		logger.info("VerifySellingDashBoardLogin Test Started...");
		
		//SellerdashBoard Initialization
		SellerDashboard sellerDashboard = new SellerDashboard(driver);
		
		 // Check for presence of username input fields, send Otp button.
        boolean usernameFieldDisplayed = sellerDashboard.isUsernamefield();
        boolean gstFieldDisplayed = sellerDashboard.isgstField();
        boolean emailfieldDisplayed = sellerDashboard.isemaiIdfield();

        try {
            
        	// Assertion
            Assert.assertTrue(usernameFieldDisplayed, "Username field is not displayed");
            Assert.assertTrue(gstFieldDisplayed, "gst Field is not displayed");
            Assert.assertTrue(emailfieldDisplayed,"email field not displayed");
            // Log a pass status in extent report
            extentReport.logPass("Seller Dashboard Login fields has required Fields");
        
        } catch (AssertionError e) {
           
        	// Log a fail status and capture screenshot on assertion failure
            extentReport.logFail("Seller Dashboard Login fields has no required Fields");
            
            try {
                String screenshotPath =   captureScreenshot(driver, "SellerDashboardLogin_Fields_Failure");
                extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // Re-throw the assertion error to mark the test as failed in TestNG
            throw e;
        }
        
        
        
        logger.info("VerifySellingDashBoardLogin Test completed successfully");
		
	}
	


}
