package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyHygieneOfLifeActivity extends BaseActivity {
    public static final String APP_TAG = "MyHygieneOfLifeActivityApp";

    Button btnMyHygieneOfLifePrec;
    Button btnValidate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hygiene_of_life);

        btnMyHygieneOfLifePrec = findViewById(R.id.btnMyHygieneOfLifePrec);

        btnMyHygieneOfLifePrec.setOnClickListener(view -> gotoPreviousActivity());


    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}