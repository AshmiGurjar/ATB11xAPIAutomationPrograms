package com.thetestingacademy.ex_02_RA_Concepts;

public class Lab04_BuilderPattern {
    public Lab04_BuilderPattern step1(){
        System.out.println("Step1");
        return this;
    }

    public Lab04_BuilderPattern step2(){
        System.out.println("Step 2");
        return this;
    }
    public Lab04_BuilderPattern step3(String param){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        Lab04_BuilderPattern BP = new Lab04_BuilderPattern();
        BP.step1().step2().step3("Ashmi");
    }

}
