package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyHygieneOfLifeActivity extends BaseActivity {
    public static final String APP_TAG = "MyHygieneOfLifeActivityApp";

    Button btnPrevMyHygieneOfLife;
    Button btnValidate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hygiene_of_life);

        btnPrevMyHygieneOfLife = findViewById(R.id.btnPrevMyHygieneOfLife);

        btnPrevMyHygieneOfLife.setOnClickListener(view -> gotoPreviousActivity());

        getPersonByIntent();
        questions = new String[]{"f7_q1", "f7_q2", "f7_q3", "f7_q4"};

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}