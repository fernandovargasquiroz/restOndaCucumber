package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DolarStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_EURO = "https://www1.oanda.com/rates/api/v2/rates/spot.json?api_key=BmWNKEcalCDEhwZO8HePQSzu&date_time=2019-10-20T21:00:00-04:00&base=EUR&quote=BOB";


	@Given("cotizacion del euro")
	public void cotizacion_del_dia(){
		request = given();
	}

	@When("hay cotizacion")
	public void hay_cotizacion(){
		response = request.when().get(ENDPOINT_GET_EURO);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("thestatus code is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the following$")
	public void response_equals(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}
}


