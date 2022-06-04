package com.zchuber.springsourcedeepdiving.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInnovationHandler implements InvocationHandler {


    private Object target;

    public MyInnovationHandler( Object target ) {
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("------------------------------before-------------------");

        Object result = method.invoke(target, args);

        System.out.println("------------------------------after-------------------");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),
                this);
    }

}
