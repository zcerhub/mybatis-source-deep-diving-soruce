package com.zchuber.springsourcedeepdiving.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }


    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("VAR");
    }

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory){
        super.setAllowBeanDefinitionOverriding(true);
        super.setAllowCircularReferences(true);
        super.customizeBeanFactory(beanFactory);
    }


}
