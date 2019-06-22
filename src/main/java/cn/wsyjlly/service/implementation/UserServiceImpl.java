package cn.wsyjlly.service.implementation;

import cn.wsyjlly.entity.User;
import cn.wsyjlly.mapper.UserMapper;
import cn.wsyjlly.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.16 - 17:02
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> getUsers(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        queryWrapper.setEntity(user);
        System.out.println(queryWrapper);
        return userMapper.selectList(queryWrapper);
    }

}
