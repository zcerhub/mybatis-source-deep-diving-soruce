package com.zchuber.springsourcedeepdiving.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* com..*.test(..))")
    public void test() {
    }



    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("afterTest");
    }



    @AfterReturning("test()")
    public void afteReturningTest() {
        System.out.println("afteReturningTest");
    }

    @AfterThrowing("test()")
    public void afterThrowingTest() {
        System.out.println("afterThrowingTest");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("before1");

        Object o=null;
        try{
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

}
