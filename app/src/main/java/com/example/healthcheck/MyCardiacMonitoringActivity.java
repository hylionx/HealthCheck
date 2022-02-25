package com.example.healthcheck;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;



public class MyCardiacMonitoringActivity extends BaseActivity {
    public static final String APP_TAG = "MyCardiacMonitoringActivityApp";

    private Button btnPrevMyCardiacMonitoring;
    private Button btnNextMyCardiacMonitoring;
    private CheckBox checkBoxCardiacMonitoringQ1;
    private CheckBox checkBoxCardiacMonitoringQ2;
    private CheckBox checkBoxCardiacMonitoringQ3;


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

        getPersonByIntent();
        questions = new String[]{"f3_q1", "f3_q2", "f3_q3"};
        btnNextMyCardiacMonitoring.performClick();
    }



    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {


        if(checkBoxCardiacMonitoringQ1.isChecked()){

            //person.setCardiovascularRiskCheck(true, repQ1);
            person.addQA(questions[0], getString(R.string.txtCardiacMonitoringQ1), 1, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[0], getString(R.string.txtCardiacMonitoringQ1), 0, getString(R.string.txt_No));
        }

        if(checkBoxCardiacMonitoringQ2.isChecked()){
            //person.setHeartCheckup(true, repQ2);
            person.addQA(questions[1], getString(R.string.txtCardiacMonitoringQ2), 1, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[1], getString(R.string.txtCardiacMonitoringQ2), 0, getString(R.string.txt_No));
        }


        if(checkBoxCardiacMonitoringQ3.isChecked()){
            //person.setCardiologistConsulted(true, repQ3);
            person.addQA(questions[2], getString(R.string.txtCardiacMonitoringQ3), 1, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[2], getString(R.string.txtCardiacMonitoringQ3), 0, getString(R.string.txt_No));
        }


        //Log.i(APP_TAG, "repQ1 : " + repQ1 );


        return true;
    }

}