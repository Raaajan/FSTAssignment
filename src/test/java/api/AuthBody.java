package api;

public class AuthBody {
	
	public static String bearerToken(String random) {
		return "{\r\n" + 
				"   \"clientName\": \"Postman\",\r\n" + 
				"   \"clientEmail\": \"valnemkk@exaple"+random+".com\"\r\n" + 
				"}";
	}

}
