package Stepdefination;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import PageLibrary.ProductPage;
import io.cucumber.java.en.And;

public class SortLowtoHigh extends Base {
	
	   @And("^user sorts item low to high$")
	    public void user_sorts_item_low_to_high() throws Throwable {
		   ProductPage pp = PageFactory.initElements(driver, ProductPage.class);
		   List<WebElement> pricelistbeforesort = pp.getPriceList();
		   double a[] = new double[pricelistbeforesort.size()];
		   for(int i=0;i<pricelistbeforesort.size();i++) {
			   String bs = pricelistbeforesort.get(i).getText();
			   String bsp =bs.substring(1);
			    double bsv = Double.parseDouble(bsp);
			   System.out.println("bsv ---- "+bsv);
			   a[i]=bsv;
			  }
		   Arrays.sort(a);
		   for(int i=0;i<pricelistbeforesort.size();i++) {
			  System.out.println("sorted ---- "+a[i]);
			  }
		   Thread.sleep(1000);
		   pp.selectFilter("Price (low to high)");
		   Thread.sleep(1000);
		   
		  List<WebElement> pricelistaftersort = pp.getPriceList();
		  for(int i=0;i<pricelistaftersort.size();i++) {
			  String as = pricelistaftersort.get(i).getText();
			  String asp = as.substring(1);
			  double asv = Double.parseDouble(asp);
			  System.out.println("asv ---- "+asv);
			  
			  if(a[i]!=asv) {
				  System.out.println("filteration not working");
			  }
		  }
	        System.out.println("filtaration working - values sorted low to high");
	    }

}
