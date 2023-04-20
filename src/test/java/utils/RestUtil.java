package utils;

import java.util.Map;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class RestUtil {
	
	private static final PropertiesUtils prop = PropertiesUtils.getInstance();
	
	public String postFormData(String baseURL, String urlPath, Map<String, String> formdata) {
        RestAssured.baseURI = baseURL;
        System.out.println("URL: " + baseURL + urlPath);
        Response res = given().contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formdata).when().post(baseURL + urlPath).then().extract().response();
        @SuppressWarnings("rawtypes")
        ResponseBody GetResponse = res.body();
        String getResponse = GetResponse.asString();
        return getResponse;
    }
	
	 public Response postParam(String baseURL, String urlPath, String param) {

	        RestAssured.baseURI = baseURL;
	        System.out.println("URL: " + baseURL);
	        RequestSpecification request = RestAssured.given();
	        // Add a header stating the Request body is a JSON
	        request.header("Content-Type", "application/json");
	        // Add the Json to the body of the request
	        request.body(param);
	        // Post the request and check the response
	        Response res = request.post(urlPath);

	        return res;
	    }
	 
	      
	    public Response getCall(String baseURL, String urlPath, String objectID) {
	        // Hitting the GET API for the specified baseURL+urlPath/objectID
	        RestAssured.baseURI = baseURL;
	        System.out.println("URL called: " + baseURL + urlPath + objectID);

	        Response res = given().get(baseURL + urlPath + objectID).then().assertThat().extract().response();
	        return res;
	    }


	    public Response getASCall_BAU(String baseURL, String urlPath, String objectID) {
	        // Hitting the GET API for the specified baseURL+urlPath/objectID
	        RestAssured.baseURI = baseURL;
	        System.out.println("URL called: " + baseURL + urlPath + objectID);

	        Response res = given().header("Authorization", "Basic " + "a value here").param("siteID", "a value here").param("userName", "a value here").param("password", prop.getPropertyValue("as_bau_password"))
	                .when().get(baseURL + urlPath + objectID).then().assertThat().extract().response();
	        return res;
	    }

}
