package com.ahu21.mapper;

import com.ahu21.pojo.Borrowaccept;
import com.ahu21.pojo.Borrowinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BorrowMapper {
    @Select("select * from Borrowaccept where UACCOUNT=#{UACCOUNT} AND JNO=#{jno}")
    Borrowaccept selectnull(@Param("jno") String jno, @Param("UACCOUNT")String UACCOUNT);

    @Select("SELECT Borrowaccept.UACCOUNT, JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Borrowaccept.Bdate, Borrowaccept.Accept FROM JOURNAL JOIN Borrowaccept ON JOURNAL.JNO = Borrowaccept.JNO WHERE Borrowaccept.UACCOUNT = #{UACCOUNT}")
    List<Borrowinfo> userselectb(@Param("UACCOUNT") String UACCOUNT);

    @Select("select * from Borrowaccept where UACCOUNT LIKE CONCAT('%', #{a} , '%') or JNO LIKE CONCAT('%', #{a},'%')")
    List<Borrowaccept> managerselectb(@Param("a") String a);

    @Select("SELECT Borrowaccept.UACCOUNT,JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Borrowaccept.Bdate, Borrowaccept.Accept FROM JOURNAL JOIN Borrowaccept ON JOURNAL.JNO = Borrowaccept.JNO WHERE Borrowaccept.UACCOUNT LIKE CONCAT('%', #{a} , '%') or Borrowaccept.JNO LIKE CONCAT('%', #{a},'%') AND Borrowaccept.Accept = '未审核'")
    List<Borrowinfo> managerselectba(@Param("a") String a);

    @Select("SELECT Borrowaccept.UACCOUNT,JOURNAL.JNO, JOURNAL.JNAME, JOURNAL.JTYPE, JOURNAL.JCATEGORYNAME, JOURNAL.JJUAN, JOURNAL.JQI, JOURNAL.JPLACE, Borrowaccept.Bdate, Borrowaccept.Accept FROM JOURNAL JOIN Borrowaccept ON JOURNAL.JNO = Borrowaccept.JNO WHERE Borrowaccept.Accept = '未审核'")
    List<Borrowinfo> selectb();

    @Insert("insert into Borrowaccept values (#{UACCOUNT},#{JNO},#{Bdate},#{Accept})")
    void insertba(Borrowaccept borrowaccept);

    @Update("update Borrowaccept set Accept='通过' where UACCOUNT=#{UACCOUNT} and JNO=#{JNO}")
    void updateba(@Param("UACCOUNT") String UACCOUNT,@Param("JNO") String JNO);
}
