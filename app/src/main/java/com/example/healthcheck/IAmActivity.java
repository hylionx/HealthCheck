package com.example.healthcheck;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

public class IAmActivity extends BaseActivity {
    public static final String APP_TAG = "IAMApp";

    RadioGroup rgSexe;
    EditText numberAge;

    ImageButton btn_suiv;
    Button btn_prec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_am);

        init();
    }

    private void init() {
        rgSexe = findViewById(R.id.rgSexe);
        numberAge = findViewById(R.id.etAge);

        btn_suiv = findViewById(R.id.btnNext);
        btn_prec = findViewById(R.id.btnPrevious);
        btn_suiv.setOnClickListener(view -> gotoNextActivity(MyHeartActivity.class));
        btn_prec.setOnClickListener(view -> gotoPreviousActivity());

        getPersonByIntent();

        Log.i(APP_TAG, "Received person name : " + person.getName());

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        // check rgSexe
        int radioButtonID = rgSexe.getCheckedRadioButtonId();
        if (radioButtonID == -1) {
            return handleError("You must choose your sexe");
        }
        View radioButton = rgSexe.findViewById(radioButtonID);
        int idx = rgSexe.indexOfChild(radioButton);
        Log.i(APP_TAG, "checked : " + idx);
        person.setSexe(idx);

        // check numberAge
        int age;
        try {
            age = Integer.parseInt(numberAge.getText().toString());
        } catch (NumberFormatException e) {
            return handleError("You must select age", numberAge);
        }
        person.setAge(age);
        return true;
    }
}