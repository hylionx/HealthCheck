package com.example.healthcheck.formActivities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.SwitchCompat;

import com.example.healthcheck.BaseActivity;
import com.example.healthcheck.ChoiceNextActivity;
import com.example.healthcheck.R;

public class MyHygieneOfLifeActivity extends BaseActivity {
    public static final String APP_TAG = "MyHygieneOfLifeActivityMyApp";

    private Button btnPrevMyHygieneOfLife;
    private Button btnValidate;
    private SwitchCompat switchMyHygieneOfLifeQ1;
    private SwitchCompat switchMyHygieneOfLifeQ2;
    private SwitchCompat switchMyHygieneOfLifeQ3;
    private SwitchCompat switchMyHygieneOfLifeQ4;
    private ImageView imgHygieneOfLife;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hygiene_of_life);

        questions = new String[]{"f8_q1", "f8_q2", "f8_q3", "f8_q4"};
        formNumber = 8;
        btnPrevMyHygieneOfLife = findViewById(R.id.btnPrevMyHygieneOfLife);
        btnValidate = findViewById(R.id.btnValidate);

        switchMyHygieneOfLifeQ1 = findViewById(R.id.switchMyHygieneOfLifeQ1);
        switchMyHygieneOfLifeQ2 = findViewById(R.id.switchMyHygieneOfLifeQ2);
        switchMyHygieneOfLifeQ3 = findViewById(R.id.switchMyHygieneOfLifeQ3);
        switchMyHygieneOfLifeQ4 = findViewById(R.id.switchMyHygieneOfLifeQ4);
        imgHygieneOfLife =findViewById(R.id.imgHygieneOfLife);
        getPersonByIntent();

        btnPrevMyHygieneOfLife.setOnClickListener(view -> gotoPreviousActivity());
        btnValidate.setOnClickListener(view -> gotoNextActivity(ChoiceNextActivity.class));


        //btnValidate.performClick();
        animatePop(imgHygieneOfLife);

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonData() {


        if(switchMyHygieneOfLifeQ1.isChecked()){
            person.addQA(questions[0], getString(R.string.txtMyHygieneOfLifeQ1), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[0], getString(R.string.txtMyHygieneOfLifeQ1), 1, getString(R.string.txt_No));
        }

        if(switchMyHygieneOfLifeQ2.isChecked()){
            person.addQA(questions[1], getString(R.string.txtMyHygieneOfLifeQ2), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[1], getString(R.string.txtMyHygieneOfLifeQ2), 1, getString(R.string.txt_No));
        }


        if(switchMyHygieneOfLifeQ3.isChecked()){
            person.addQA(questions[2], getString(R.string.txtMyHygieneOfLifeQ3), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[2], getString(R.string.txtMyHygieneOfLifeQ3), 1, getString(R.string.txt_No));
        }

        if(switchMyHygieneOfLifeQ4.isChecked()){
            person.addQA(questions[3], getString(R.string.txtMyHygieneOfLifeQ4), 0, getString(R.string.txt_Yes));
        } else {
            person.addQA(questions[3], getString(R.string.txtMyHygieneOfLifeQ4), 1, getString(R.string.txt_No));
        }


        return true;
    }
}