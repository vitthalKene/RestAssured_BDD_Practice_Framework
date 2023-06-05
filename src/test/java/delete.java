import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class delete {
	
	@Test
	public void delete_request() {
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/11493";
		
		given()
		
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")	
			.log().all();
	}

}
