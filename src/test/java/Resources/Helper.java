package Resources;

import java.util.Random;

import io.restassured.path.json.JsonPath;



public class Helper {
	
	
	public static String generateRandomNo() {
		    Random r = new Random();
		    String randomNumber = String.format("%04d", r.nextInt(1001));
		    return randomNumber;
			
	}
	
	public static Object getJson(String rps) {
		JsonPath jp = new JsonPath(rps);
		return jp;
		
	}

}
