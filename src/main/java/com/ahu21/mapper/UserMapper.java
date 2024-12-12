package com.ahu21.mapper;
import com.ahu21.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //	用户查询
    @Select("select * from User where UACCOUNT=#{username}")
    User selectByUsername(@Param("username") String username);

    @Insert("insert into User values(#{UACCOUNT},#{UPASSWORD},#{UNAME},#{UPHONE},#{UGENDER},#{UCAMPUS})")
    void add(User user);

    @Select("select * from User where UACCOUNT=#{username} and UPASSWORD=#{password}")
    User select(@Param("username")String username, @Param("password")String password);
}
