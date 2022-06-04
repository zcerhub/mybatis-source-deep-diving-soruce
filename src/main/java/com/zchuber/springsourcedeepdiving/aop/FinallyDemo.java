package com.zchuber.springsourcedeepdiving.aop;

public class FinallyDemo {

    public String test() {
        try{
            return hello();
        }finally{
            world();
        }
    }

    private void world() {
        System.out.println("world");
    }

    private String hello() {
        System.out.println("hello");
        return "hello";
    }

    public static void main(String[] args) {
        FinallyDemo demo = new FinallyDemo();
        demo.test();
    }

}
