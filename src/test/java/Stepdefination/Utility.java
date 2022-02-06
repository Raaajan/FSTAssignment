package Stepdefination;

import Base.Base;
import io.cucumber.java.After;

public class Utility extends Base{
	
	@After
	public void tearDown() {
		if(driver!=null) {
		driver.close();
	}
	}

}
