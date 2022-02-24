package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyStressManagementActivity extends BaseActivity {
    public static final String APP_TAG = "MyStressManagementActivityApp";

    Button btnPrevMyStressManagment;
    Button btnNextMyStressManagment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_management);

        btnPrevMyStressManagment = findViewById(R.id.btnPrevMyStressManagment);
        btnNextMyStressManagment = findViewById(R.id.btnNextMyStressManagment);

        btnPrevMyStressManagment.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyStressManagment.setOnClickListener(view -> gotoNextActivity(MyHygieneOfLifeActivity.class));

        getPersonByIntent();
        questions = new String[]{"f6_q1", "f6_q2", "f6_q3"};
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}