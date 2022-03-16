package RestTesting;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class Ecommerce {
	
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	public static String id;
	public static String email = "Krypto.knight1@gmail.com";
	
	@Test (priority = 0)
	public void signup()
	{
		RestAssured.baseURI = baseurl;
		
		String requestbody ;
		}
	

}
