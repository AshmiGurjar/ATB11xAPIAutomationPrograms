package com.thetestingacademy.ex_04_RA_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab13_DELETE_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void Test_DELETE_NonBDD(){

        String token = "1148e8e6c2df68c";
        String BookingId = "2995";

        //given
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" +BookingId);
        r.cookie("token",token);
        r.contentType(ContentType.JSON);

        //when
        response =  r.when().log().all().delete();

        //then
        vr = response.then().log().all();
        vr.statusCode(201);
    }
}
