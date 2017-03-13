package com.example.jie.healthmonitor.dao;

/**
 * Created by Jie on 2017-03-13.
 */

public class UserScheme {

    public static final String TABLE_NAME = "user";

    public static final String ID = "id";

    public static final String FIRST_NAME = "first_name";

    public static final String LAST_NAME = "last_name";

    public static final String EMAIL = "email";

    public static final String HEALTH_CARD_NUMBER = "health_card_number";

    public static final String PASSWORD = "password";

    public static String getTableCreationSql() {
        StringBuffer sb = new StringBuffer();
        sb.append("create table user(id integer primary key autoincrement");
        sb.append(", first_name text, last_name text, email text, health_card_number text, password text)");
        return sb.toString();
    }
}
