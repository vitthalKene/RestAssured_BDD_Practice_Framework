import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * given()
 * 		set cookies, add auth, add param, set headers info etc....
 * 
 * when()
 * 		get, post, put, patch, delete
 * 
 * then()
 * 		validate status code, extract response, extract header cookies & response body....
 */

public class get_method {
	
	@Test
	public void DummyApi ()
	{
		given()
		.when()
			.get("https://dummy.restapiexample.com/api/v1/employee/1")
		.then()
			.statusCode(200)
			.assertThat().body("status", equalTo("success"))
			.header("Content-Type", "application/json");
		
	}

}
