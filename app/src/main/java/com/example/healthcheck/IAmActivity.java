package com.example.healthcheck;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IAmActivity extends BaseActivity {
    public static final String APP_TAG = "IAmActivityApp";

    RadioGroup rgSexe;
    RadioGroup rgAge;

    TextView txtAge;

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
        rgAge = findViewById(R.id.rgAge);
        txtAge = findViewById(R.id.txtAge);

        btn_suiv = findViewById(R.id.btnNext);
        btn_prec = findViewById(R.id.btnPrevIAm);
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


        // check rgAge
        int radioButtonID2 = rgAge.getCheckedRadioButtonId();
        if(radioButtonID2 == -1){
            return handleError("You must choose your age");
        }
        RadioButton radioButton1 = rgAge.findViewById(radioButtonID2);
        int idx2 = rgAge.indexOfChild(radioButton1);
        String value2 = radioButton1.getText().toString();
        person.addQA(questions[1], getString(R.string.txtMyProfilQ2), idx2, value2);


        return true;
    }
}