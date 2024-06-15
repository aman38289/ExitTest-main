package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,null);// Initialize WebDriverWait with default timeout
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    // Method to get the title of the current page
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Method to navigate to a URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Method to get the current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Method to refresh the current page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Method to go back to the previous page
    public void goBack() {
        driver.navigate().back();
    }

    // Method to go forward to the next page
    public void goForward() {
        driver.navigate().forward();
    }

    // Method to close the browser
    public void closeBrowser() {
        driver.quit();
    }

    // Method to maximize the browser window
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    
    
 // Method to check if an element is present
    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    // Method to click on an element
    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
