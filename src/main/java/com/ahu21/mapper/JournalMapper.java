package com.ahu21.mapper;

import com.ahu21.pojo.Journal;
import com.ahu21.pojo.Class;
import com.ahu21.pojo.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface JournalMapper {
    @Select("select * from JOURNAL where JNO=#{jno}")
    Journal select(@Param("jno") String jno);

    @Select("select * from JOURNAL where JNAME=#{jname}")
    Journal selectname(@Param("jname") String jname);
    @Select("select * from JOURNAL")
    List<Journal> selectall();

    @Select("select * from JOURNAL where JNAME LIKE CONCAT('%', #{j} , '%') or JPLACE LIKE CONCAT('%', #{j},'%')")
    List<Journal> selecttill(@Param("j") String j);

    @Delete("delete from JOURNAL where JNO=#{jno}")
    void remove(@Param("jno")String jno);

    @Update("UPDATE JOURNAL SET JNAME = 'JNAME',JPOST = 'JPOST',JYEAR = 'JYEAR',JPUBLISH = 'JPUBLISH',JCATEGORYNAME = 'JCATEGORYNAME',JJUAN = 'JUAN',JQI = 'JQI',JPLACE = 'JPLACE',JPATH = 'JPATH' WHERE JNO=#{JNO}")
    void updata(Journal journal);

    @Insert("INSERT INTO JOURNAL VALUES (#{JNO}, #{JNAME}, #{JPOST}, #{JYEAR}, #{JPUBLISH}, #{JTYPE}, #{JCATEGORYNAME}, #{JJUAN}, #{JQI}, #{JPLACE}, #{JPATH})")
    void insert(Journal journal);

    @Select("select * from Class")
    List<Class> selectCategory();

    @Select("select * from Place")
    List<Place> SelectPlace();
}
