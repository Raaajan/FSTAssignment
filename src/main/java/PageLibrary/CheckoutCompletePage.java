package PageLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage {
	
	@FindBy(xpath="//div[@class=\"checkout_complete_container\"]/h2")
	public static WebElement confirmmsg;
	
	
	public String getConfirmationMsg() {
		return confirmmsg.getText();	
	}

}
