package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.endpoints;
import api.payload.Users;
import io.restassured.response.Response;

public class userTests {
	
	
	Users data;
    Faker faker;
	
	@BeforeClass
	public void userTestData() {
		
		
		 faker =new Faker();
		 data =new Users();
		
		
		data.setId(faker.idNumber().hashCode());
		data.setFirstName(faker.name().firstName());
		data.setLastName(faker.name().lastName());
		data.setUsername(faker.name().fullName());
		data.setEmail(faker.internet().emailAddress());
		data.setPhone(faker.phoneNumber().phoneNumber());
		data.setPassword(faker.number().hashCode());
	}
	
	
	@Test(priority = 1)
	void createUser() {
		
		Response res=endpoints.createUser(data);
		res.then().log().body();

		Assert.assertEquals(res.statusCode(), 200);
 		
	}
	
	@Test(priority = 2)
	void getuser() {
		
		Response res=endpoints.getUser(this.data.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	void updateUser() {
		
		data.setFirstName(faker.name().firstName());
		data.setLastName(faker.name().lastName());
		data.setEmail(faker.internet().emailAddress());

		
		Response res=endpoints.updateUser(this.data.getUsername(), data);
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	void deleteUser() {
		
		Response res=endpoints.deleteUser(this.data.getUsername());
		res.then().log().body();

		Assert.assertEquals(res.statusCode(), 200);
 		
	}
	
	 

}
