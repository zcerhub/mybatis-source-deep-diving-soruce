package com.zchuber.springsourcedeepdiving.tx;

import org.springframework.expression.AccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserService {

    private JdbcTemplate JdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.JdbcTemplate=new JdbcTemplate(dataSource);
    }

    public void save(User user) throws MyException {
        JdbcTemplate.update("insert into user(name,age,sex) values(?,?,?)",
                new Object[]{user.getName(), user.getAge(), user.getSex()}, new int[]{
                        Types.VARCHAR,
                        Types.INTEGER,
                        Types.VARCHAR,
                });
        throw new RuntimeException("aa");
//        throw new MyException("aa");
    }



}
