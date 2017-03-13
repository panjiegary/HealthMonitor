package com.example.jie.healthmonitor.service;

import com.example.jie.healthmonitor.dao.UserDao;
import com.example.jie.healthmonitor.entity.User;

/**
 * Created by Jie on 2017-03-13.
 */

public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public long addUser(User user) {
        long result = userDao.add(user);
        if (result != -1) {
            user.setId((int)result);
            MySession.setUser(user);
        }
        return result;
    }

    public User signIn(User user) {
        user.setId(-1);
        userDao.getUserByEmailAndPassword(user);
        if (user.getId() != -1) {
            MySession.setUser(user);
        }
        return user;
    }
}
