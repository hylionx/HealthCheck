package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class MyHeartActivity extends AppCompatActivity {
    public static final String APP_TAG = "MyHeartApp";

    Button btnMyHeartPrec;
    Button btnMyHeartNExt;
    Spinner spinnerMyHeartRepQ1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_heart);

        btnMyHeartPrec = findViewById(R.id.btnMyHeartPrec);
        spinnerMyHeartRepQ1 = findViewById(R.id.spinnerMyHeartRepQ1);
        btnMyHeartPrec.setOnClickListener(view -> onClickButtonPrecedent());
    }




    public void onClickButtonPrecedent(){
        finish();
    }
    }