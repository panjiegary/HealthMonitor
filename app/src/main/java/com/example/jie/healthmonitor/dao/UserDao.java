package com.example.jie.healthmonitor.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jie.healthmonitor.entity.User;

/**
 * Created by Jie on 2017-03-13.
 */

public class UserDao {

    public long add(User user) {
        SQLiteDatabase db = DatabaseHelper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserScheme.EMAIL, user.getEmail());
        values.put(UserScheme.FIRST_NAME, user.getFirstName());
        values.put(UserScheme.LAST_NAME, user.getLastName());
        values.put(UserScheme.HEALTH_CARD_NUMBER, user.getHealthCardNumber());
        values.put(UserScheme.PASSWORD, user.getPassword());
        long result = db.insert(UserScheme.TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public User getUserByEmailAndPassword(User user) {
        SQLiteDatabase db = DatabaseHelper.getInstance(null).getWritableDatabase();
        //select columns
        String[] columns = {UserScheme.ID, UserScheme.FIRST_NAME, UserScheme.LAST_NAME
            , UserScheme.HEALTH_CARD_NUMBER};
        Cursor cursor = db.query(UserScheme.TABLE_NAME, columns
                , String.format("%s = '%s' and %s = '%s'"
                        , UserScheme.EMAIL, user.getEmail()
                        , UserScheme.PASSWORD, user.getPassword())
                , null, null, null, null);
        if (cursor.moveToNext()) {
            user.setId(cursor.getInt(cursor.getColumnIndex(UserScheme.ID)));
            user.setFirstName(cursor.getString(cursor.getColumnIndex(UserScheme.FIRST_NAME)));
            user.setLastName(cursor.getString(cursor.getColumnIndex(UserScheme.LAST_NAME)));
            user.setHealthCardNumber(cursor.getString(cursor.getColumnIndex(UserScheme.HEALTH_CARD_NUMBER)));
        }
        db.close();
        return user;
    }

}
