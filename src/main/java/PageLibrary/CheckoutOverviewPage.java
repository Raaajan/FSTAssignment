package PageLibrary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage {
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	public static List<WebElement> inventoryitemname;
	
	@FindBy(id="finish")
	public static WebElement finish;
	
	
	public void clickFinish() {
		finish.click();
	}

}
