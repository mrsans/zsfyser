package com.thunisoft.service.impl;

import com.thunisoft.bean.User;
import com.thunisoft.dao.UserDao;
import com.thunisoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String id) {
        final User user = userDao.findUser(id);
        return user;
    }
}
