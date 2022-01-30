package Stepdefination;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import PageLibrary.ProductPage;
import io.cucumber.java.en.And;

public class AddRemoveSelectMultiple extends Base{
	

    @And("^user adds one item and then remove that item to go back$")
    public void user_adds_one_item_and_then_remove_that_item_to_go_back() throws Throwable {
    	
    	ProductPage pp = PageFactory.initElements(driver, ProductPage.class);
		pp.addFirstItemToCart();
		List<WebElement> itemlist = pp.getItemNameList();
		System.out.println("item size "+itemlist);
		
		for(int i=0;i<itemlist.size();i++) {
			String listname = itemlist.get(i).getText();
			if(listname.equals("Sauce Labs Backpack")) {
				itemlist.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		pp.removeFirstItemfromCart();
		Thread.sleep(1000);
		pp.clickBackToProductsBtn();
		Thread.sleep(2000);
       
    }

}
