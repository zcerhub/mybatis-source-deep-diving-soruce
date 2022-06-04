package com.zchuber.springsourcedeepdiving.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;


public class TestMyBatis {

    SqlSessionFactory ssf;

    {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        ssf= new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void testInsertUser()  {
        SqlSession session = ssf.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User("tom", Integer.valueOf(5));
        userMapper.insertUser(user);
        session.commit();
        session.close();
    }

    @Test
    public void testQueryUser()  {
        SqlSession session = ssf.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user=userMapper.getUser(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testSpringMybatis()  {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryTest-mybatis.xml");
        UserMapper userDao = (UserMapper) context.getBean("userMapper");
        System.out.println(userDao.getUser(1));
    }


}
