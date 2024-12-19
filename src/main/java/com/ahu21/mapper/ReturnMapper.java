package com.ahu21.mapper;

import com.ahu21.pojo.Return;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface ReturnMapper {

    @Select("SELECT Return.UACCOUNT,JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Return.Rdate, Return.Accept FROM JOURNAL JOIN Return ON JOURNAL.JNO = Return.JNO where Return.UACCOUNT LIKE CONCAT('%', #{a} , '%') or Return.JNO LIKE CONCAT('%', #{a},'%')")
    List<Return> manaagerselectr(@Param("a") String a);

    @Select("SELECT Return.UACCOUNT,JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Return.Rdate, Return.Accept FROM JOURNAL JOIN Return ON JOURNAL.JNO = Return.JNO")
    List<Return> selectr();

    @Select("select * from Borrowaccept where UACCOUNT=#{UACCOUNT} and JNO=#{JNO} and Accept='通过'")
    Return select1(@Param("UACCOUNT") String UACCOUNT,@Param("JNO") String JNO);

    @Insert("insert into Return values(#{UACCOUNT},#{JNO},#{JDATE},#{Accept})")
    void insert(Return return1);

    @Update("update Return set Accept='已归还' where UACCOUNT=#{UACCOUNT} and JNO=#{JNO}")
    void update(@Param("UACCOUNT") String UACCOUNT,@Param("JNO") String JNO);
}
