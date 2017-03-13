package com.example.jie.healthmonitor.util;

/**
 * Created by Jie on 2017-03-13.
 */

public class Common {

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }
}
