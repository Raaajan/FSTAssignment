package PageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInfoPage {
	
	WebDriver driver;
	
	@FindBy(id="first-name")
	public static WebElement firstname;
	
	@FindBy(id="last-name")
	public static WebElement lastname;
	
	@FindBy(id="postal-code")
	public static WebElement postalcode;
	
	@FindBy(id="continue")
	public static WebElement continuebtn;
	
	
	public void enterFirstName(String fn) {
		firstname.sendKeys(fn);	
	}
	
	public void enterLastName(String ln) {
		lastname.sendKeys(ln);	
	}
	
	public void enterPostalCode(String pc) {
		postalcode.sendKeys(pc);	
	}
	
	public void clickContinuebtn() {
		continuebtn.click();
	}

}
