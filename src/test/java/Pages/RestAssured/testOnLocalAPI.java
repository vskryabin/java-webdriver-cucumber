package Pages.RestAssured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class testOnLocalAPI {

    @Test
    public void get() {

        baseURI="http://localhost:3000";

         given().get("/users").then().statusCode(200);
    }

    @Test
    public void post() {
        JSONObject request = new JSONObject();
        request.put("firsname", "Andrei");
        request.put("lastname", "Travkin");
        request.put("subjectid", 1);

        baseURI="http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }


    @Test
    public void put() {
        JSONObject request = new JSONObject();
        request.put("firsname", "Eric");
        request.put("lastname", "Cartman");
        request.put("subjectid", 5);

        baseURI="http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/5")
                .then()
                .statusCode(200);
    }

    @Test
    public void patch() {
        JSONObject request = new JSONObject();
        request.put("lastname", "Rosen");

        baseURI="http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/5")
                .then()
                .statusCode(200);
    }

    @Test
    public void delete(){
        baseURI="http://localhost:3000";

        when().delete("/users/4")
                .then()
                .statusCode(200);
    }

}
