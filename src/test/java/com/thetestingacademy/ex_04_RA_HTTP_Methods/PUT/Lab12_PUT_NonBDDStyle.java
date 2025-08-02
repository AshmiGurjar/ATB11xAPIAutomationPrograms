package com.thetestingacademy.ex_04_RA_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab12_PUT_NonBDDStyle {

        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

        @Test
        public void Test_PUT_NonBDD(){

            String token = "3373d59267623b9";
            String BookingId = "3540";

            String Payload = "{\n" +
                    "    \"firstname\": \"Dhaval\",\n" +
                    "    \"lastname\": \"Gurjar\",\n" +
                    "    \"totalprice\": 123,\n" +
                    "    \"depositpaid\": true,\n" +
                    "    \"bookingdates\": {\n" +
                    "        \"checkin\": \"2025-01-01\",\n" +
                    "        \"checkout\": \"2025-05-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\": \"Dinner\"\n" +
                    "}";

            //given
            r= RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/" +BookingId);
           // r.cookie(token);
            r.cookie("token",token);
            r.contentType(ContentType.JSON);
            r.body(Payload).log().all();

            //when
            response =  r.when().log().all().put();

            //then
            vr = response.then().log().all();
            vr.statusCode(200);
        }
}
