package com.example.healthcheck.formActivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.healthcheck.BaseActivity;
import com.example.healthcheck.R;

public class MyPhysicalActivityActivity extends BaseActivity {
    public static final String APP_TAG = "MyPhysicalActivityActivityMyApp";

    private Button btnPrevMyPhysicalActivity;
    private Button btnNextMyPhysicalActivity;
    private CheckBox checkBoxMyPhysicalActivityQ1;
    private Spinner spinnerMyPhysicalActivityRepQ2;
    private CheckBox checkBoxMyPhysicalActivityQ3;
    private Spinner spinnerMyPhysicalActivityRepQ4;
    private Spinner spinnerMyPhysicalActivityRepQ5;
    private ImageView myphysicalActivityImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_physical_activity);

        questions = new String[]{"f5_q1", "f5_q2", "f5_q3", "f5_q4", "f5_q5"};
        formNumber = 5;
        btnPrevMyPhysicalActivity = findViewById(R.id.btnPrevMyPhysicalActivity);
        btnNextMyPhysicalActivity = findViewById(R.id.btnNextMyPhysicalActivity);
        checkBoxMyPhysicalActivityQ1 = findViewById(R.id.checkBoxMyPhysicalActivityQ1);
        spinnerMyPhysicalActivityRepQ2 = findViewById(R.id.spinnerMyPhysicalActivityRepQ2);
        checkBoxMyPhysicalActivityQ3 = findViewById(R.id.checkBoxMyPhysicalActivityQ3);
        spinnerMyPhysicalActivityRepQ4 = findViewById(R.id.spinnerMyPhysicalActivityRepQ4);
        spinnerMyPhysicalActivityRepQ5 = findViewById(R.id.spinnerMyPhysicalActivityRepQ5);
        myphysicalActivityImg = findViewById(R.id.myphysicalActivityImg);

        btnPrevMyPhysicalActivity.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyPhysicalActivity.setOnClickListener(view -> gotoNextActivity(MyTobaccoConsumptionActivity.class));

        getPersonByIntent();
        btnNextMyPhysicalActivity.performClick();
        animatePop(myphysicalActivityImg);
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonData() {

        if(checkBoxMyPhysicalActivityQ1.isChecked()){
            person.addQA(questions[0], getString(R.string.txtMyPhysicalActivityQ1), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[0], getString(R.string.txtMyPhysicalActivityQ1), 1, getString(R.string.txt_No));
        }


        int posq2 = spinnerMyPhysicalActivityRepQ2.getSelectedItemPosition();
        String q2 = spinnerMyPhysicalActivityRepQ2.getSelectedItem().toString();
        person.addQA(questions[1], getString(R.string.txtMyPhysicalActivityQ2), posq2, q2);


        if(checkBoxMyPhysicalActivityQ3.isChecked()){
            person.addQA(questions[2], getString(R.string.txtMyPhysicalActivityQ3), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[2], getString(R.string.txtMyPhysicalActivityQ3), 1, getString(R.string.txt_No));
        }


        int posq4 = spinnerMyPhysicalActivityRepQ4.getSelectedItemPosition();
        String q4 = spinnerMyPhysicalActivityRepQ4.getSelectedItem().toString();
        person.addQA(questions[3], getString(R.string.txtMyPhysicalActivityQ4), posq4, q4);


        int posq5 = spinnerMyPhysicalActivityRepQ5.getSelectedItemPosition();
        String q5 = spinnerMyPhysicalActivityRepQ5.getSelectedItem().toString();
        person.addQA(questions[4], getString(R.string.txtMyPhysicalActivityQ5), posq5, q5);


        return true;
    }
}