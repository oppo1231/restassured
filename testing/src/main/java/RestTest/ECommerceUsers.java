package RestTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ECommerceUsers {
	
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	    public static String message;
	    public static String accessToken;
	    @Test(priority = 0)
	    public void signup()
	    {
	    	RestAssured.baseURI = baseurl;
	        String requestbody = "{\n"+"\"email\":\"Rosy007@gmail.com\",\n"+"\"password\":\"Esh@25\"\n"+"}";
            Response response = given()
		    .header("Content-Type","application/json")
		    .body(requestbody)
		 
	        .when()
	        .post("/user/signup")
	     
	        .then()
	        .assertThat().statusCode(201).contentType(ContentType.JSON)
	        .extract().response();
 
            String jsonresponse = response.asString();
            JsonPath js = new JsonPath(jsonresponse);
            message = js.get("message");
            System.out.println(message);
 
}
          @Test(priority = 1)
          public void Login()
          {
        	  RestAssured.baseURI = baseurl;
        	  String requestbody = "{\n"+"\"email\":\"Rosy008@gmail.com\",\n"+"\"password\":\"Eshwar@258\"\n"+"}";
        	  Response response = given()
        	  .header("Content-Type","application/json")
        	  .body(requestbody)
        	 		 
        	  .when()
        	  .post("/user/login")
        	 	     
        	  .then()
        	  .assertThat().statusCode(200).contentType(ContentType.JSON)
        	  .extract().response();
        	  
        	   String jsonresponse = response.asString();
        	   JsonPath js = new JsonPath(jsonresponse);
        	   accessToken = js.get("accessToken");
        	   System.out.println(accessToken);
        	  
        	  

          }
}
