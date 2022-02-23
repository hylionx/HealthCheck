package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

public class MyHeartActivity extends BaseActivity {
    public static final String APP_TAG = "MyHeartApp";

    Button button_pre;
    Button btn_suivant;
    Spinner spinnerMyHeartRepQ1;
    Spinner spinnerMyHeartRepQ2;
    Spinner spinnerMyHeartRepQ3;
    Spinner spinnerMyHeartRepQ4;
    Spinner spinnerMyHeartRepQ5;
    Spinner spinnerMyHeartRepQ6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_heart);
        init();

    }


    private void init(){
        button_pre = findViewById(R.id.btnMyHeartPrec);
        btn_suivant = findViewById(R.id.btnMyHeartNExt);
        spinnerMyHeartRepQ1 = findViewById(R.id.spinnerMyHeartRepQ1);
        spinnerMyHeartRepQ2 = findViewById(R.id.spinnerMyHeartRepQ2);
        spinnerMyHeartRepQ3 = findViewById(R.id.spinnerMyHeartRepQ3);
        spinnerMyHeartRepQ4 = findViewById(R.id.spinnerMyHeartRepQ4);
        spinnerMyHeartRepQ5 = findViewById(R.id.spinnerMyHeartRepQ5);
        spinnerMyHeartRepQ6 = findViewById(R.id.spinnerMyHeartRepQ6);

        button_pre.setOnClickListener(view -> gotoPreviousActivity());
        btn_suivant.setOnClickListener(view -> gotoNextActivity(MyCardiacMonitoringActivity.class));

        getPersonByIntent();

        Log.i(APP_TAG, "Received person sexe : " + person.getSexe() + ", person age : " + person.getAge());

    }
    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {

        int posq1 = spinnerMyHeartRepQ1.getSelectedItemPosition();
        int posq2 = spinnerMyHeartRepQ2.getSelectedItemPosition();
        int posq3 = spinnerMyHeartRepQ3.getSelectedItemPosition();
        int posq4 = spinnerMyHeartRepQ4.getSelectedItemPosition();
        int posq5 = spinnerMyHeartRepQ5.getSelectedItemPosition();
        int posq6 = spinnerMyHeartRepQ6.getSelectedItemPosition();


       String q1 =  spinnerMyHeartRepQ1.getSelectedItem().toString();
       String q2 = spinnerMyHeartRepQ2.getSelectedItem().toString();
       String q3 = spinnerMyHeartRepQ3.getSelectedItem().toString();
       String q4 = spinnerMyHeartRepQ4.getSelectedItem().toString();
       String q5 = spinnerMyHeartRepQ5.getSelectedItem().toString();
       String q6 = spinnerMyHeartRepQ6.getSelectedItem().toString();



        person.setHeartProblem(q1, posq1);
        person.setDiabetic(q2, posq2);
        person.setCholesterolProblem(q3, posq3);
        person.setHighBloodPressure(q4, posq4);
        person.setIMC(q6, posq6);

        return true;
    }
}