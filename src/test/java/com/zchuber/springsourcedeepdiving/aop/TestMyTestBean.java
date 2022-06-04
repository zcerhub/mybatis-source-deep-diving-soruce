package com.zchuber.springsourcedeepdiving.aop;

import com.zchuber.springsourcedeepdiving.ioc.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class TestMyTestBean {

    @Test
    public void testSimpleLoad(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest-aop.xml");
        TestBean testBean = (TestBean) ac.getBean("test");
        testBean.test();
    }

    @Test
    public void testProxy(){
        UserService userService = new UserServiceImpl();

        MyInnovationHandler inh = new MyInnovationHandler(userService);

        UserService proxy= (UserService) inh.getProxy();
        proxy.test();
    }

    @Test
    public void testUserService(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest-aop.xml");
        UserService uerService = (UserService) ac.getBean("testUserService");
        uerService.test();
    }



}
