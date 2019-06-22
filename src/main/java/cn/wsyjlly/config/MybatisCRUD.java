package cn.wsyjlly.config;

import cn.wsyjlly.entity.Role;
import cn.wsyjlly.entity.User;
import cn.wsyjlly.entity.UserRole;
import cn.wsyjlly.mapper.User2Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.14 - 19:39
 * 配置启动系统参数
 * 测试Mybatis-plus QueryWrapper 查询语句筛选
 * Mybatis-plus只适用于单表查询
 **/
@Component
@Order(3)
public class MybatisCRUD implements ApplicationRunner {
    @Autowired
    private User2Mapper userMapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("------------------mybatis test--------------------");
        User user = userMapper.getUserById((long) 6);
        System.out.println(user);
        user = userMapper.getUserById2((long) 2);
        System.out.println(user);
        HashMap<String, String> map = new HashMap<>();
        map.put("id","3");
        user = userMapper.getUserById3(map);
        System.out.println(user);
        List<UserRole> userRoles= userMapper.getUserRoles((long)6);
        System.out.println(userRoles);
        List<Role> roles =  userMapper.getRoles(1);
        System.out.println(roles);
    }
}
