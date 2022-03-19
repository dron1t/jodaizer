package pl.dron1t.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pl.dron1t.models.ResponseBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testJodaizes() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        var expectedResponse = objectMapper.writeValueAsString(new ResponseBody("abc"));
        given()
                .contentType(ContentType.JSON)
                .and()
                .body("{\"message\": \"abc\"}")
          .when().post("/jodaizes")
          .then()
             .statusCode(200)
             .body(is(expectedResponse));
    }
}