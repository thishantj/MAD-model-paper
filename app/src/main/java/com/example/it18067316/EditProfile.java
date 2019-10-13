package com.example.it18067316;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditProfile extends AppCompatActivity {

    RadioGroup radioGroup;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        radioGroup = findViewById(R.id.rgender2);

        radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);


    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbtnMale:
                if (checked)
                    gender="Male";
                break;
            case R.id.rbtnFemale:
                if (checked)
                    gender="Female";
                break;
        }
    }
}
