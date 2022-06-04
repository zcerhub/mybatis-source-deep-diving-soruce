package com.zchuber.springsourcedeepdiving.jdbc;

import com.zchuber.springsourcedeepdiving.ioc.UserManager;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserService {

    private JdbcTemplate JdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.JdbcTemplate=new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        JdbcTemplate.update("insert into user(name,age,sex) values(?,?,?)",
                new Object[]{user.getName(), user.getAge(), user.getSex()}, new int[]{
                        Types.VARCHAR,
                        Types.INTEGER,
                        Types.VARCHAR,
                });
    }

    public List<User> getUsers() {
        List<User> list = JdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }
}
