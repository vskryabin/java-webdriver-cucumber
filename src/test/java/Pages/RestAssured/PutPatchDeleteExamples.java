package Pages.RestAssured;

import com.fasterxml.jackson.databind.util.JSONPObject;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutPatchDeleteExamples {

    @Test
    public void testPut() {

        JSONObject request = new JSONObject();
        System.out.println(request.toJSONString());

        request.put("name", "Andrei");
        request.put("Job", "QA");

        baseURI = "https://reqres.in/api";

        given().
                body(request.toJSONString()).
                when().
                put("/users").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPatch() {

        JSONObject request = new JSONObject();
        System.out.println(request.toJSONString());

        request.put("name", "Andrei");
        request.put("Job", "QA");

        baseURI = "https://reqres.in";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete() {

        baseURI = "https://reqres.in";

                when().
                delete("/api/users/2").
                then().
                statusCode(204).
                log().all();
    }

}
