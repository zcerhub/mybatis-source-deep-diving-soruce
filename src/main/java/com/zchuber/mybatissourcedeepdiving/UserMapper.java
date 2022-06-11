package com.zchuber.mybatissourcedeepdiving;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<UserEntity> listAllUser();

    @Select("select * from user where ${asdf} id=#{userId,jdbcType=INTEGER}")
    UserEntity findUserByUserId(@Param("userId")int userId,String name);

    List<UserEntity> getUserByEntity(@Param("id")Integer userId,@Param("name")String name,@Param("phone")String phone);

    List<UserEntity> getUserInfo(@Param("id")Integer userId,@Param("name")String name,@Param("phone")String phone);

    List<UserEntity> getUserByPhone(@Param("phones")List<String> phones);

    @Select("<script>"+
            "select * from user \n"+
            "<where>\n"+
            "   <if test=\"name != null\">"+
            "       AND name= #{name}" +
            "   </if>"+
            "   <if test=\"phone != null\">"+
            "       AND phone= #{phone}"+
            "   </if>"+
            "</where>"+
    "</script>"
    )
    UserEntity getUserByPhoneAndName(@Param("phone")String phone,@Param("name")String name);

}
