package com.ahu21.mapper;

import com.ahu21.pojo.Journal;
import com.ahu21.pojo.Return;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ReturnMapper {

    @Select("select * from Return where UACCOUNT=#{UACCOUNT}")
    Return userselectb(@Param("UACCOUNT") String UACCOUNT);

    @Select("select * from Return where UACCOUNT LIKE CONCAT('%', #{a} , '%') or JNO LIKE CONCAT('%', #{a},'%')")
    Return managerselectb(@Param("a") String a);

    @Select("select * from Return")
    List<Journal> selectall();



}
