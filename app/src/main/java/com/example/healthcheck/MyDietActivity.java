package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

public class MyDietActivity extends BaseActivity {
    public static final String APP_TAG = "MyDietActivityApp";

    Button btnPrevMyDiet;
    Button btnNextMyDiet;
    CheckBox checkBoxMyDietQ1;
    CheckBox checkBoxMyDietQ2;
    Spinner spinnerMyDietRepQ3;
    CheckBox checkBoxMyDietQ4;
    CheckBox checkBoxMyDietQ5;
    CheckBox checkBoxMyDietQ6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diet);

        questions = new String[]{"f4_q1", "f4_q2", "f4_q3", "f4_q4", "f4_q5", "f4_q6"};
        formNumber = 4;
        btnPrevMyDiet = findViewById(R.id.btnPrevMyDiet);
        btnNextMyDiet = findViewById(R.id.btnNextMyDiet);
        checkBoxMyDietQ1 = findViewById(R.id.checkBoxMyDietQ1);
        checkBoxMyDietQ2 = findViewById(R.id.checkBoxMyDietQ2);
        spinnerMyDietRepQ3 = findViewById(R.id.spinnerMyDietRepQ3);
        checkBoxMyDietQ4 = findViewById(R.id.checkBoxMyDietQ4);
        checkBoxMyDietQ5 = findViewById(R.id.checkBoxMyDietQ5);
        checkBoxMyDietQ6 = findViewById(R.id.checkBoxMyDietQ6);



        btnPrevMyDiet.setOnClickListener(view -> gotoPreviousActivity());
        btnNextMyDiet.setOnClickListener(view -> gotoNextActivity(MyPhysicalActivityActivity.class));

        getPersonByIntent();
        //btnNextMyDiet.performClick();
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonData() {

        if(checkBoxMyDietQ1.isChecked()){
            person.addQA(questions[0], getString(R.string.txtMyDietQ1), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[0], getString(R.string.txtMyDietQ1), 1, getString(R.string.txt_No));
        }


        if(checkBoxMyDietQ2.isChecked()){
            person.addQA(questions[1], getString(R.string.txtMyDietQ2), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[1], getString(R.string.txtMyDietQ2), 1, getString(R.string.txt_No));
        }


        int posq3 = spinnerMyDietRepQ3.getSelectedItemPosition();
        String q3 = spinnerMyDietRepQ3.getSelectedItem().toString();
        person.addQA(questions[2], getString(R.string.txtMyDietQ3), posq3, q3);



        if(checkBoxMyDietQ4.isChecked()){
            person.addQA(questions[3], getString(R.string.txtMyDietQ3), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[3], getString(R.string.txtMyDietQ3), 1, getString(R.string.txt_No));
        }


        if(checkBoxMyDietQ5.isChecked()){
            person.addQA(questions[4], getString(R.string.txtMyDietQ5), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[4], getString(R.string.txtMyDietQ5), 1, getString(R.string.txt_No));
        }


        if(checkBoxMyDietQ6.isChecked()){
            person.addQA(questions[5], getString(R.string.txtMyDietQ6), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[5], getString(R.string.txtMyDietQ6), 1, getString(R.string.txt_No));
        }



        return true;
    }
}