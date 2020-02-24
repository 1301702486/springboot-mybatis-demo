package com.whu.cloudstudy_server.mapper;

import com.whu.cloudstudy_server.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //User findUserById(Integer id);
    User findUserByEmail(String email);
    List<User> findUserByName(String name);
//    void insertUser(User user);
//    void deleteUser(User user);
//    void updateUserInfo(User user);
}
