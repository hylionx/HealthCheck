package com.example.healthcheck.formActivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.widget.SwitchCompat;

import com.example.healthcheck.BaseActivity;
import com.example.healthcheck.R;

public class MyStressManagementActivity extends BaseActivity {
    public static final String APP_TAG = "MyStressManagementActivityMyApp";

    private Button btnPrevMyStressManagment;
    private Button btnNextMyStressManagment;
    private Spinner spinnerMyStressManagementRepQ1;
    private Spinner spinnerMyStressManagementRepQ2;
    private SwitchCompat switchMyStressManagementQ3;
    private SwitchCompat switchMyStressManagementQ4;
    private ImageView imgStressMngmt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stress_management);

        questions = new String[]{"f7_q1", "f7_q2", "f7_q3", "f7_q4"};
        formNumber = 7;
        btnPrevMyStressManagment = findViewById(R.id.btnPrevMyStressManagment);
        btnNextMyStressManagment = findViewById(R.id.btnNextMyStressManagment);

        spinnerMyStressManagementRepQ1 = findViewById(R.id.spinnerMyStressManagementRepQ1);
        spinnerMyStressManagementRepQ2 = findViewById(R.id.spinnerMyStressManagementRepQ2);
        switchMyStressManagementQ3 = findViewById(R.id.switchMyStressManagementQ3);
        switchMyStressManagementQ4 = findViewById(R.id.switchMyStressManagementQ4);
        imgStressMngmt = findViewById(R.id.imgStressMngmt);

        btnPrevMyStressManagment.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyStressManagment.setOnClickListener(view -> gotoNextActivity(MyHygieneOfLifeActivity.class));

        getPersonByIntent();
        //btnNextMyStressManagment.performClick();
        animatePop(imgStressMngmt);

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonData() {
        int posq1 = spinnerMyStressManagementRepQ1.getSelectedItemPosition();
        int posq2 = spinnerMyStressManagementRepQ2.getSelectedItemPosition();

        String q1 =  spinnerMyStressManagementRepQ1.getSelectedItem().toString();
        String q2 = spinnerMyStressManagementRepQ2.getSelectedItem().toString();

        person.addQA(questions[0], getString(R.string.txtMyStressManagementQ1), posq1, q1);
        person.addQA(questions[1], getString(R.string.txtMyStressManagementQ2), posq2, q2);

        if(switchMyStressManagementQ3.isChecked()){
            person.addQA(questions[2], getString(R.string.txtMyStressManagementQ3), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[2], getString(R.string.txtMyStressManagementQ3), 1, getString(R.string.txt_No));
        }

        if(switchMyStressManagementQ4.isChecked()){
            person.addQA(questions[3], getString(R.string.txtMyStressManagementQ4), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[3], getString(R.string.txtMyStressManagementQ4), 1, getString(R.string.txt_No));
        }


        return true;
    }
}