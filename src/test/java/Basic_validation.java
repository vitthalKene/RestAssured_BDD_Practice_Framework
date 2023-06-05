import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * 1. Test Status Code
 * 2. Test Log Response
 * 3. Verify single content in response Body
 * 4. verify multiple content in response body
 * 5. Setting parameters and headers
 * 
 */

@Test(priority=0)
public class Basic_validation {
	
	public void Test_validation () {
		
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		
		.then()
			.statusCode(200);           // 1. Test Status Code
			//.log().all();				// 2. Test Log response
	}
	
	@Test(priority=1)
	public void single_xml_response() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))		//verify the single content in XML response
			.body("CUSTPMER.LASTNAME", equalTo("Clancy"))		//verify the multiple content in XML response
			.body("CUSTPMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTPMER.CITY", equalTo("Seattle"));
			//.log().all();
			
	}
	
	@Test(priority=2)
	public void content_one_go() {
		

		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")   //all content passes in one line
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
			//.log().all();
	}
		
	@Test(priority=3)
	
	public void xpath() {					//find out x-path in XML response body
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
			//.log().all();
		
	}
	
	@Test(priority=4)
	
	public void Text_xpath() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	}


}
