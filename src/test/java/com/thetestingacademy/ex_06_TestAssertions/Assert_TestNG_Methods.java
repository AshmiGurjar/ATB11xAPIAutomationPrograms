package com.thetestingacademy.ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_TestNG_Methods {

    @Test
    public void assertEquals(){
        String actualTitle = "Ex domain";
        String expectedTitle = "Example Domain";
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
    }

    @Test
    public void assertNotEquals() {
        String currentUrl = "https://wrongtest.com";
        String wrongUrl = "https://wrong.com";
        Assert.assertNotEquals(currentUrl, wrongUrl, "Unexpected URL!");
    }

    @Test
    public void assertTrue(){
        String text = "Hi,Hello... ";
        Assert.assertTrue(text.contains("Hi"), "Text is not displayed!");
    }

    @Test
     public void assertNotTrue(){
        String text = "Hi,Hello... ";
        Assert.assertFalse(text.contains("Hi"), "Text is not displayed!");
    }

    @Test
    public  void assertNull() {
        String errorMessage = null; // simulate something not initialized
        Assert.assertNull(errorMessage, "Error message should be null");
    }

    @Test
    public  void assertNotNull() {
        String errorMessage = null; // simulate something not initialized
        Assert.assertNull(errorMessage, "Error message should not be null");
    }

    @Test
    public  void assertFail() {
        String s = "abc";
        String a = "test";
    if (s.contains(a)) {
        Assert.fail("Critical condition failed!");
    }}
}
