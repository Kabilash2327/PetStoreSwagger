package org.tests;

import org.endpoints.UserEndpointsFromProperty;
import org.payloads.AfterUserUpdatePojo;
import org.payloads.UserPojo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

/**
 * @Date 31-05
 */

public class UserTest {

	Faker faker;
	UserPojo userPojo;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();
		userPojo = new UserPojo();

		userPojo.setId(faker.idNumber().hashCode());
		userPojo.setUsername(faker.name().username());
		userPojo.setFirstName(faker.name().firstName());
		userPojo.setLastName(faker.name().lastName());
		userPojo.setEmail(faker.internet().emailAddress());
		userPojo.setPassword(faker.internet().password(5, 10));
		userPojo.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testCreateUser() {
		
		
			Response response = UserEndpointsFromProperty.create_user(userPojo);
			response.then().body("type", is("unknown")).log().all();
			
			Assert.assertEquals(response.getStatusCode(), 200, "User is created");
			System.out.println("NEW USER IS CREATED");
		
	}

	@Test(priority = 2)
	public void testReadUser() {

		Response response = UserEndpointsFromProperty.read_user(this.userPojo.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200, "The user details is generated");
		System.out.println("AFTER NEW USER IS CREATED");

	}

	@Test(priority = 3)
	public void testUpdateUser() {

		userPojo.setFirstName("Muthuvel");
		userPojo.setLastName("Pandian");
		userPojo.setEmail("Muthu.pandiyan@example.com");

		Response response = UserEndpointsFromProperty.update_user(userPojo, this.userPojo.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200, "The user details is updated");
		
		System.out.println("USER DATA IS UPDATED");

	}

	@Test(priority = 4)
	public void testReadUserAfterUpdate() {

		Response response = UserEndpointsFromProperty.read_user(this.userPojo.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200, "The user details is generated");
		
		AfterUserUpdatePojo resVrfy = response.as(AfterUserUpdatePojo.class);	
		Assert.assertEquals(resVrfy.getFirstName(), "Muthuvel", "The response body is verified");
		
		System.out.println("AFTER UPDATED");

	}

	@Test(priority = 5)
	public void testDeleteUser() {

		Response response = UserEndpointsFromProperty.delete_user(this.userPojo.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200, "The user is deleted");
		System.out.println("UPDATED USER IS SUCCESSFULLY DELETED");

	}
	
}
