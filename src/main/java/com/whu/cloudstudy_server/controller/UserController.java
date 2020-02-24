package com.whu.cloudstudy_server.controller;

import com.whu.cloudstudy_server.Response;
import com.whu.cloudstudy_server.entity.User;
import com.whu.cloudstudy_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findUser")
    public Response findUser(Integer type, String name) {
        Response response;
        if (type == 0) {  // 按邮箱查找
            User user = userService.findUserByEmail(name);
            if (user == null) {
                response = new Response(-1, "失败", null);
                return response;
            }
            response = new Response(0, "成功", user);
            return response;
        } else if (type == 1) {  // 按用户名查找
            List<User> users = userService.findUserByName(name);
            if (users == null) {
                response = new Response(-1, "失败", null);
                return response;
            }
            response = new Response(0, "成功", users);
            return response;
        } else {
            response = new Response(-1, "失败", null);
            return response;
        }
    }

    @PutMapping(value = "/modifyUserInfo")
    public Response updateUserInfo(Integer id, Integer type, String content) {
        User user = userService.findUserById(id);
        Response response;
        if (user != null) {
            switch (type){
                case 0:  // 用户名
                    user.setName(content);
                    break;
                case 1:  // 性别
                    user.setSex(content.toCharArray()[0]);
                    break;
                case 2:  // 年龄
                    user.setAge(Integer.parseInt(content));
                    break;
                case 3:  // 个性签名
                    user.setSignature(content);
                    break;
                default:
                    response = new Response(-1, "失败", null);
                    return response;
            }
            userService.updateUserInfo(user);
            response = new Response(0, "成功", null);
        }
        else {
            response = new Response(-1, "失败", null);
        }
        return response;
    }

    @PostMapping(value = "/addUser")
    public Response addUser(String name, String password, Character gender, Integer age, String email, String introduction) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setSex(gender);
        user.setAge(age);
        user.setEmail(email);
        user.setSignature(introduction);
        userService.insertUser(user);
        Response response = new Response(0, "成功", null);
        return response;
    }
}
