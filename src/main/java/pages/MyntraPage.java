package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyntraPage {
	
	WebDriver driver;

    // Constructor
    public MyntraPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//a[@href='https://www.myntra.com/']")
	WebElement myntraLink;
	
	
	public void clickMyntraLink() {
		myntraLink.click();
	}
	
	
	 // Method to get the title of the new tab
    public String getNewTabTitle() {
        // Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new tab
        String newTabHandle = tabs.get(tabs.size() - 1);
        driver.switchTo().window(newTabHandle);

        // Get the title of the new tab
        String newTabTitle = driver.getTitle();

        // Switch back to the main tab
        String mainWindowHandle = tabs.get(0);
        driver.switchTo().window(mainWindowHandle);

        return newTabTitle;
    }

}
