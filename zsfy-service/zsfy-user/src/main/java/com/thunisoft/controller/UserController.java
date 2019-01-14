package com.thunisoft.controller;

import com.thunisoft.bean.User;
import com.thunisoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public User find(@PathVariable("id") String id) {
        return userService.findUser(id);
    }

}
