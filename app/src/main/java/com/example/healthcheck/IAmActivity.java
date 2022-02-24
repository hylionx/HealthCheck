package com.example.healthcheck;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class IAmActivity extends BaseActivity {
    public static final String APP_TAG = "IAmActivityApp";

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
        questions = new String[]{"f1_q1", "f1_q2"};
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        // check rgSexe
        int radioButtonID = rgSexe.getCheckedRadioButtonId();
        if (radioButtonID == -1) {
            return handleError("You must choose your sexe");
        }
        RadioButton radioButton = rgSexe.findViewById(radioButtonID);
        int idx = rgSexe.indexOfChild(radioButton);
        String value = radioButton.getText().toString();
        person.addQA(questions[0], getString(R.string.txtMyProfilQ1), idx, value);


        // check numberAge
        int age;
        try {
            age = Integer.parseInt(numberAge.getText().toString());
        } catch (NumberFormatException e) {
            return handleError("You must select age", numberAge);
        }
        person.addQA(questions[1], getString(R.string.txtMyProfilQ2), age, "" + age); // TODO ******************* revoir

        return true;
    }
}