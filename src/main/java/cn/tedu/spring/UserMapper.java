package cn.tedu.spring;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
	
	@Insert("INSERT INTO t_user (username,PASSWORD,age,phone,email)"
			+ " VALUES(#{username},#{password},#{age},#{phone},#{email})")
	Integer aaa(User user);
	
	@Delete("DELETE FROM t_user WHERE id=#{id}")
	Integer bbb(User user);
}
