package org.tests;

import org.endpoints.StoreEndpointsFromProperty;
import org.payloads.StorePojo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @Date 31-05
 */

public class StoreTest {

	Faker faker;
	StorePojo storePojo;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();
		storePojo = new StorePojo();

		storePojo.setId(6);
		storePojo.setPetId(faker.idNumber().hashCode());
		storePojo.setQuantity(faker.number().randomDigit());
		storePojo.setStatus("placed");
		storePojo.setComplete(true);
		
	}

	@Test(priority = 1)
	public void testCreateUser() {
		
			Response response = StoreEndpointsFromProperty.create_user(storePojo);
			response.then().log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200, "PetID is created");
			System.out.println("NEW ORDER FOR PET IS CREATED");		
	}


	@Test(priority = 2)
	public void testReadUserAfterUpdate() {

		Response response = StoreEndpointsFromProperty.read_user(this.storePojo.getId());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200, "The pet id details are generated");

		//assertion from pojo 
		StorePojo resVrfy = response.as(StorePojo.class);	
		Assert.assertEquals(resVrfy.getStatus(), "placed", "The response body is verified");		
		System.out.println("AFTER CREATED");

	}

	@Test(priority = 3)
	public void testDeleteUser() {

		Response response = StoreEndpointsFromProperty.delete_user(this.storePojo.getId());
		response.then().log().all();
		
		//assert from response
		Assert.assertEquals(response.getStatusCode(), 200, "The pet id is deleted");
		System.out.println("ID IS SUCCESSFULLY DELETED");
		
		//assert from response using json path
		JsonPath jsonPath = new JsonPath(response.asString());
		Assert.assertEquals(jsonPath.get("message").toString(),"6", "The pet id message is verified");
		Assert.assertEquals(jsonPath.get("code").hashCode(),200, "The pet id code is verified");

	}

}
