package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ApiTest {
    private static final Logger log = LogManager.getLogger(ApiTest.class);
    public Response getApiResponse(String url){
        log.info("GET request sending to url: {}", url);

        Response response = RestAssured.given()
                .baseUri(url)
                .when()
                .get();

        log.info("GET request successfully sent, Status code: {}, Response body is '{}'",response.getStatusCode(), response.getBody().asString());
        return response;
    }

    public Response postApiRequest(String url, Object body){
        log.info("POST request sending to url: {}", url);
        Response response = RestAssured.given()
                .baseUri(url)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post();
        log.info("POST request successfully sent, Status code: {}, Response body is '{}'",response.getStatusCode(), response.getBody().asString());
        return response;
    }

    public Response putApiRequest(String url, Object body){
        log.info("PUT request sending to url: {}", url);
        Response response = RestAssured.given()
                .baseUri(url)
                .body(body)
                .when()
                .put();
        log.info("PUT request successfully sent, Status code: {}, Response body is '{}'",response.getStatusCode(), response.getBody().asString());
        return response;
    }

    public Response deleteApiRequest(String url){
        log.info("DELETE request sending to url: {}", url);
        Response response = RestAssured.given()
                .baseUri(url)
                .when()
                .delete();

        log.info("DELETE request successfully sent, Status code: {}, Response body is '{}'",response.getStatusCode(), response.getBody().asString());
        return response;
    }

    public static void validateResponse(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();

        if (actualStatusCode == expectedStatusCode) {
            log.info("Success: Status codes match. Expected: {}, Actual: {}", expectedStatusCode, actualStatusCode);
        } else {
            log.error("Failure: Status code does not match. Expected: {}, Actual: {}", expectedStatusCode, actualStatusCode);
        }

    }
}
