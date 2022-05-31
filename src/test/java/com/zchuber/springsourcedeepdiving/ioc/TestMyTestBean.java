package com.zchuber.springsourcedeepdiving.ioc;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;


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


}
