package com.whu.cloudstudy_server.controller;

import com.whu.cloudstudy_server.Response;
import com.whu.cloudstudy_server.entity.User;
import com.whu.cloudstudy_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        }
        else if (type == 1) {  // 按用户名查找
            List<User> users = userService.findUserByName(name);
            if (users == null) {
                response = new Response(-1, "失败", null);
                return response;
            }
            response = new Response(0, "成功", users);
            return response;
        }
        else {
            response = new Response(-1, "失败", null);
            return response;
        }
    }
}
