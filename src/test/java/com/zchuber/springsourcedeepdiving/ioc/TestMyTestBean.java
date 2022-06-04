package com.zchuber.springsourcedeepdiving.ioc;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.Date;


public class TestMyTestBean {

    @Test
    public void testSimpleLoad(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean testBean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr", testBean.getTestStr());
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        TestA testBean = (TestA) bf.getBean("testA");
    }

    @Test
    public void testCircleBySetter(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        TestA testA = (TestA) bf.getBean("testA");
        System.out.println(testA);
    }

    @Test
    public void testApplicationContext(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
    }

    @Test
    public void testDate(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        UserManager userManager = (UserManager) ac.getBean("userManager");
        System.out.println(userManager);
    }

    @Test
    public void testHelloMsg(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        HelloMessage msg = (HelloMessage) ac.getBean("helloMsg");
        System.out.println(msg.getMes());
    }

    @Test
    public void testSensitiveWord(){
        ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        SensitiveWordRemovingBeanFactoryPostProcessor swr = (SensitiveWordRemovingBeanFactoryPostProcessor) bf.getBean("swr");
        swr.postProcessBeanFactory(bf);
        SimplePostProcessor spp = (SimplePostProcessor) bf.getBean("spp");
        System.out.println(spp);
    }


    @Test
    public void testMyTestBean(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        MyTestBean msg = (MyTestBean) ac.getBean("myTestBean");
    }

    @Test
    public void testMyTestEvent(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        TestEvent event = new TestEvent("hello", "msg");
        ac.publishEvent(event);
    }

    @Test
    public void testStringDateConvert(){
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());
        String dateStr = "2022-06-03";
        Date date=conversionService.convert(dateStr, Date.class);
        System.out.println(date);
    }

    @Test
    public void testStringDateConvertUserManager(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        UserManager userManager = (UserManager) ac.getBean("userManager");
        System.out.println(userManager);
    }

}
