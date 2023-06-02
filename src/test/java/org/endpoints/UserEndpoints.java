package org.endpoints;

import static io.restassured.RestAssured.*;
import org.payloads.UserPojo;
import org.tests.UserTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @Date 30-05
 */

public class UserEndpoints {

	public static Response create_user(UserPojo payLoad) {
		
		Response response = given()
								.contentType(ContentType.JSON).accept(ContentType.JSON)
								.body(payLoad)
							.when()
								.post(Endpoints.user_create_url);
							return response;
		
	}
	
	public static Response read_user(String userName) {
	
		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(Endpoints.user_read_url);
							return response;
		
	}
	
	public static Response update_user(UserPojo payLoad, String userName) {
		
		Response response = given()
								.contentType(ContentType.JSON).accept(ContentType.JSON)
								.pathParam("username", userName).body(payLoad)
							.when()
								.put(Endpoints.user_update_url);
							return response;
		
		
	}
	
	public static Response delete_user(String userName) {
		Response response = given()
								.pathParam("username", userName)
							.when()
								.delete(Endpoints.user_delete_url);
							return response;

	}

}
