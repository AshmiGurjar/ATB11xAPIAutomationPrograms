package com.thetestingacademy.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static  org.assertj.core.api.Assertions.*;

public class Assert_AssertJLibrary {

    RequestSpecification rs;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Test
    public void test_CreateBooking_Post() {

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

        Response response = rs.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Paul"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        //TestNG Extract the details of firstname,lastname
        bookingID = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        Assert.assertEquals(firstname,"Paul");
        Assert.assertEquals(lastname,"Brown");
        Assert.assertNotNull(bookingID);

        //AssertJ -3rd Party library
        assertThat(bookingID).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Paul").isNotBlank().isNotNull().isNotEmpty().isAlphanumeric();
    }
}
