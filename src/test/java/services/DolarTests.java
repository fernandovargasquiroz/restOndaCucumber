package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.junit.Test;


public class DolarTests
{
	private static String ENDPOINT_GET_DOLAR = "https://www1.oanda.com/rates/api/v2/rates/spot.json?api_key=BmWNKEcalCDEhwZO8HePQSzu&date_time=2019-10-20T21:00:00-04:00&base=USD&quote=BOB";

	@Test
	public void testGetByISBN(){
	
		given().
		when().
		get(ENDPOINT_GET_DOLAR)
		.then().
		statusCode(HttpStatus.SC_OK).    
		body(	"quotes.base_currency", containsInAnyOrder("USD"),
				"quotes.ask", containsInAnyOrder("7.08693"));
	}
}
