package module.Validations;

import core.general.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.awt.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNot.not;

public class FetchEmployees extends BaseTest {
    public FetchEmployees() throws AWTException {}

    @Test
    public static void sanityFlowFetchEmployees(){
        response =
            given()
                .log().all()
                .headers( "Accept", "*/*")
            .when()
                .get("/api/v1/employees")
            .then()
                .log().all()
                .assertThat().statusCode(200)
//                .body("size()", not(null))
            .extract()
                .response();
    }
}
