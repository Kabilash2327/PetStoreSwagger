package org.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import org.payloads.StorePojo;
import org.testng.Assert;
import org.tests.UserTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


/**
 * @Date 31-05
 */

public class StoreEndpointsFromProperty {
	
	//call the url from property method
	
		public static ResourceBundle getUrl() {
			
			ResourceBundle resource = ResourceBundle.getBundle("propertyFile");//load properties
			return resource;
		}
		

	public static Response create_user(StorePojo payLoad) {
		
		Response response = given()
								.contentType(ContentType.JSON).accept(ContentType.JSON)
								.body(payLoad)
							.when()
								.post(getUrl().getString("store_create_url"));
							return response;
		
	}
	
	public static Response read_user(int orderid) {
	
		Response response = given()
								.pathParam("orderId", orderid)
							.when()
								.get(getUrl().getString("store_read_url"));
							return response;
		
	}
	
	public static Response delete_user(int orderid) {
		
		Response response = given()
								.pathParam("orderId", orderid)
							.when()
								.delete(getUrl().getString("store_delete_url"));
							return response;

	}
	
    public static void assertion(Object actual, Object expected, String assertionMessage) {
	   
    	Assert.assertEquals(actual, expected, assertionMessage);

    }
}
