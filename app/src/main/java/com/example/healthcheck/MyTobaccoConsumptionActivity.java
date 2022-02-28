package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class MyTobaccoConsumptionActivity extends BaseActivity {
    public static final String APP_TAG = "MyTobaccoConsumptionActivityApp";

    Button btnPrevMyTobaccoConsumption;
    Button btnNextMyTobaccoConsumption;

    CheckBox checkBoxMyTobaccoConsumptionQ1;
    CheckBox checkBoxMyTobaccoConsumptionQ2;
    CheckBox checkBoxMyTobaccoConsumptionQ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tobacco_consumption);



        btnPrevMyTobaccoConsumption = findViewById(R.id.btnPrevMyTobaccoConsumption);
        btnNextMyTobaccoConsumption = findViewById(R.id.btnNextMyTobaccoConsumption);

        checkBoxMyTobaccoConsumptionQ1 = findViewById(R.id.checkBoxMyTobaccoConsumptionQ1);
        checkBoxMyTobaccoConsumptionQ2 = findViewById(R.id.checkBoxMyTobaccoConsumptionQ2);
        checkBoxMyTobaccoConsumptionQ3 = findViewById(R.id.checkBoxMyTobaccoConsumptionQ3);

        btnPrevMyTobaccoConsumption.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyTobaccoConsumption.setOnClickListener(view -> gotoNextActivity(MyStressManagementActivity.class));

        getPersonByIntent();
        questions = new String[]{"f6_q1", "f6_q2", "f6_q3"};
        //btnNextMyTobaccoConsumption.performClick();

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        if(checkBoxMyTobaccoConsumptionQ1.isChecked()){
            person.addQA(questions[0], getString(R.string.txtMyTobaccoConsumptionQ1), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[0], getString(R.string.txtMyTobaccoConsumptionQ1), 1, getString(R.string.txt_No));
        }

        if(checkBoxMyTobaccoConsumptionQ2.isChecked()){
            person.addQA(questions[1], getString(R.string.txtMyTobaccoConsumptionQ2), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[1], getString(R.string.txtMyTobaccoConsumptionQ2), 1, getString(R.string.txt_No));
        }


        if(checkBoxMyTobaccoConsumptionQ3.isChecked()){
            person.addQA(questions[2], getString(R.string.txtMyTobaccoConsumptionQ3), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[2], getString(R.string.txtMyTobaccoConsumptionQ3), 1, getString(R.string.txt_No));
        }

        return true;
    }
}