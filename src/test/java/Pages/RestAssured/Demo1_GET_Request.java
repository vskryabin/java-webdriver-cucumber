package Pages.RestAssured;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_Request {

    @Test
    public void getWhetherDetails() {

        given()
                .when()
                .get("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyBWo7WleEm2m7OC_-ib12O1qWLlkVUOEiU")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("status", equalTo("REQUEST_DENIED"))
                .header("Content-Type", "application/json; charset=UTF-8");
    }



}
