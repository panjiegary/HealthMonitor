package com.example.jie.healthmonitor.service;

import com.example.jie.healthmonitor.entity.User;

/**
 * Created by Jie on 2017-03-13.
 */

public class MySession {

    private static User user = null;

    public static void setUser(User user) {
        MySession.user = user;
    }

    public static User getUser() {
        return user;
    }
}
