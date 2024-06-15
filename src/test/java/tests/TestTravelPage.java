package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TravelPage;

public class TestTravelPage extends BaseTest{
	
	@Test(priority = 0,description="Verify Travel Page")
	public void VerifyCartPage() throws InterruptedException {
		
		logger.info("Verify Travel Page Title Test Started...");

		// Start extent test
		extentReport.createTest("Verify Travel Page Title", "Verify flipkart Travel Page");
		
		// initializing home page
		HomePage homePage = new HomePage(driver);

		// opening flipkartwebsite
		homePage.openHomePage("https://www.flipkart.com/");
		
		//initialize travel page
		TravelPage travelPage = new TravelPage(driver);
		
		//Click Cart
		travelPage.ClickTravelIcon();
		
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		//System.out.println(driver.getTitle());
		String expectedTitle = "Flight Booking | Book Flight Tickets at Lowest Airfare on Flipkart.com";
		
		try {

			// Assertion
			Assert.assertEquals(actualTitle, expectedTitle, "Title of the Travel Page is incorrect");
			// Log a pass status in extent report
			extentReport.logPass("Travel Page title is correct");

		} catch (AssertionError e) {

			// Log a fail status and capture screenshot on assertion failure
			extentReport.logFail("Travel Page title is incorrect");

			try {
				String screenshotPath = captureScreenshot(driver, "TravelPage_Title_Failure");
				extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// Re-throw the assertion error to mark the test as failed in TestNG
			throw e;
		}
		
		logger.info("Verify Travel Page Title Test completed successfully");
	}
	
	
	  @Test(priority = 1, description = "Verify Flight Page Elements")
	    public void verifyFlightPageElements() {
	    	
	    	// save logs 
	    	logger.info("verifyFlightPage Elements Test Started...");
	    	
	        // Start extent test
	        extentReport.createTest("Verify Flight Page Elements", "Ensure all elements on the Flight page are present");

			//initialize travel page
			TravelPage travelPage = new TravelPage(driver);

	        // Check for presence of from, To, fromDate,toDate, travellerAndClass,Search button.
	        boolean fromFieldDisplayed = travelPage.IsfromDateField();
	        boolean toFieldDisplayed = travelPage.IsToField();
	        boolean toDateDisplayed = travelPage.IstoDateField();
	        boolean fromDateDisplayed = travelPage.IsfromDateField();
	        boolean travellerAndClassFieldDisplayed = travelPage.IstravellerAndClassField();
	        boolean searchButtonDisplayed = travelPage.IssearchButton();

	       
	        
	        try {
	            
	        	 // Assertion
		        Assert.assertTrue(fromFieldDisplayed, "from field is not displayed");
		        Assert.assertTrue(toFieldDisplayed, "to field is not displayed");
		        Assert.assertTrue(toDateDisplayed, "toDate field is not displayed");
		        Assert.assertTrue(fromDateDisplayed, "fromDate field is not displayed");
		        Assert.assertTrue(travellerAndClassFieldDisplayed, "travellerAndClassField field is not displayed");
		        Assert.assertTrue(searchButtonDisplayed, "search Button is not displayed");
		        
	            // Log a pass status in extent report
	            extentReport.logPass("Travel Page required fields are available.");
	        
	        } catch (AssertionError e) {
	           
	        	// Log a fail status and capture screenshot on assertion failure
	            extentReport.logFail("Travel Page required fields are not available.");
	            
	            try {
	                String screenshotPath =   captureScreenshot(driver, "TravelPage_Fields_Failure");
	                extentReport.attachScreenshot(screenshotPath, "Failure Screenshot");
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	            // Re-throw the assertion error to mark the test as failed in TestNG
	            throw e;
	        }
	        
	        
	        // Log a pass status in extent report
	        extentReport.logPass("All elements are present on the Travel page");
	        
	        //save logs
	        logger.info("verifyTravelPageElements Test completed successfully");
	    }


}
