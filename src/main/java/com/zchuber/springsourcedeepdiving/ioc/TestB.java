package com.zchuber.springsourcedeepdiving.ioc;

public class TestB {

    private TestC testc;

    public TestB(TestC testC) {
        this.testc = testc;
    }

    public void b() {
        testc.c();
    }

    public void setTestc(TestC testc) {
        this.testc = testc;
    }

    public TestC getTestc() {
        return testc;
    }
}
