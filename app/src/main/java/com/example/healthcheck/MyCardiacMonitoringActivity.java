package com.example.healthcheck;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class MyCardiacMonitoringActivity extends BaseActivity {
    public static final String APP_TAG = "MyCardiacMonitoringActivityApp";

    private Button btnPrevMyCardiacMonitoring;
    private Button btnNextMyCardiacMonitoring;
    private CheckBox checkBoxCardiacMonitoringQ1;
    private CheckBox checkBoxCardiacMonitoringQ2;
    private CheckBox checkBoxCardiacMonitoringQ3;
    private ArrayList <String> checkboxs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cardiac_monitoring);
        init();
    }


    private void init(){
        btnPrevMyCardiacMonitoring = findViewById(R.id.btnPrevMyCardiacMonitoring);
        btnNextMyCardiacMonitoring = findViewById(R.id.btnNextMyCardiacMonitoring);

        btnPrevMyCardiacMonitoring.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyCardiacMonitoring.setOnClickListener(view -> gotoNextActivity(MyDietActivity.class));

        checkBoxCardiacMonitoringQ1 = findViewById(R.id.checkBoxCardiacMonitoringQ1);
        checkBoxCardiacMonitoringQ2 = findViewById(R.id.checkBoxCardiacMonitoringQ2);
        checkBoxCardiacMonitoringQ3 = findViewById(R.id.checkBoxCardiacMonitoringQ3);
        checkboxs = new ArrayList<>();

        getPersonByIntent();
        questions = new String[]{"f3_q1", "f3_q2", "f3_q3"};
    }



    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {

        String repQ1 = checkBoxCardiacMonitoringQ1.getText().toString();
        String repQ2 = checkBoxCardiacMonitoringQ2.getText().toString();
        String repQ3 = checkBoxCardiacMonitoringQ3.getText().toString();

        if(checkBoxCardiacMonitoringQ1.isChecked()){

            //person.setCardiovascularRiskCheck(true, repQ1);
            person.addQA(questions[0], repQ1, 1, "YES");
        } else {
            person.addQA(questions[0], repQ1, 0, "NO");
        }

        if(checkBoxCardiacMonitoringQ2.isChecked()){
            //person.setHeartCheckup(true, repQ2);
            person.addQA(questions[1], repQ2, 1, "YES");
        } else {
            person.addQA(questions[1], repQ2, 0, "NO");
        }


        if(checkBoxCardiacMonitoringQ3.isChecked()){
            //person.setCardiologistConsulted(true, repQ3);
            person.addQA(questions[2], repQ3, 1, "YES");
        } else {
            person.addQA(questions[2], repQ3, 0, "NO");
        }


        //Log.i(APP_TAG, "repQ1 : " + repQ1 );


        return true;
    }

}