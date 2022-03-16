package RestTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Trello {
       public static String baseurl = "https://api.trello.com";
       public static String id;
       @Test (priority=0)
       public void createBoard()
       {
    	   RestAssured.baseURI = baseurl;
    	   Response response = given().queryParam("name","Panchami board")
    	   .queryParam("key","be3627eb6d174fba4f514b3dac21c4ea")
    	   .queryParam("token","ab28401623b496e45b1c1257cd3cfc19156fc411bbd4390bef4f42f49d6edcec")
    	   .header("Content-Type","application/json")
    	   
    	   .when()
    	   .post("/1/boards/")
    	   
    	   .then()
    	   .assertThat().statusCode(200).contentType(ContentType.JSON)
    	   .extract().response();
    	   String jsonresponse = response.asString();
    	   JsonPath js = new JsonPath(jsonresponse);
    	   id = js.get("id");
    	   System.out.println(id);
       
       }
       @Test (priority=1)
       public void getBoard()
       {
    	   RestAssured.baseURI = baseurl;
    	   Response response = given().queryParam("name","Panchami board")
    	   .queryParam("key","be3627eb6d174fba4f514b3dac21c4ea")
    	   .queryParam("token","ab28401623b496e45b1c1257cd3cfc19156fc411bbd4390bef4f42f49d6edcec")
    	   .header("Content-Type","application/json")
    	   
    	   .when()
    	   .get("/1/boards/"+id)
    	   
    	   .then()
    	   .assertThat().statusCode(200).contentType(ContentType.JSON)
    	   .extract().response();
    	   
    	   String jsonresponse = response.asString();
    	   System.out.println(jsonresponse);
    	   
    	   
       }
       @Test (priority=2)
       public void deleteBoard()
       {
    	   RestAssured.baseURI = baseurl;
    	   Response response = given().queryParam("name","moolya board")
    	   .queryParam("key","be3627eb6d174fba4f514b3dac21c4ea")
    	   .queryParam("token","ab28401623b496e45b1c1257cd3cfc19156fc411bbd4390bef4f42f49d6edcec")
    	   .header("Content-Type","application/json")
    	   
    	   .when()
    	   .delete("/1/boards/"+id)
    	   
    	   .then()
    	   .assertThat().statusCode(200).contentType(ContentType.JSON)
    	   .extract().response();
    	   
    	   String jsonresponse = response.asString();
    	   System.out.println(jsonresponse);
       }
       
}
