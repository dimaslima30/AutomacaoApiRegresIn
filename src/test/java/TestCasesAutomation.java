import static io.restassured.RestAssured.*;
import org.junit.Test;

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
}
