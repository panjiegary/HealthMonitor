package com.example.jie.healthmonitor.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jie.healthmonitor.entity.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jie on 2017-03-13.
 */

public class RecordDao {

    public long add(Record record) {
        SQLiteDatabase db = DatabaseHelper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RecordScheme.HEIGHT, record.getHeight());
        values.put(RecordScheme.WEIGHT, record.getWeight());
        values.put(RecordScheme.EMAIL, record.getEmail());
        values.put(RecordScheme.CREATE_DATE, (int) (System.currentTimeMillis() / 1000L));
        long result = db.insert(RecordScheme.TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public List<Record> getRecordsByEmail(String email) {
        SQLiteDatabase db = DatabaseHelper.getInstance(null).getWritableDatabase();
        //select columns
        String[] columns = {RecordScheme.ID, RecordScheme.HEIGHT, RecordScheme.WEIGHT
                , RecordScheme.EMAIL, RecordScheme.CREATE_DATE};
        Cursor cursor = db.query(RecordScheme.TABLE_NAME, columns
                , String.format("%s = '%s'"
                        , RecordScheme.EMAIL, email)
                , null, null, null, null);
        List<Record> results = new ArrayList<Record>();
        while (cursor.moveToNext()) {
            Record curRecord = new Record();
            curRecord.setId(cursor.getInt(cursor.getColumnIndex(RecordScheme.ID)));
            curRecord.setHeight(cursor.getInt(cursor.getColumnIndex(RecordScheme.HEIGHT)));
            curRecord.setWeight(cursor.getInt(cursor.getColumnIndex(RecordScheme.WEIGHT)));
            curRecord.setEmail(cursor.getString(cursor.getColumnIndex(RecordScheme.EMAIL)));
            curRecord.setCreateDate(cursor.getInt(cursor.getColumnIndex(RecordScheme.CREATE_DATE)));
            results.add(curRecord);
        }
        db.close();
        return results;
    }

}
