package com.ahu21.mapper;

import com.ahu21.pojo.Manager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ahu21.pojo.User;

import java.util.List;

public interface ManagerMapper {
	@Select("select * from MANAGER where MACCOUNT=#{username} and MPASSWORD=#{password}")
	Manager select(@Param("username")String username,@Param("password")String password);

//	用户查询
    @Select("select * from MANAGER where MACCOUNT=#{username}")
	Manager selectByUsername(@Param("username") String username);

	@Insert("insert into MANAGER values(#{MACCOUNT},#{MPASSWORD})")
	void add(Manager manager);

	@Select("select * from MANAGER")
	List<Manager> selectall();

	@Delete("delete from MANAGER where MACCOUNT=#{username} and MPASSWORD=#{password}")
	void remove(@Param("username")String username,@Param("password")String password);
}
