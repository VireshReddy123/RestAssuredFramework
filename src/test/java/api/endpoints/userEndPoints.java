package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;

public class userEndPoints {
	
	public static Response createUser(User users) {
	
	Response res =given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(users)
	
	.when()
	.post(Routes.post_Url);
	
	return res;
	
	}
	
	public static Response getUser(String username) {
		
		Response res =given()
				.pathParam("username", username)
				
				.when()
				.get(Routes.get_Url);
		
		return res;
		
	}
	
public static Response updateUser(String username, User users) {
		
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(users)
				.pathParam("username", username)
				
				.when()
				.put(Routes.update_Url);
		
		return res;
		
	}

public static Response deleteUser(String username) {
	
	Response res =given()
			.pathParam("username", username)
			
			.when()
			.delete(Routes.delete_Url);
	
	return res;	
}


}
