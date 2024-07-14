package api.endpoints;
import java.util.ResourceBundle;

import api.payload.User;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

public class UserEndPoints {
	public static Response responseBody;
	public static String url;
	
	public static ResourceBundle get_url() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		url = get_url().getString("create_user_url");
		responseBody = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(url);
		return responseBody;
	}
	
	public static Response getUser(String username) {
		url = get_url().getString("get_user_url");
		responseBody = given()
				.pathParam("username", username)
			.when()
				.get(url);
		return responseBody;
	}
	
	public static Response loginuser(String username, String password) {
		url = get_url().getString("login_user_url");
		responseBody = given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.pathParam("password", password)
			.when()
				.get(url);
		return responseBody;
	}
	
	public static Response logoutuser() {
		url = get_url().getString("logout_user_url");
		responseBody = given()
				.accept(ContentType.JSON)
			.when()
				.get(url);
		return responseBody;
	}
	
	public static Response updateUser(String username, User payload) {
		url = get_url().getString("update_user_url");
		responseBody = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username )
			.when()
				.put(url);
		return responseBody;
	}
	
	
	public static Response deleteUser(String username) {
		url = get_url().getString("delete_user_url");
		System.out.println("--------USER:"+username);
		responseBody = given()
				.pathParam("username", username)
					.when()
				.delete(url);
		return responseBody;
	}
	
	
	

}
