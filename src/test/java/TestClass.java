import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Test;

public class TestClass {

    private final Logger logger = LogManager.getLogger(TestClass.class);

    @Test
    public void test() {

        RestAssured.proxy("cache.srv.pointwest.com.ph", 3128);

        Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/users/1");

        logger.info(response.asString());

        JSONObject jsonResponse = new JSONObject(response.getBody().asString());

        logger.info(jsonResponse.getJSONObject("address").get("street"));

    }


}
