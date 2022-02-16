package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MyHeart extends AppCompatActivity {
    Button button_pre;
    Button btn_suivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_heart);

        button_pre = findViewById(R.id.button_pre);
        button_pre.setOnClickListener(view -> onClickButtonPrecedent());
    }




    public void onClickButtonPrecedent(){
        finish();
    }
}