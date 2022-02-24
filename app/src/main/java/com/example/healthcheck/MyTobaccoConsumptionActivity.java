package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyTobaccoConsumptionActivity extends BaseActivity {
    public static final String APP_TAG = "MyTobaccoConsumptionActivityApp";

    Button btnPrevMyTobaccoConsumption;
    Button btnNextMyTobaccoConsumption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tobacco_consumption);



        btnPrevMyTobaccoConsumption = findViewById(R.id.btnPrevMyTobaccoConsumption);
        btnNextMyTobaccoConsumption = findViewById(R.id.btnNextMyTobaccoConsumption);

        btnPrevMyTobaccoConsumption.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyTobaccoConsumption.setOnClickListener(view -> gotoNextActivity(MyStressManagementActivity.class));

        getPersonByIntent();
        questions = new String[]{"f5_q1", "f5_q2", "f5_q3", "f5_q4", "f5_q5"};
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}