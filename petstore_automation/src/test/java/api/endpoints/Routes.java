package api.endpoints;
/*
 Swagger url = https://petstore.swagger.io/
 Create user(Post) = https://petstore.swagger.io/v2/user
 Show user (GET) = https://petstore.swagger.io/v2/user/{username}
 Update User (Put) = https://petstore.swagger.io/v2/user/{username}
 Delete User (DELETE) = https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	public static final String base_url = "https://petstore.swagger.io/v2/user";
	public static final String create_user_url = base_url;
	public static final String get_user_url = base_url + "/{username}";
	public static final String update_user_url = base_url + "/{username}";
	public static final String delete_user_url = base_url + "/{username}";
	

}
