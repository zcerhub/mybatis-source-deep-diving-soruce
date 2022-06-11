package com.zchuber.mybatissourcedeepdiving;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.*;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.CacheBuilder;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class TestMyBatis {

    @Test
    public void testInsertUser()  {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<UserEntity> userList= userMapper.listAllUser();
        System.out.println(JSON.toJSONString(userList));
    }

    @Test
    public void testExecutor() throws SQLException {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        Configuration configguration = session.getConfiguration();
        MappedStatement listAllUserStmt = configguration.getMappedStatement("com.zchuber.mybatissourcedeepdiving.UserMapper.listAllUser");
        Executor reuseExecutor = configguration.newExecutor(new JdbcTransaction(session.getConnection()), ExecutorType.REUSE);
        List<UserEntity> userList = reuseExecutor.query(listAllUserStmt, null, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
        System.out.println(JSON.toJSONString(userList));
    }

    @Test
    public void testConfiguration() throws SQLException, IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        XMLConfigBuilder builder = new XMLConfigBuilder(reader);
        Configuration configuration = builder.parse();
    }

    @Test
    public void testSqlSession() throws SQLException, IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        List<UserEntity> userEntity=session.selectList("com.zchuber.mybatissourcedeepdiving.UserMapper.listAllUser");
        System.out.println(JSON.toJSONString(userEntity));
    }

    @Test
    public void testMapper() throws SQLException {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        Configuration configguration = session.getConfiguration();
        UserMapper usermapper = session.getMapper(UserMapper.class);
        List<UserEntity> userList = usermapper.listAllUser();
    }

    @Test
    public void testFindByUserId() throws SQLException {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        Configuration configguration = session.getConfiguration();
        UserMapper usermapper = session.getMapper(UserMapper.class);
        UserEntity userEntity = usermapper.findUserByUserId(2,null);
        System.out.println(userEntity);
    }


    @Test
    public void tesetCache() {
        final int N=100000;
        Cache cache = new PerpetualCache("default");
        cache = new LruCache(cache);
        cache = new FifoCache(cache);
        cache = new SoftCache(cache);
        cache = new WeakCache(cache);
        cache = new ScheduledCache(cache);
        cache = new SerializedCache(cache);
        cache = new SynchronizedCache(cache);
        cache = new TransactionalCache(cache);
        for (int i = 0; i < N; i++) {
            cache.putObject(i,i);
            ((TransactionalCache)cache).commit();
        }
        System.out.println(cache.getSize());
    }

    @Test
    public void tesetCacheBuilder() {
        final int N=100000;
        Cache cache = new CacheBuilder("com.zchuber.mybatissourcedeepdiving.UserMapper")
                .implementation(PerpetualCache.class)
                .addDecorator(LruCache.class)
                .clearInterval(10 * 60L)
                .size(1024)
                .readWrite(false)
                .blocking(false)
                .properties(null)
                .build();
        for (int i = 0; i < N; i++) {
            cache.putObject(i,i);
        }
        System.out.println(cache.getSize());
    }


    @Test
    public void testDynamicSql() throws SQLException, IOException {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<UserEntity> userList = userMapper.getUserByEntity(null, "User1", null);
//        List<UserEntity> userList = userMapper.getUserByEntity(null, null, "111111111111");
//        List<UserEntity> userList = userMapper.getUserByEntity(1, null, "111111111111");
        System.out.println(JSON.toJSONString(userList));
    }


    @Test
    public void testDynamicSqlChoose() throws SQLException, IOException {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        List<UserEntity> userList = userMapper.getUserInfo(null, null, null);
//        List<UserEntity> userList = userMapper.getUserInfo(null, null, "111111111111");
//        List<UserEntity> userList = userMapper.getUserInfo(1, "User1",null);
        List<UserEntity> userList = userMapper.getUserInfo(null, "User1",null);
//        List<UserEntity> userList = userMapper.getUserInfo(1, null, "111111111111");
        System.out.println(JSON.toJSONString(userList));
    }





    @Test
    public void testgetUserByPhone() throws SQLException, IOException {
        String resource = "mybatis-config.xml";
        Reader reader = new BufferedReader(
                new InputStreamReader(TestMyBatis.class.getClassLoader().getResourceAsStream(resource)));
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        List<UserEntity> userList = userMapper.getUserInfo(null, null, null);
//        List<UserEntity> userList = userMapper.getUserInfo(null, null, "111111111111");
//        List<UserEntity> userList = userMapper.getUserInfo(1, "User1",null);
        List<String> phones = Arrays.asList("111111111111", "222222222222", "333333333333");
        List<UserEntity> userList = userMapper.getUserByPhone(phones);
//        List<UserEntity> userList = userMapper.getUserInfo(1, null, "111111111111");
        System.out.println(JSON.toJSONString(userList));
    }

}
