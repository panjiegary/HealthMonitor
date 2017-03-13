package com.example.jie.healthmonitor.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jie on 2017-03-13.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "health-monitor.db";

    private static DatabaseHelper instance = null;

    protected DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null && context != null) {
            instance = new DatabaseHelper(context);
            return instance;
        } else {
            return instance;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(UserScheme.getTableCreationSql());
        db.execSQL(RecordScheme.getTableCreationSql());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + UserScheme.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RecordScheme.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

}
