package com.zchuber.springsourcedeepdiving.ioc;

public class TestB {

    private TestC testC;


    public void b() {
        testC.c();
    }

    public void setTestC(TestC testc) {
        this.testC = testc;
    }

    public TestC getTestC() {
        return testC;
    }
}
