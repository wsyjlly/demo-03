package cn.wsyjlly.service;

import cn.wsyjlly.entity.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    List<User> getUsers(User user);
}