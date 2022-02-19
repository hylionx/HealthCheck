package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MyHeartActivity extends AppCompatActivity {
    public static final String APP_TAG = "MyHeartApp";

    Button button_pre;
    Button btn_suivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_heart);

        button_pre = findViewById(R.id.btnMyHeartPrec);
        button_pre.setOnClickListener(view -> onClickButtonPrecedent());
    }




    public void onClickButtonPrecedent(){
        finish();
    }
}