import com.sample.apiautomation.utils.PropertyUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestClass {

    private final Logger logger = LogManager.getLogger(TestClass.class);

    @Test
    public void test() {

        RestAssured.proxy("cache.srv.pointwest.com.ph", 3128);

        Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/users/1");

        JSONObject jsonResponse = new JSONObject(response.getBody().asString());

        Iterator<String> strings = jsonResponse.keys();

        jsonResponse.val

        while (strings.hasNext()) {
            String key = strings.next();
            logger.info("Keykey {}", key);
        }


    }


}
