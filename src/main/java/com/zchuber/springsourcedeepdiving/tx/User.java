package com.zchuber.springsourcedeepdiving.tx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {

    private int id;
    private String name;
    private int age;
    private String sex;


    public User() {

    }
}
