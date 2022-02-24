package com.example.healthcheck;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;


public class MyCardiacMonitoringActivity extends BaseActivity {
    public static final String APP_TAG = "MyCardiacMonitoringActivityApp";

    private Button button_prec;
    private Button button_suiv;
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
        button_prec = findViewById(R.id.button_prec);
        button_suiv = findViewById(R.id.button_suiv);

        button_prec.setOnClickListener(view -> gotoPreviousActivity());
        button_suiv.setOnClickListener(view -> gotoNextActivity(MyPhysicalActivityActivity.class));

        checkBoxCardiacMonitoringQ1 = findViewById(R.id.checkBoxCardiacMonitoringQ1);
        checkBoxCardiacMonitoringQ2 = findViewById(R.id.checkBoxCardiacMonitoringQ2);
        checkBoxCardiacMonitoringQ3 = findViewById(R.id.checkBoxCardiacMonitoringQ3);
        checkboxs = new ArrayList<>();

        getPersonByIntent();

        Log.i(APP_TAG, "\n Received my heart problem : " + person.getHeartProblem()
                + "\n my cholesterol problem : " + person.getCholesterolProblem()
                + "\n my diabetic : " + person.getDiabetic()
                + "\n my high blood pressure : " + person.getHighBloodPressure()
                + "\n my parent heart problem : " + person.getParentHeartProblem()
                + "\n my IMC : " + person.getIMC());
    }



    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {

                String repQ1 = checkBoxCardiacMonitoringQ1.getText().toString();
                String repQ2 = checkBoxCardiacMonitoringQ2.getText().toString();
                String repQ3 = checkBoxCardiacMonitoringQ3.getText().toString();



                if(checkBoxCardiacMonitoringQ1.isChecked()){

                    person.setCardiovascularRiskCheck(true, repQ1);
                }

                if(checkBoxCardiacMonitoringQ2.isChecked()){
                    person.setHeartCheckup(true, repQ2);
                }


                if(checkBoxCardiacMonitoringQ3.isChecked()){
                    person.setCardiologistConsulted(true, repQ3);
                }


                Log.i(APP_TAG, "repQ1 : " + repQ1 );


        return true;
    }

}