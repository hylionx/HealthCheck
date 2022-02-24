package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;

public class MyDietActivity extends BaseActivity {
    public static final String APP_TAG = "MyDietActivityApp";

    Button btnPrevMyDiet;
    Button btnNextMyDiet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diet);


        btnPrevMyDiet = findViewById(R.id.btnPrevMyDiet);
        btnNextMyDiet = findViewById(R.id.btnNextMyDiet);

        btnPrevMyDiet.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyDiet.setOnClickListener(view -> gotoNextActivity(MyPhysicalActivityActivity.class));

        getPersonByIntent();
        questions = new String[]{"f4_q1", "f4_q2", "f4_q3", "f4_q4", "f4_q5", "f4_q6"};

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        
        return true;
    }
}