package Stepdefination;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import PageLibrary.CheckoutCompletePage;
import PageLibrary.CheckoutOverviewPage;
import PageLibrary.CheckoutYourInfoPage;
import PageLibrary.LoginPage;
import PageLibrary.ProductPage;
import PageLibrary.YourCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SelectMultiple extends Base {

	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() throws IOException {
		Base.loadProperty();
		driver = Base.openBrowser();
		String url = prop.getProperty("url");
		driver.get(url);
	}

	@And("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> cred = dataTable.asMaps();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUsername(cred.get(0).get("username"));
		login.enterPassword(cred.get(0).get("password"));
		login.clickLoginbtn();
	}

	@And("user adds required item to cart")
	public void user_adds_required_item_to_cart() {
		ProductPage pp = PageFactory.initElements(driver, ProductPage.class);
		List<WebElement> lstofaddtocart = pp.getListofAddToCartBtn();
		for (int i = 0; i < 3; i++) {
			WebElement addtocartbtn = lstofaddtocart.get(i);
			addtocartbtn.click();
		}

		pp.clickCartContainer();
	}

	@And("user proceeds to checkout")
	public void user_proceeds_to_checkout() {

		YourCartPage ycp = PageFactory.initElements(driver, YourCartPage.class);
		ycp.clickCheckoutbtn();

	}

	@And("^user enters details (.+) and (.+) and (.+) for checkout$")
	public void user_enters_details_and_and_for_checkout(String firstname, String lastname, String postalcode) {
		CheckoutYourInfoPage ycip = PageFactory.initElements(driver, CheckoutYourInfoPage.class);
		ycip.enterFirstName(firstname);
		ycip.enterLastName(lastname);
		ycip.enterPostalCode(postalcode);
		ycip.clickContinuebtn();
	}

	@And("user confirm checkout")
	public void user_confirm_checkout() {
		CheckoutOverviewPage cop = PageFactory.initElements(driver, CheckoutOverviewPage.class);
		cop.clickFinish();
	}

	@Then("user verify final confirmation message")
	public void user_verify_final_confirmation_message() {
		CheckoutCompletePage ccp = PageFactory.initElements(driver, CheckoutCompletePage.class);
		String confirmmsg = ccp.getConfirmationMsg();
		assertEquals("THANK YOU FOR YOUR ORDER", confirmmsg);
	}

}
