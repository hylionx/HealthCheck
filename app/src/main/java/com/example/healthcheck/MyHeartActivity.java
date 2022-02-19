package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

public class MyHeartActivity extends AppCompatActivity {
    public static final String APP_TAG = "MyHeartApp";

    Person person;
    SharedPreferences preferences;

    Button button_pre;
    Button btn_suivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_heart);

        button_pre = findViewById(R.id.btnMyHeartPrec);
        button_pre.setOnClickListener(view -> onClickButtonPrecedent());

        Intent intent = getIntent();
        person = intent.getParcelableExtra("Person");

        Log.i(APP_TAG, "person sexe : " + person.getSexe() + ", person age : " + person.getAge());
    }




    public void onClickButtonPrecedent(){
        finish();
    }
    }