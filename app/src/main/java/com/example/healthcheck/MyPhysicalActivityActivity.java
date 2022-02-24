package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyPhysicalActivityActivity extends BaseActivity{
    public static final String APP_TAG = "MyPhysicalActivityActivityApp";

    Button btnPrevMyPhysicalActivity;
    Button btnNextMyPhysicalActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_physical_activity);
        btnPrevMyPhysicalActivity = findViewById(R.id.btnPrevMyPhysicalActivity);
        btnNextMyPhysicalActivity = findViewById(R.id.btnNextMyPhysicalActivity);

        btnPrevMyPhysicalActivity.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyPhysicalActivity.setOnClickListener(view -> gotoNextActivity(MyTobaccoConsumptionActivity.class));

        getPersonByIntent();
        questions = new String[]{"f4_q1", "f4_q2", "f4_q3"};
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}