package com.zchuber.springsourcedeepdiving.ioc;

public class TestA {

    private TestB testB;


    public void a() {
        testB.b();
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }

    public TestB getTestB() {
        return testB;
    }

}
