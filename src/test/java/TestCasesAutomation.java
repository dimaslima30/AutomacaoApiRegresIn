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
}
