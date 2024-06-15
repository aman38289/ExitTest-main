package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//img[@class='_2puWtW _3a3qyb' and @alt='Travel']")
	WebElement travelIcon;
	
	@FindBy(xpath="//input[@type='text' and @class='v2VFa- rLGgLC g9KxuM smJZop ZjUTQC z2D4XG' and @name='0-departcity']")
	WebElement fromField;
	
	@FindBy(xpath="//input[@type='text' and @class='v2VFa- rLGgLC g9KxuM smJZop G+rzy6 z2D4XG' and @name='0-arrivalcity']")
	WebElement toField;
	
	@FindBy(xpath="//input[@type='text' and @class='v2VFa- k2khBy z2D4XG' and @name='0-datefrom']")
	WebElement fromDateField;
	
	@FindBy(xpath="//input[@type='text' and @class='v2VFa- k2khBy z2D4XG' and @name='0-dateto']")
	WebElement toDateField;
	
	@FindBy(xpath="//input[@type='text' and @class='v2VFa- n-5ycO z2D4XG' and @name='0-travellerclasscount']")
	WebElement travellerAndClassField;
	
	@FindBy(xpath="//button[@type='button' and @class='QqFHMw sgUmTV M5XAsp' and @tabindex='5']")
	WebElement searchButton;
	
	 // Constructor
    public TravelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void ClickTravelIcon() {
    	travelIcon.click();
    }
    
    public boolean isFromField() {
    	return fromField.isDisplayed();
    }
    
    public boolean IsToField() {
    	return toDateField.isDisplayed();
    }
    
    public boolean IsfromDateField() {
    	return fromDateField.isDisplayed();
    }
    
    public boolean IstoDateField() {
    	return toDateField.isDisplayed();
    }
    
    public boolean IstravellerAndClassField() {
    	return travellerAndClassField.isDisplayed();
    }
    
    public boolean IssearchButton() {
    	return searchButton.isDisplayed();
    }
	

}
