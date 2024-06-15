package tests;


import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;


import config.ConfigReader;


import utils.BrowserFactory;
import utils.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {
	
	 public WebDriver driver;
	 protected static ExtentReportManager extentReport;
	
	protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	@BeforeClass
	public void setUp() {
		// Setup ChromeDriver using WebDriverManager
		ConfigReader configReader = new ConfigReader();
		driver = BrowserFactory.getDriver(configReader.getBrowser(),configReader.getStatusOfHeadless());
		driver.manage().window().maximize();
		// Initialize extent report
        extentReport = ExtentReportManager.getInstance();
       
	}
	
	
	@AfterClass
    public void tearDown() {
		// Quit WebDriver
        driver.quit();
        // Flush extent report
        extentReport.flushExtentReport();
    }
	
	
	// Method to capture screenshot
    public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }
    
    
    static {
        try {
            // Create a file handler
            Handler fileHandler = new FileHandler("test.log");
            // Set the formatter
            fileHandler.setFormatter(new SimpleFormatter());
            // Add the file handler to the logger
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
