package com.thetestingacademy.ex_02_RA_Concepts;

public class Lab03_NoDesignPattern {
    //NoDesignPattern

    public  void Step1(){
        System.out.println("Step 1");
    }
    public  void Step2(){
        System.out.println("Step 2");
    }
    public  void Step3(String param1){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        Lab03_NoDesignPattern ndp = new Lab03_NoDesignPattern();
        ndp.Step1();
        ndp.Step2();
        ndp.Step3("Ashmi");
    }
}