import static io.restassured.RestAssured.*;
import org.junit.Test;


import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
public class TestCasesAutomation {
    String baseUrl = "https://reqres.in/api/users";
    @Test
    public void testApiGetUserByInvalidId(){
        given().contentType("application/json")
                .when().get(baseUrl+"/0")
                .then().log().all().statusCode(404);
    }
    @Test
    public void testApiGetUserByAlphabeticId() {

        given().contentType("application/json")
                .when().get(baseUrl+"/dimas")
                .then().log().all().statusCode(404);
    }
    @Test
    public void testApiGetUserByAlphanumericId(){

        given().contentType("application/json")
                .when().get(baseUrl+"/dimas123")
                .then().log().all().statusCode(404);
    }
    @Test
    public void testApiGetUserBySpecialCharacterId(){

        given().contentType("application/json")
                .when().get(baseUrl+"/12*")
                .then().log().all().statusCode(404);
    }
    @Test
    public void testApiGetUserByIdPassed(){
        given().contentType("application/json")
                .when().get(baseUrl+"/1")
                .then().assertThat().body(matchesJsonSchema(new File("src/test/java/resources/Schemas"))).log().all().statusCode(200);
    }
    @Test
    public void testApiGetUserByIdNotCreated(){
        given().contentType("application/json")
                .when().get(baseUrl+"/13")
                .then().log().all().statusCode(404);
    }
}
