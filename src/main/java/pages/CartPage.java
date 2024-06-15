package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage{
	
	private WebDriver driver;
	
	@FindBy(xpath="//a[@title='Cart']")
	WebElement cartPageLink;
	
	 // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    
    public void ClickCartLink() {
    	cartPageLink.click();
    }

}
