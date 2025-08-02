package com.thetestingacademy.ex_04_RA_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab09_POST_BDDStyle {

    @Test
    public void test_POST_BDD(){

        String payload = " {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all()  //print console messages
                    .body(payload)  //We want body in post request
                .when()
                    .log()
                    .all()
                    .post()
                .then()
                    .log().all().statusCode(200);
    }
}
