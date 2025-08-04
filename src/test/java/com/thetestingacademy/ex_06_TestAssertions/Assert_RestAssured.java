package com.thetestingacademy.ex_06_TestAssertions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Assert_RestAssured {
    RequestSpecification rs;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Owner("Ashmi Gurjar")
    @Description("#TC-1 Verify the field validation in assertion")
    @Test
    public void test_CreateBooking_Post(){
        String payload = "{\n" +
                "    \"firstname\" : \"Paul\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 125,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-03-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload).log().all();

        Response response1= rs.when().post();

        validatableResponse = response1.then().log().all();

        validatableResponse.statusCode(200);

        validatableResponse.body("booking.firstname", Matchers.equalTo("Paul"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());
    }
}
