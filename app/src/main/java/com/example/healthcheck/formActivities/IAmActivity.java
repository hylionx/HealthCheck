package com.example.healthcheck.formActivities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.healthcheck.BaseActivity;
import com.example.healthcheck.R;

public class IAmActivity extends BaseActivity {
    public static final String APP_TAG = "IAmActivityMyApp";

    private RadioGroup rgSexe;
    private RadioGroup rgAge;

    private ImageView myProfilImg;

    private TextView txtAge;

    private EditText editHeight;
    private EditText editWeight;

    private Button btnNextIAm;
    private Button btnPrevIAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_am);

        init();
    }

    private void init() {
        questions = new String[]{"f1_q1", "f1_q2"};
        formNumber = 1;
        rgSexe = findViewById(R.id.rgSexe);
        rgAge = findViewById(R.id.rgAge);
        myProfilImg = findViewById(R.id.myProfilImg);
        txtAge = findViewById(R.id.txtAge);

        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);

        btnNextIAm = findViewById(R.id.btnNextIAm);
        btnPrevIAm = findViewById(R.id.btnPrevIAm);
        btnNextIAm.setOnClickListener(view -> gotoNextActivity(MyHeartActivity.class));
        btnPrevIAm.setOnClickListener(view -> gotoPreviousActivity());

        getPersonByIntent();

        animatePop(myProfilImg);

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonData() {
        // check rgSexe
        int radioButtonID = rgSexe.getCheckedRadioButtonId();
        if (radioButtonID == -1) {
            return handleError((getString(R.string.txtErrorSexe)));
        }
        RadioButton radioButton = rgSexe.findViewById(radioButtonID);
        int idx = rgSexe.indexOfChild(radioButton);
        String value = radioButton.getText().toString();
        person.addQA(questions[0], getString(R.string.txtMyProfilQ1), idx, value);


        // check rgAge
        int radioButtonID2 = rgAge.getCheckedRadioButtonId();
        if(radioButtonID2 == -1){
            return handleError(getString(R.string.txtErrorAge));
        }
        RadioButton radioButton1 = rgAge.findViewById(radioButtonID2);
        int idx2 = rgAge.indexOfChild(radioButton1);
        String value2 = radioButton1.getText().toString();
        person.addQA(questions[1], getString(R.string.txtMyProfilQ2), idx2, value2);

        //check weight
        String weight = editWeight.getText().toString();
        if(TextUtils.isEmpty(weight)) {
            return handleError((getString(R.string.txtErrorWeight)), editWeight);
        }
        //person.setName(weight); TODO dans les sharedPrefs


        //check height
        String height = editHeight.getText().toString();
        if(TextUtils.isEmpty(height)) {
            return handleError((getString(R.string.txtErrorHeight)), editHeight);
        }
        //person.setName(height); TODO dans les sharedPrefs


        return true;
    }
}