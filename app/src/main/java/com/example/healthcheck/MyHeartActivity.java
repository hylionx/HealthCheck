package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

public class MyHeartActivity extends BaseActivity {
    public static final String APP_TAG = "MyHeartApp";

    Button button_pre;
    Button btn_suivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_heart);

        button_pre = findViewById(R.id.btnMyHeartPrec);
        btn_suivant = findViewById(R.id.btnMyHeartNExt);

        button_pre.setOnClickListener(view -> gotoPreviousActivity());
        btn_suivant.setOnClickListener(view -> gotoNextActivity(MyCardiacMonitoringActivity.class));

        getPersonByIntent();

        Log.i(APP_TAG, "Received person sexe : " + person.getSexe() + ", person age : " + person.getAge());
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {



        return true;
    }
}