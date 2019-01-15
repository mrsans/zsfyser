package com.thunisoft.service;

import com.thunisoft.bean.User;

public interface IUserService {
    User login(String username);
    User findUser(String id);
    boolean saveUser(User user);
}
