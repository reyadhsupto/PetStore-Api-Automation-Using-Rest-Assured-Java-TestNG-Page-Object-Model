package api.endpoints;

import api.payload.User;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

public class UserEndPoints {
	public static Response responseBody;
	
	public static Response createUser(User payload) {
		responseBody = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.create_user_url);
		return responseBody;
	}
	
	public static Response getUser(String username) {
		responseBody = given()
				.pathParam("username", username)
			.when()
				.get(Routes.get_user_url);
		return responseBody;
	}
	
	public static Response updateUser(String username, User payload) {
		responseBody = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username )
			.when()
				.put(Routes.update_user_url);
		return responseBody;
	}
	
	
	public static Response deleteUser(String username) {
		responseBody = given()
				.pathParam("username", username)
					.when()
				.delete(Routes.delete_user_url);
		return responseBody;
	}
	
	
	

}
