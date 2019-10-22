package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.junit.Test;


public class EuroTests
{     //recupera el tipo de cambio del euro del 21-10-2019
	private static String ENDPOINT_GET_EURO = "https://www1.oanda.com/rates/api/v2/rates/spot.json?api_key=BmWNKEcalCDEhwZO8HePQSzu&date_time=2019-10-20T21:00:00-04:00&base=EUR&quote=BOB";

	@Test
	public void testGetByISBN(){
	
		given().
		when().
		get(ENDPOINT_GET_EURO)
		.then().
		statusCode(HttpStatus.SC_OK).    
		body(	"quotes.base_currency", containsInAnyOrder("EUR"),
				"quotes.ask", containsInAnyOrder("7.91092"));
	}
}
