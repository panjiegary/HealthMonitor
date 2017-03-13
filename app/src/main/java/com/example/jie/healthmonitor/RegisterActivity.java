package com.example.jie.healthmonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jie.healthmonitor.entity.User;
import com.example.jie.healthmonitor.service.UserService;
import com.example.jie.healthmonitor.util.Common;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void addUser(View view) {
        EditText editText = (EditText) findViewById(R.id.password);
        String password = editText.getText().toString();
        if (Common.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please input password", Toast.LENGTH_SHORT).show();
            return;
        }
        //
        editText = (EditText) findViewById(R.id.repassword);
        String repassword = editText.getText().toString();
        //
        editText = (EditText) findViewById(R.id.firstName);
        String firstName = editText.getText().toString();
        if (Common.isEmpty(firstName)) {
            Toast.makeText(getApplicationContext(), "Please input first name", Toast.LENGTH_SHORT).show();
            return;
        }
        //
        editText = (EditText) findViewById(R.id.lastName);
        String lastName = editText.getText().toString();
        if (Common.isEmpty(lastName)) {
            Toast.makeText(getApplicationContext(), "Please input last name", Toast.LENGTH_SHORT).show();
            return;
        }
        //
        editText = (EditText) findViewById(R.id.email);
        String email = editText.getText().toString();
        if (Common.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please input email", Toast.LENGTH_SHORT).show();
            return;
        }
        //
        editText = (EditText) findViewById(R.id.healthCardNumber);
        String healthCardNumber = editText.getText().toString();
        if (Common.isEmpty(healthCardNumber)) {
            Toast.makeText(getApplicationContext(), "Please input health card number", Toast.LENGTH_SHORT).show();
            return;
        }
        //
        if (!password.equals(repassword)) {
            Toast.makeText(getApplicationContext(), "Please repeat password", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setHealthCardNumber(healthCardNumber);
        user.setPassword(password);
        user.setFirstName(editText.getText().toString());
        UserService userService = new UserService();
        long result = userService.addUser(user);
        if (result == -1) {
            Toast.makeText(getApplicationContext(), "Create user failed", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Intent intent = new Intent(this, RecordActivity.class);
            startActivity(intent);
            //Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
        }
    }
}
