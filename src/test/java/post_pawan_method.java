import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class post_pawan_method {
	
	public static HashMap map=new HashMap ();
	
	
	@BeforeClass
	public void post_testdata () {
		
		map.put("first_name", RestUtils.first_name());
		map.put("last_name", RestUtils.last_name());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
		
	}
	@Test
	public void actual_test () {
		
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.post()
		
		.then()
			.statusCode(201)
			.and()
			.body("successCode", equalTo( "OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));
			
		
	}

}
