package PageLibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='cart_item']")
	public static List<WebElement> totalcartitems;
	
	@FindBy(id="checkout")
	public static WebElement checkoutbtn;
	

	public void clickCheckoutbtn() {
		checkoutbtn.click();	
	}
	
}
