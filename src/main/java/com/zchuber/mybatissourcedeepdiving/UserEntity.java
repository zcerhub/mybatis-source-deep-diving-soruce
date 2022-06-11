package com.zchuber.mybatissourcedeepdiving;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserEntity {

    private Long id;
    private String name;
    private Data createTime;
    private String password;
    private String phone;
    private String nickName;


}
