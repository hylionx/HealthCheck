package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class IAmActivity extends AppCompatActivity {
    public static final String APP_TAG = "IAMApp";

    Person person;
    Button btn_suiv;
    Button btn_prec;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_am);

        init();
    }

    private void init() {
        preferences = getSharedPreferences("Shared_PREF", MODE_PRIVATE);
        btn_suiv = findViewById(R.id.btnNext);
        btn_prec = findViewById(R.id.btnPrec);
        btn_suiv.setOnClickListener(view -> onClickButtonSuivant());
        btn_prec.setOnClickListener(view -> onClickButtonPrecedent());

        Intent intent = getIntent();
        person = intent.getParcelableExtra("Person");

        Log.i(APP_TAG, "Parcelable get person name : " + person.getName());

    }


    public void onClickButtonSuivant(){
        Intent intent = new Intent(this, MyHeartActivity.class );
        startActivity(intent);

    }

    public void onClickButtonPrecedent(){
        finish();
    }
}