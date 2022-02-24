package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyPhysicalActivityActivity extends BaseActivity{
    public static final String APP_TAG = "MyPhysicalActivityActivityApp";

    Button btnPreviousMyPhisicalActivity;
    Button btnNextMyPhisicalActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_physical_activity);
        btnPreviousMyPhisicalActivity = findViewById(R.id.btnPreviousMyPhisicalActivity);
        btnNextMyPhisicalActivity = findViewById(R.id.btnNextMyPhisicalActivity);

        btnPreviousMyPhisicalActivity.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyPhisicalActivity.setOnClickListener(view -> gotoNextActivity(MyTobaccoConsumptionActivity.class));
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}