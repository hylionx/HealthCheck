package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.widget.SwitchCompat;

public class MyStressManagementActivity extends BaseActivity {
    public static final String APP_TAG = "MyStressManagementActivityApp";

    Button btnPrevMyStressManagment;
    Button btnNextMyStressManagment;
    Spinner spinnerMyStressManagementRepQ1;
    Spinner spinnerMyStressManagementRepQ2;
    SwitchCompat switchMyStressManagementQ3;
    SwitchCompat switchMyStressManagementQ4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_management);

        btnPrevMyStressManagment = findViewById(R.id.btnPrevMyStressManagment);
        btnNextMyStressManagment = findViewById(R.id.btnNextMyStressManagment);

        spinnerMyStressManagementRepQ1 = findViewById(R.id.spinnerMyStressManagementRepQ1);
        spinnerMyStressManagementRepQ2 = findViewById(R.id.spinnerMyStressManagementRepQ2);
        switchMyStressManagementQ3 = findViewById(R.id.switchMyStressManagementQ3);
        switchMyStressManagementQ4 = findViewById(R.id.switchMyStressManagementQ4);


        btnPrevMyStressManagment.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyStressManagment.setOnClickListener(view -> gotoNextActivity(MyHygieneOfLifeActivity.class));

        getPersonByIntent();
        questions = new String[]{"f7_q1", "f7_q2", "f7_q3", "f7_q4"};
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        int posq1 = spinnerMyStressManagementRepQ1.getSelectedItemPosition();
        int posq2 = spinnerMyStressManagementRepQ2.getSelectedItemPosition();

        String q1 =  spinnerMyStressManagementRepQ1.getSelectedItem().toString();
        String q2 = spinnerMyStressManagementRepQ2.getSelectedItem().toString();

        person.addQA(questions[0], getString(R.string.txtMyStressManagementQ1), posq1, q1);
        person.addQA(questions[1], getString(R.string.txtMyStressManagementQ2), posq2, q2);

        if(switchMyStressManagementQ3.isChecked()){
            person.addQA(questions[2], getString(R.string.txtMyStressManagementQ3), 1, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[2], getString(R.string.txtMyStressManagementQ3), 0, getString(R.string.txt_No));
        }

        if(switchMyStressManagementQ4.isChecked()){
            person.addQA(questions[3], getString(R.string.txtMyStressManagementQ4), 1, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[3], getString(R.string.txtMyStressManagementQ4), 0, getString(R.string.txt_No));
        }


        return true;
    }
}