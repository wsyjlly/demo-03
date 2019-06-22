package cn.wsyjlly.mapper;

import cn.wsyjlly.entity.Role;
import cn.wsyjlly.entity.User;
import cn.wsyjlly.entity.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface User2Mapper {
	@Select("SELECT * FROM user WHERE id=#{userID}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "username", property = "username"),
			@Result(column = "password", property = "password"),
			@Result(column = "enable", property = "enable"),
			@Result(column = "locked", property = "locked"),
			@Result(column = "id", property = "userRoles",many=@Many(select="cn.wsyjlly.mapper.User2Mapper.getUserRoles")),
	})
	User getUserById(@Param("userID") Long userID);



	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "username", property = "username"),
			@Result(column = "password", property = "password"),
			@Result(column = "enable", property = "enable"),
			@Result(column = "locked", property = "locked")
	})
	User getUserById2(@Param("id") Long id);



	@Select("SELECT * FROM user WHERE id=#{id}")
	User getUserById3(Map<String, String> map);


	@Select("SELECT * FROM user_role WHERE uid=#{uid}")
	@Results({
			@Result(column = "rid", property = "rid"),
			@Result(column = "rid", property = "role",one=@One(select="cn.wsyjlly.mapper.User2Mapper.getRoles")),
	})
	List<UserRole> getUserRoles(@Param("uid") Long uid);

	@Select("SELECT * FROM role WHERE id=#{rid}")
	@Results({
			@Result(column = "name_des", property = "name_des"),
	})
	List<Role> getRoles(@Param("rid") Integer rid);
	

	@Insert("INSERT INTO user(username,password) VALUES(#{username},#{password})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertUser(User user);
}
