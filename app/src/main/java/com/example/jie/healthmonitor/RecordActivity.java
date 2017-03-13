package com.example.jie.healthmonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jie.healthmonitor.entity.Record;
import com.example.jie.healthmonitor.service.MySession;
import com.example.jie.healthmonitor.service.RecordService;
import com.example.jie.healthmonitor.util.Common;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
    }

    public void add(View view) {
        RecordService recordService = new RecordService();
        Record record = new Record();
        //
        EditText editText = (EditText) findViewById(R.id.record_height);
        String heightStr = editText.getText().toString();
        if (Common.isEmpty(heightStr)) {
            Toast.makeText(getApplicationContext(), "Please input height", Toast.LENGTH_SHORT).show();
            return;
        }
        int height = Integer.parseInt(heightStr);
        //
        editText = (EditText) findViewById(R.id.record_weight);
        String weightStr = editText.getText().toString();
        if (Common.isEmpty(weightStr)) {
            Toast.makeText(getApplicationContext(), "Please input weight", Toast.LENGTH_SHORT).show();
            return;
        }
        int weight = Integer.parseInt(weightStr);
        //
        record.setEmail(MySession.getUser().getEmail());
        record.setHeight(height);
        record.setWeight(weight);
        long result = recordService.addRecord(record);
        if (result != -1) {
            Intent intent = new Intent(this, RecordListActivity.class);
            startActivity(intent);
        }
    }
}
