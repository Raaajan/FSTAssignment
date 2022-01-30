package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static FileInputStream fi;
	public static Properties prop;

	public static WebDriver openBrowser() {
		WebDriverManager.chromedriver().setup();
		return driver = new ChromeDriver();
	}
	
	public static Object scrollIntoView(WebElement elem) {
		js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].scrollIntoView(true);", elem);
	}

	public static void loadProperty() throws IOException {
		 fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\saucedemo.properties");
		 prop = new Properties();
		prop.load(fi);
	}
	
	public static String getProperty(String prokey) {
		return prop.getProperty(prokey);
	}
	
}
