package com.zchuber.springsourcedeepdiving.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceportImpl());

        EnhancerDemo demo=(EnhancerDemo)enhancer.create();
        demo.test();
        System.out.println(demo);
    }


    public void  test() {
        System.out.println("test");
    }


    private static class MethodInterceportImpl implements MethodInterceptor {

        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.err.println("Before invoke "+method);
            Object result = methodProxy.invokeSuper(obj, args);
            System.out.println("After Advice "+method);
            return result;
        }
    }
}
