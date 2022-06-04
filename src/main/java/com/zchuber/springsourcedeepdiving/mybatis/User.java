package com.zchuber.springsourcedeepdiving.mybatis;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name=name;
        this.age=age;
    }


}
