package com.example.it18067316;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHelper;

public class Home extends AppCompatActivity {

    DBHelper db;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    EditText usrname, pass;
    Button login, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new DBHelper(this, UserProfile.Users.TABLE_NAME, null, 1);

        usrname = findViewById(R.id.txtusername);
        pass = findViewById(R.id.txtpassword);

        login = findViewById(R.id.btnlogin);
        register = findViewById(R.id.btnregister);
    }


    public void register(View view){

        String uname = usrname.getText().toString();
        String passw = pass.getText().toString();

        Boolean datai = db.addInfo(uname, null, passw);
        if (datai == true)
        {
            Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Error in insertion",Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, ProfileManagement.class);

        intent.putExtra(USERNAME, uname);
        intent.putExtra(PASSWORD, passw);

        startActivity(intent);
    }

}
