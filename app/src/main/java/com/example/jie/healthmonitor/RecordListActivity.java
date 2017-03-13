package com.example.jie.healthmonitor;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.jie.healthmonitor.entity.Record;
import com.example.jie.healthmonitor.service.MySession;
import com.example.jie.healthmonitor.service.RecordService;

import java.util.List;

public class RecordListActivity extends AppCompatActivity {

    private RecordService recordService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
        recordService = new RecordService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Record> records = recordService.getRecordsByEmail(MySession.getUser().getEmail());
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getBmiDisplayStrings(records));
        ListView listView = (ListView) findViewById(R.id.record_listView);
        listView.setAdapter(listAdapter);
    }

    private String[] getBmiDisplayStrings(List<Record> records) {
        int size = records.size();
        String[] bmi = new String[records.size()];
        for (int i = 0; i < size; i++) {
            double heightFactor = records.get(i).getHeight() * records.get(i).getHeight() / 10000;
            bmi[i] = String.format("Height:%d Weight:%d \nBMI:%.2f"
                    , records.get(i).getHeight(), records.get(i).getWeight()
                    , records.get(i).getWeight() / (heightFactor * heightFactor));
        }
        return bmi;
    }

}
