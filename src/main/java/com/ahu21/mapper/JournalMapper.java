package com.ahu21.mapper;

import com.ahu21.pojo.Journal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface JournalMapper {
    @Select("select * from JOURNAL where JNO=#{jno}")
    Journal select(@Param("jno") String jno);

    @Select("select * from JOURNAL")
    List<Journal> selectall();

    @Select("select * from JOURNAL where JNAME LIKE CONCAT('%', #{j} , '%') or JPLACE LIKE CONCAT('%', #{j},'%')")
    List<Journal> selecttill(@Param("j") String j);

    @Delete("delete from JOURNAL where JNO=#{JNO}")
    void remove(@Param("jno")String jno);

    @Update("UPDATE JOURNAL SET JNAME = 'JNAME',JPOST = 'JPOST',JYEAR = 'JYEAR',JPUBLISH = 'JPUBLISH',JCATEGORYNO = 'JCATEGORYNO',JCATEGORYNAME = 'JCATEGORYNAME',JJUAN = 'JUAN',JQI = 'JQI',JPLACE = 'JPLACE',JPATH = 'JPATH' WHERE JNO=#{JNO}")
    void updata(Journal journal);
}
