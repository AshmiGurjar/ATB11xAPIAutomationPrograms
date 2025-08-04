package com.thetestingacademy.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_TestNG {


    @Test
    public void test_hardAssert(){
        System.out.println("Start of the program");
        Boolean is_neeru_male = false;
        Assert.assertEquals("ashmi","Ashmi");
        System.out.println("End of the program");
    }

    @Test
    public void test_softAssert(){
        System.out.println("Start of the program");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("ashmi","Ashmi");
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
