package api.test;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;

public class UserTests extends BaseClass {
	
	@BeforeClass
	public void setupData() {
		logger.info("setting up userdata for request body");
		faker = new Faker();
		payload = new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(6, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		logger.info("userdata setup complete");
	}
	
	@Test(description = "Test for validating a user creation in the pet store", priority = 1, enabled = true)
	public void test_CreateUser() {
		logger.info("validating user creation through statuscode");
		response = UserEndPoints.createUser(payload);
		logResponse(response);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(description="Test for Validating Get user through status code", priority = 2, enabled= true, dependsOnMethods = {"test_CreateUser"})
	public void test_GetUser() {
		logger.info("validating status code of the get method for showing created user");
		response = UserEndPoints.getUser(this.payload.getUsername());
		logResponse(response);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(description="Test for validating login user",priority=3,enabled=true)
	public void test_LoginUser() {
		logger.info("validating of user login through username and password");
		response = UserEndPoints.loginuser(this.payload.getUsername(), this.payload.getPassword());
		logResponse(response);
		Assert.assertEquals(response.getStatusCode(), 200);
		String message = response.jsonPath().getString("message");
		System.out.println("login message-----------------" + message);
		Assert.assertTrue(message.startsWith("logged in user session:"), "Message should start with 'logged in user session:'");
		
	}
	@Test(description = "test for validating of user logout", priority=4,dependsOnMethods = {"test_LoginUser"})
	public void test_LogoutUser() {
		logger.info("validating of user logout");
		response = UserEndPoints.logoutuser();
		logResponse(response);
		String logout_message = response.jsonPath().getString("message");
		System.out.println("log out message--------------" + logout_message);
		Assert.assertTrue(response.jsonPath().getString("message").contains("ok"), "message should contain ok message");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(description="Test for Validating update user through status code", priority = 5, enabled= true, dependsOnMethods = {"test_CreateUser","test_GetUser"})
	public void test_UpdateUser() {
		logger.info("validating status code for update user");
		
		logger.info("setting up modified data for operation update");
		payload.setUsername(faker.name().username());
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5, 10));
		response = UserEndPoints.updateUser(this.payload.getUsername(), payload);
		logResponse(response);
		
		response = UserEndPoints.getUser(payload.getUsername());
		logResponse(response);
		logger.info( "logging username is :" + response.jsonPath().getString("username"));
		
		logger.info("Checking Staus code to be 200");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("checking reponse body");
		String expectedUsername = this.payload.getUsername();
	    Assert.assertEquals(response.jsonPath().getString("username"), expectedUsername, "Username does not match");
	    Assert.assertNotNull(response.jsonPath().getString("id"), "User ID is null");
	    Assert.assertNotNull(response.jsonPath().getString("email"), "User email is null");
	}
	
	@Test(description="Test for Validating delete user through status code", priority = 6, enabled= true, dependsOnMethods = {"test_CreateUser","test_GetUser","test_UpdateUser"})
	public void test_DeleteUser() {
		logger.info("validating status code for delete user");
		
		
		response = UserEndPoints.deleteUser(this.payload.getUsername());
		logResponse(response);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
