package com.ahu21.mapper;

import com.ahu21.pojo.Borrowaccept;
import com.ahu21.pojo.Journal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BorrowMapper {
    @Select("select * from Borrowaccept where UACCOUNT=#{UACCOUNT} AND JNO=#{jno}")
    Borrowaccept selectnull(@Param("jno") String jno, @Param("UACCOUNT")String UACCOUNT);

    @Select("select * from Borrowaccept where UACCOUNT=#{UACCOUNT}")
    List<Borrowaccept> userselectb(@Param("UACCOUNT") String UACCOUNT);

    @Select("select * from Borrowaccept where UACCOUNT LIKE CONCAT('%', #{a} , '%') or JNO LIKE CONCAT('%', #{a},'%')")
    List<Borrowaccept> managerselectb(@Param("a") String a);

    @Select("select * from Borrowaccept")
    List<Borrowaccept> selectb();

    @Insert("insert into Borrowaccept values (#{UACCOUNT},#{JNO},#{Bdate},#{Accept})")
    void insertba(Borrowaccept borrowaccept);

    @Update("update Borrowaccept set Accept=#{a} where UACCOUNT=#{UACCOUNT} and JNO=#{JNO}")
    void updateba(@Param("a") String a);
}
