package com.thetestingacademy.ex_04_RA_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab08_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_Get_NonBDDStyle(){
        String pincode= "395005";

        //given
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when
        response = r.when().log().all().get();

        //then
        System.out.println(response.asString());
        vr=response.then().log().all().statusCode(200);
    }
}
