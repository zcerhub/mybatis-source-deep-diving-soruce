package com.zchuber.springsourcedeepdiving.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestMyTestBean {

    @Test
    public void testSimpleLoad() throws MyException {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest-tx.xml");

        UserService userService=(UserService)ac.getBean("userService");
        User user = new User();
        user.setName("张三ccc");
        user.setAge(20);
        user.setSex("man");

        userService.save(user);

    }



}
