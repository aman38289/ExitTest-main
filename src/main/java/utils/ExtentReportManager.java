package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentHtmlReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportManager {
    
	private static ExtentReports extent;
	private static ExtentReportManager instance;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;
    
    private ExtentReportManager() {
    }

    public static ExtentReportManager getInstance() {
        if (instance == null) {
            instance = new ExtentReportManager();
            extent = new ExtentReports();
            htmlReporter = new ExtentHtmlReporter("extent.html");
            extent.attachReporter(htmlReporter);
        }
        return instance;
    }

    public void createTest(String testName, String testDescription) {
        test = extent.createTest(testName, testDescription);
    }

    public void logPass(String message) {
        test.log(Status.PASS, message);
    }

    public void logFail(String message) {
        test.log(Status.FAIL, message);
    }

    public void flushExtentReport() {
        // Flush and close the report
        extent.flush();
    }
    
    public void attachScreenshot(String screenshotPath, String description) throws IOException {
        // Attach screenshot to the extent report
        test.fail(description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    
}
