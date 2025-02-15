package api.endpoints;

public class Routes {
	
	// Appilication basic URL.
	
	public static String Basic_Url ="https://petstore.swagger.io/v2";
	
	// URL for the user stores
	
	public static String post_Url =Basic_Url+"/user";
	public static String get_Url =Basic_Url+"/user/{username}";
	public static String update_Url =Basic_Url+"/user/{username}";
	public static String delete_Url =Basic_Url+"/user/{username}";

}
