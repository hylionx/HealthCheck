package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class MyHeartActivity extends BaseActivity {
    public static final String APP_TAG = "MyHeartActivityApp";

    Button btnPrevMyHeart;
    Button btnNextMyHeart;
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
        btnPrevMyHeart = findViewById(R.id.btnPrevMyHeart);
        btnNextMyHeart = findViewById(R.id.btnNextMyHeart);
        spinnerMyHeartRepQ1 = findViewById(R.id.spinnerMyHeartRepQ1);
        spinnerMyHeartRepQ2 = findViewById(R.id.spinnerMyHeartRepQ2);
        spinnerMyHeartRepQ3 = findViewById(R.id.spinnerMyHeartRepQ3);
        spinnerMyHeartRepQ4 = findViewById(R.id.spinnerMyHeartRepQ4);
        spinnerMyHeartRepQ5 = findViewById(R.id.spinnerMyHeartRepQ5);
        spinnerMyHeartRepQ6 = findViewById(R.id.spinnerMyHeartRepQ6);

        btnPrevMyHeart.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyHeart.setOnClickListener(view -> gotoNextActivity(MyCardiacMonitoringActivity.class));


        getPersonByIntent();
        questions = new String[]{"f2_q1", "f2_q2", "f2_q3", "f2_q4", "f2_q5", "f2_q6"};
        btnNextMyHeart.performClick();

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

        person.addQA(questions[0], getString(R.string.txtMyHeartQ1), posq1, q1);
        person.addQA(questions[1], getString(R.string.txtMyHeartQ2), posq2, q2);
        person.addQA(questions[2], getString(R.string.txtMyHeartQ3), posq3, q3);
        person.addQA(questions[3], getString(R.string.txtMyHeartQ4), posq4, q4);
        person.addQA(questions[4], getString(R.string.txtMyHeartQ5), posq5, q5);
        person.addQA(questions[5], getString(R.string.txtMyHeartQ6), posq6, q6);

        return true;
    }
}