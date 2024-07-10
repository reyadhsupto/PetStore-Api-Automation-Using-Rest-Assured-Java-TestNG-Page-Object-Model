package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payload.User;

import api.utilities.DataProviders;


public class DDTests extends BaseClass {
	
	@Test(description="Test case for creating user through post method", dataProvider = "Data", dataProviderClass = DataProviders.class, priority=1)
	public void test_postUser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph) {
		logger.info("Validating create user in ddt test suite");
		payload = new User();
		payload.setId(Integer.parseInt(userID));
		payload.setUsername(userName);
		payload.setFirstname(fname);
		payload.setLastname(lname);
		payload.setEmail(useremail);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		response = UserEndPoints.createUser(payload);
		logResponse(response);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(description="Testing the delete request for ddt", priority=2, dataProvider="UserNames", dataProviderClass = DataProviders.class )
	public void test_deleteuser(String username) {
		logger.info("Validating the delete user DELETE request in ddt");
		response = UserEndPoints.deleteUser(username);
		logResponse(response);
		System.out.println("--------"+response.asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
