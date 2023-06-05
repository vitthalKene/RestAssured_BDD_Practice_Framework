import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class post_method {
	public static HashMap map=new HashMap();    //in hashmap we add key and values
	
	
	@BeforeClass
	public void testdata ()
	{
		map.put("title", RestUtils.Title());
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
	}
	
	@Test
	public void testPost ()
	{
		given()
			.contentType("application/json; charset=utf-8")
			.body(map)
		
		.when()
			.post()
	
		.then()
			.statusCode(201)
			.log().all();
	}

}
