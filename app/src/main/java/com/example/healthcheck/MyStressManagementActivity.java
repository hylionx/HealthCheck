package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MyStressManagementActivity extends BaseActivity {
    Button btnMyStressManagmentPrec;
    Button btnMyStressManagmentNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_management);

        btnMyStressManagmentPrec = findViewById(R.id.btnMyStressManagmentPrec);
        btnMyStressManagmentNext = findViewById(R.id.btnMyStressManagmentNext);

        btnMyStressManagmentPrec.setOnClickListener(view -> gotoPreviousActivity());
        btnMyStressManagmentNext.setOnClickListener(view -> gotoNextActivity(MyHygieneOfLigeActivity.class));
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}