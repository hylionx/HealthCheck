package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MyHygieneOfLigeActivity extends BaseActivity {
    Button btnMyHygieneOfLifePrec;
    Button btnValidate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hygiene_of_lige);

        btnMyHygieneOfLifePrec = findViewById(R.id.btnMyHygieneOfLifePrec);

        btnMyHygieneOfLifePrec.setOnClickListener(view -> gotoPreviousActivity());


    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}