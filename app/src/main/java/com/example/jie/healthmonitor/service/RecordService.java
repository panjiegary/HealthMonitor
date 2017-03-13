package com.example.jie.healthmonitor.service;

import com.example.jie.healthmonitor.dao.RecordDao;
import com.example.jie.healthmonitor.entity.Record;

import java.util.List;

/**
 * Created by Jie on 2017-03-13.
 */

public class RecordService {

    private RecordDao recordDao;

    public RecordService() {
        recordDao = new RecordDao();
    }

    public long addRecord(Record record) {
        return recordDao.add(record);
    }

    public List<Record> getRecordsByEmail(String email) {
        return recordDao.getRecordsByEmail(email);
    }

}
