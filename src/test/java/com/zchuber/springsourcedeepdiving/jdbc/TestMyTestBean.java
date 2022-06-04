package com.zchuber.springsourcedeepdiving.jdbc;

import com.zchuber.springsourcedeepdiving.aop.MyInnovationHandler;
import com.zchuber.springsourcedeepdiving.aop.TestBean;
import com.zchuber.springsourcedeepdiving.aop.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestMyTestBean {

    @Test
    public void testSimpleLoad(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beanFactoryTest-jdbc.xml");

        UserService userService=(UserService)ac.getBean("userService");
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setSex("man");

        userService.save(user);

        List<User> personList = userService.getUsers();
        for (User u : personList) {
            System.out.println(u);
        }
    }



}
