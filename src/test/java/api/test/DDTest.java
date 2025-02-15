package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.dataProviders;
import io.restassured.response.Response;

public class DDTest {
	
 	@Test(priority = 1, dataProvider = "Data", dataProviderClass = dataProviders.class)
	public void createPost( String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone) { // ✅ Password as String

 		User userPayload=new User();
	    userPayload.setId(UserID);
	    userPayload.setUsername(UserName);
	    userPayload.setFirstName(FirstName);
	    userPayload.setLastName(LastName);
	    userPayload.setEmail(Email);
	    userPayload.setPassword(Password); 
	    userPayload.setPhone(Phone);
	    

	    Response res = userEndPoints.createUser(userPayload);
	    Assert.assertEquals(res.getStatusCode(), 200);
	}
	

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = dataProviders.class)
	public void deleteUser(String UserName) {
		 
		Response res =userEndPoints.deleteUser(UserName);
	    Assert.assertEquals(res.getStatusCode(), 200);	
	}
	
}
