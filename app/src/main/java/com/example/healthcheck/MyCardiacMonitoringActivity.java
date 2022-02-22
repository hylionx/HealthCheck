package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MyCardiacMonitoringActivity extends BaseActivity {
    public static final String APP_TAG = "MyCardiacMonitoringApp";

    Button button_prec;
    Button button_suiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cardiac_monitoring);

        button_prec = findViewById(R.id.button_prec);
        button_suiv = findViewById(R.id.button_suiv);

        button_prec.setOnClickListener(view -> gotoPreviousActivity());
        button_suiv.setOnClickListener(view -> gotoNextActivity(MyPhysicalActivityActivity.class));

        getPersonByIntent();


    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {

        return true;
    }
}