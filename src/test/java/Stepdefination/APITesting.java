package Stepdefination;

import static io.restassured.RestAssured.given;

import Resources.Helper;
import api.AuthBody;
import api.CreateOrderBody;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITesting {

	Object bearer;
	int validid;

	@Given("^user has base uri and initial setup$")
	public void user_has_base_uri_and_initial_setup() throws Throwable {

		RestAssured.baseURI = "https://simple-tool-rental-api.glitch.me";
	}

	@And("^user generate bearer token$")
	public void user_generate_bearer_token() throws Throwable {

		// generate bearer token
		String rdmno = Helper.generateRandomNo();
		String bearerbody = AuthBody.bearerToken(rdmno);
		Response tokenres = given().header("Content-Type", "application/json").body(bearerbody).log().all().when()
				.post("/api-clients").then().log().all().extract().response();

		String br = tokenres.asString();

		JsonPath brr = (JsonPath) Helper.getJson(br);
		bearer = brr.get("accessToken");

		System.out.println("bearer token = " + bearer);
	}

	@And("^user get valid toolid$")
	public void user_get_valid_toolid() throws Throwable {
		Response tools = given().log().all().when().get("/tools")
				.then().log().all().extract().response();

		String tool = tools.asString();

		JsonPath tl = (JsonPath) Helper.getJson(tool);
		validid = tl.get("id[0]");
		System.out.println("valid tool id = " + validid);
	}

	@Then("^user create order for valid tool id$")
	public void user_create_order_for_valid_tool_id() throws Throwable {
		String crorbody = CreateOrderBody.creatorder(validid);
		Response createorder = given().header("Content-Type", "application/json")
				.header("Authorization",bearer).body(crorbody).log().all()
				.when().post("/orders").then().log().all().extract().response();
		
		String cror = createorder.asString();
		
		//jp = new JsonPath(cror);
		
		JsonPath co = (JsonPath) Helper.getJson(cror);
		
		Object ordercreated = co.get("created");
		Object orderid = co.get("orderId");
		
		System.out.println("order created = "+ordercreated);
		System.out.println("order id = "+orderid);
	}

}
