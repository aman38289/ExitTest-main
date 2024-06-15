package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsAndConditionPage {

	WebDriver driver;

	// Constructor
	public TermsAndConditionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//a[@class='HlWMPX' and @aria-label='Terms Of Use']")
	WebElement termsAndConditionsLink;
	
	public void ClickTermsAndConditionsLink() {
		termsAndConditionsLink.click();
	}

}
