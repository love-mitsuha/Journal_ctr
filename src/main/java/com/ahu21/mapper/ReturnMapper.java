package com.ahu21.mapper;

import com.ahu21.pojo.Returnaccept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface ReturnMapper {

    @Select("SELECT Returnaccept.UACCOUNT,JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Returnaccept.Rdate, Returnaccept.Accept FROM JOURNAL JOIN Returnaccept ON JOURNAL.JNO = Returnaccept.JNO where Returnaccept.UACCOUNT LIKE CONCAT('%', #{a} , '%') or Returnaccept.JNO LIKE CONCAT('%', #{a},'%')")
    List<Returnaccept> manaagerselectr(@Param("a") String a);

    @Select("SELECT Returnaccept.UACCOUNT,JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Returnaccept.Rdate, Returnaccept.Accept FROM JOURNAL JOIN Returnaccept ON JOURNAL.JNO = Returnaccept.JNO")
    List<Returnaccept> selectr();

    @Select("select * from Borrowaccept where UACCOUNT=#{UACCOUNT} and JNO=#{JNO} and Accept='通过'")
    Returnaccept select1(@Param("UACCOUNT") String UACCOUNT, @Param("JNO") String JNO);

    @Insert("insert into Returnaccept values (#{UACCOUNT},#{JNO},#{Rdate},#{Accept})")
    void insert1(Returnaccept returnaccept);

    @Update("update Returnaccept set Accept='已归还' where UACCOUNT=#{UACCOUNT} and JNO=#{JNO}")
    void update(@Param("UACCOUNT") String UACCOUNT,@Param("JNO") String JNO);

}
