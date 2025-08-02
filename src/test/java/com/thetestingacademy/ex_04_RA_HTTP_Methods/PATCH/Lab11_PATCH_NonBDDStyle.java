package com.thetestingacademy.ex_04_RA_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab11_PATCH_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void Test_PATCH_NonBDD(){

        String token = "3373d59267623b9";
        String BookingId = "3540";

        String Payload = "{\n" +
                "    \"firstname\" : \"Dhaval\",\n" +
                "    \"lastname\" : \"Ashmi\"\n" +
                "}";

        //given
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" +BookingId);
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.body(Payload).log().all();

        //when
        response =  r.when().log().all().patch();

        //then
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
