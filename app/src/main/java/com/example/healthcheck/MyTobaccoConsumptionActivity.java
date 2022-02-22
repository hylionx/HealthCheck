package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyTobaccoConsumptionActivity extends BaseActivity {

    Button btnPreviousMyTobaccoConsumption;
    Button btnNextMyTobaccoConsumption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tobacco_consumption);



        btnPreviousMyTobaccoConsumption = findViewById(R.id.btnPreviousMyTobaccoConsumption);
        btnNextMyTobaccoConsumption = findViewById(R.id.btnNextMyTobaccoConsumption);

        btnPreviousMyTobaccoConsumption.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyTobaccoConsumption.setOnClickListener(view -> gotoNextActivity(MyStressManagementActivity.class));
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}