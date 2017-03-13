package com.example.jie.healthmonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jie.healthmonitor.dao.DatabaseHelper;
import com.example.jie.healthmonitor.entity.User;
import com.example.jie.healthmonitor.service.UserService;
import com.example.jie.healthmonitor.util.Common;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper.getInstance(this);
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
    }

    public void signIn(View view) {
        UserService userService = new UserService();
        User user = new User();
        //
        EditText editText = (EditText) findViewById(R.id.main_email);
        String email = editText.getText().toString();
        if (Common.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please input email", Toast.LENGTH_SHORT).show();
            return;
        }
        //
        editText = (EditText) findViewById(R.id.main_password);
        String password = editText.getText().toString();
        if (Common.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please input password", Toast.LENGTH_SHORT).show();
            return;
        }
        user.setEmail(email);
        user.setPassword(password);
        userService.signIn(user);
        if (user.getId() != -1) {
            Intent intent = new Intent(this, RecordActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
