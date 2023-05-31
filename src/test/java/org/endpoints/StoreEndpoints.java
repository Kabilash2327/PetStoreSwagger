package org.endpoints;

import static io.restassured.RestAssured.*;

import org.payloads.StorePojo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tests.UserTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class StoreEndpoints extends UserTest{

	public static Response create_user(StorePojo payLoad) {
		
		Response response = given()
								.contentType(ContentType.JSON).accept(ContentType.JSON)
								.body(payLoad)
							.when()
								.post(Endpoints.store_create_url);
							return response;
		
	}
	
	public static Response read_user(int orderid) {
	
		Response response = given()
								.pathParam("orderId", orderid)
							.when()
								.get(Endpoints.store_read_url);
							return response;
		
	}
	
	public static Response delete_user(int orderid) {
		
		Response response = given()
								.pathParam("orderId", orderid)
							.when()
								.delete(Endpoints.store_delete_url);
							return response;

	}
	
    public static void assertion(Object actual, Object expected, String assertionMessage) {
	   
    	Assert.assertEquals(actual, expected, assertionMessage);

    }
}
