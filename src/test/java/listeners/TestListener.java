package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;
import java.io.*;
import tests.TestHomePage;



public class TestListener implements ITestListener {
    TestHomePage testHomePage = new TestHomePage();

    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test case started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase passed is :" + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the testcase failed is :" + result.getName());
        WebDriver driver = testHomePage.driver;
        try {
            String screenshotPath = testHomePage.captureScreenshot(driver, result.getName());
            System.out.println("Screenshot taken and saved at: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase skipped is :" + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage");
    }

    public void onStart(ITestContext context) {
        System.out.println("This is onStart method");
    }

    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method");
    }
}
