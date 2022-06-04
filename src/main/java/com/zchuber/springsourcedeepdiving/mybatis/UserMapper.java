package com.zchuber.springsourcedeepdiving.mybatis;

public interface UserMapper {

    void insertUser(User user);

    User getUser(Integer id);

}
