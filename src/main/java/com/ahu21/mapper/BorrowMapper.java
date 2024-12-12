package com.ahu21.mapper;

import com.ahu21.pojo.Borrow;
import com.ahu21.pojo.Journal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowMapper {
    @Select("select * from Borrow where UACCOUNT=#{UACCOUNT}")
    Borrow userselectb(@Param("UACCOUNT") String UACCOUNT);

    @Select("select * from Borrow where UACCOUNT LIKE CONCAT('%', #{a} , '%') or JNO LIKE CONCAT('%', #{a},'%')")
    Borrow managerselectb(@Param("a") String a);

    @Select("select * from Borrow")
    List<Journal> selectall();


}
