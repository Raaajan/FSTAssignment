package PageLibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='inventory_item']")
	public static List<WebElement> inventoryitem;
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	public static List<WebElement> addtocartbtn;
	
	@FindBy(id="shopping_cart_container")
	public static WebElement cartcontainer;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public static WebElement addoneitemtocart;
	
	@FindBy(id="remove-sauce-labs-backpack")
	public static WebElement removeaddedfirstitemfromcart;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	public static List<WebElement> itemnamelist;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	public static List<WebElement> pricelist;
	
	@FindBy(id="back-to-products")
	public static WebElement backtoproductbtn;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	public static WebElement selectfilter;
	
	public ProductPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public List<WebElement> getListofAddToCartBtn() {
		return addtocartbtn;
	}
	
	public void clickCartContainer() {
		cartcontainer.click();
	}
	
	public void addFirstItemToCart() {
		addoneitemtocart.click();
	}
	
	public void removeFirstItemfromCart() {
		removeaddedfirstitemfromcart.click();
	}
	
	public List<WebElement> getItemNameList() {
		return itemnamelist;
	}
	
	public List<WebElement> getPriceList() {
		return pricelist;
	}
	
	public void clickBackToProductsBtn() {
		backtoproductbtn.click();	
	}
	
	public void selectFilter(String texttoselect) {
		Select s = new Select(selectfilter);
		s.selectByVisibleText(texttoselect);
	}
	
}
