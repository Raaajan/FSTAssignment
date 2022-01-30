package PageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="user-name")
	public static WebElement username;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="login-button")
	public static WebElement loginbtn;
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	
public void enterUsername(String usrname) {
	username.sendKeys(usrname);
}

public void enterPassword(String passwrd) {
	password.sendKeys(passwrd);
}

public void clickLoginbtn () {
	loginbtn.click();
}

	
}
