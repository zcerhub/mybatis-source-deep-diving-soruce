package com.zchuber.springsourcedeepdiving.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AServiceImpl implements AService {

    @Transactional(propagation= Propagation.REQUIRED)
    public void a() {
//        this.b();
        ((AService)AopContext.currentProxy()).b();
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void b() {

    }
}
