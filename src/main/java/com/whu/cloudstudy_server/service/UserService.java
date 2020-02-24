package com.whu.cloudstudy_server.service;

import com.whu.cloudstudy_server.entity.User;
import com.whu.cloudstudy_server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    public List<User> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }
}
