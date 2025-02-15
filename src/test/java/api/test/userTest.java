package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class userTest {

	User user;
	Faker faker;
	
	
	@BeforeClass
	 public void userData() {
		 
		 
	     faker =new Faker();
		
		 user =new User();
		
		user.setFirstName(faker.name().firstName());
		//user.setId(faker.hashCode());
		user.setLastName(faker.name().lastName());
		user.setUsername(faker.name().username());
		user.setPassword(faker.number().digit());
	//	user.setPhone(faker.number().digit());
		user.setEmail(faker.internet().emailAddress());	
		
	 }
	
	@Test(priority = 1)
	void CreateGuestUser() {
		
		Response res=userEndPoints.createUser(user);
          res.then().log().all();
          
          Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 2)
	void getGuestUser() {
		Response res=userEndPoints.getUser(this.user.getUsername());
		 res.then().log().all();
         
         Assert.assertEquals(res.getStatusCode(), 200);
	}
	
//	@Test(priority = 3)
	void CreateUpdateUser() {
		
		user.setLastName(faker.name().lastName());
		user.setUsername(faker.name().username());
		user.setPassword(faker.number().digit());
		
		Response res=userEndPoints.updateUser(this.user.getUsername(),user);
          res.then().log().all();
          
          Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
//	@Test(priority = 4)
	void DeleteUser() {
		Response res=userEndPoints.deleteUser(this.user.getUsername());
		 res.then().log().all();
         
         Assert.assertEquals(res.getStatusCode(), 200);
	}
	
}

