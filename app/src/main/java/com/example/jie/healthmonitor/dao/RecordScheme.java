package com.example.jie.healthmonitor.dao;

/**
 * Created by Jie on 2017-03-13.
 */

public class RecordScheme {

    public static final String TABLE_NAME = "record";

    public static final String ID = "id";

    public static final String HEIGHT = "height";

    public static final String WEIGHT = "weight";

    public static final String EMAIL = "email";

    public static final String CREATE_DATE = "create_date";

    public static String getTableCreationSql() {
        StringBuffer sb = new StringBuffer();
        sb.append("create table record(id integer primary key autoincrement");
        sb.append(", height integer, weight integer, email text, create_date integer)");
        return sb.toString();
    }

}
