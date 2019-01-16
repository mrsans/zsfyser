package com.thunisoft.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thunisoft.bean.User;
import com.thunisoft.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/login/{username}/{password}")
    @ResponseBody
    public String find(@PathVariable("username") String username, @PathVariable("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

//        return userService.findUser(username);
        return stringRedisTemplate.opsForValue().get("user1");
    }


    @PostMapping(path = "/save")
    @ResponseBody
    public Map<String, Object> saveUser (User user) throws JsonProcessingException {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", userService.saveUser(user));
        stringRedisTemplate.opsForValue().set("user1", objectMapper.writeValueAsString(user));
        return resultMap;
    }


}
