package org.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import org.payloads.UserPojo;
import org.tests.UserTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpointsFromProperty extends UserTest{
	
	//call the url from property method
	
	public static ResourceBundle getUrl() {
		
		ResourceBundle resource = ResourceBundle.getBundle("propertyFile");//load properties
		return resource;
	}
	
	public static Response create_user(UserPojo payLoad) {
		
		
		//String post_user_url = getUrl().getString("user_create_url");
		
		
		Response response = given()
								.contentType(ContentType.JSON).accept(ContentType.JSON)
								.body(payLoad)
							.when()
								.post(getUrl().getString("user_create_url"));
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
