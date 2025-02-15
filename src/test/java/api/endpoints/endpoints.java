package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class endpoints {
	
	
	
	// In this we write the common code for create, update, read, delete for users
	
	//Same we have to right for other modules also.
	
	public static  Response createUser(Users payload){
		 
		Response res= given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(payload)
		 
		 .when()
		 .post(Routes.post_Url);
		  
		return res;
	}

	public static  Response getUser(String username){
		 
		Response res= given()
		 .pathParam("username", username)
		 
		 .when()
		 .get(Routes.get_Url);
		  
		return res;
	}
	
	public static  Response updateUser(String username, Users payload){
		 
		Response res= given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .pathParam("username", username)
		 .body(payload)
		 
		 .when()
		 .put(Routes.update_Url);
		  
		return res;
	}
	
	public static  Response deleteUser(String username){
		 
		Response res= given()
		 .pathParam("username", username)
		 
		 .when()
		 .delete(Routes.delete_Url);
		  
		return res;
	}
	
	public static  Response getUser1(String FirstName){
		 
		Response res= given()
		 .pathParam("FirstName", FirstName)
		 
		 .when()
		 .get(Routes.get_Url1);
		  
		return res;
	}
	
	
}
