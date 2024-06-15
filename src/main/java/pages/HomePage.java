package pages;

import java.time.Duration;
import java.util.ArrayList;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class HomePage{
	
	
	private By cartIcon = By.cssSelector("a[title='Cart']");
	
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	// Elements on the home page
    @FindBy(xpath = "//input[@title='Search for products, brands and more']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    
    @FindBy(xpath="//div[@class='col col-7-12']//div[@class='KzDlHZ' and text()='Apple iPhone 15 Plus (Black, 256 GB)']")
    private WebElement productLink;
    
    @FindBy(xpath = "//div[@class='KzDlHZ' and text()='Canon R100 Mirrorless Camera RF-S 18-45mm f/4.5-6.3 IS STM']")
    private WebElement cameraLink;

    // Methods to interact with elements
    public void enterSearchText(String searchText) {
        searchBox.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
    
    // Method to perform a search
    public void search(String query) {
        driver.findElement(By.name("q")).sendKeys(query+ Keys.ENTER);
    }

	public ProductPage clickProduct() {
		// TODO Auto-generated method stub
		productLink.click();
		return new ProductPage(driver);
	}
	
	// Click on the product
    public ProductPage clickCamera() throws InterruptedException {
        // Click on the product link or image
    	// Get the current window handle
        String mainWindowHandle = driver.getWindowHandle();
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        WebElement cameraLink = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='KzDlHZ' and text()='Canon R100 Mirrorless Camera RF-S 18-45mm f/4.5-6.3 IS STM']")));
        cameraLink.click();
        
        Thread.sleep(5000);        
        // Wait for the new tab to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        // Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        
        // Switch to the new tab
        tabs.remove(mainWindowHandle);
        System.out.println(driver.switchTo().window(tabs.get(0)).getCurrentUrl());
        
        // Return the ProductPage instance
        return new ProductPage(driver);
    }

	
}
