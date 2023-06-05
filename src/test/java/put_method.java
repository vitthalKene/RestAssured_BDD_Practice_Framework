import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class put_method {
	
	public static HashMap map=new HashMap();
	int emp_id=21;
	
	@BeforeClass
	public void PutData ()
	{
		map.put("name", RestUtils.empname());
		map.put("salary", RestUtils.empsal());
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void putTest ()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
