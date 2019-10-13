package com.example.it18067316;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Database.DBHelper;

public class ProfileManagement extends AppCompatActivity {

    DBHelper db;

    EditText username, dob, password, gender;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);
        Intent intent = getIntent();

        db = new DBHelper(this, UserProfile.Users.TABLE_NAME, null, 1);

        username = findViewById(R.id.txtusername2);
        dob = findViewById(R.id.txtdob);
        password = findViewById(R.id.txtPassword2);

        String unm = intent.getStringExtra(Home.USERNAME);
        String pwd = intent.getStringExtra(Home.PASSWORD);

        username.setText(unm);
        password.setText(pwd);
    }

    public void editProfile(View view){
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

}
