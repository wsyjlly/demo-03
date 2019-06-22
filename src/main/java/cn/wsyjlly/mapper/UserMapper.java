package cn.wsyjlly.mapper;

import cn.wsyjlly.entity.Role;
import cn.wsyjlly.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User loadUserByUsername(String username);
    List<Role> getUserRoleByUid(Long id);

}