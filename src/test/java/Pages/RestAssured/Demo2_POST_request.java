package Pages.RestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_request {

    public static HashMap map = new HashMap();

    @BeforeClass
    public void postData() {


        baseURI="https://api.trello.com";
        basePath= "/1/boards";
    }

    @Test
    public void testPost() {
    given().
            contentType("application/json").
            when().
            post().
                    then().
            statusCode(201);
    }

}
