package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class IAmActivity extends AppCompatActivity {
    public static final String APP_TAG = "IAMApp";

    Person person;
    SharedPreferences preferences;

    RadioGroup rgSexe;
    EditText numberAge;

    Button btn_suiv;
    Button btn_prec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_am);

        init();
    }

    private void init() {
        preferences = getSharedPreferences("Shared_PREF", MODE_PRIVATE);

        rgSexe = findViewById(R.id.rgSexe);
        numberAge = findViewById(R.id.numberAge);

        btn_suiv = findViewById(R.id.btnNext);
        btn_prec = findViewById(R.id.btnPrec);
        btn_suiv.setOnClickListener(view -> onClickButtonSuivant());
        btn_prec.setOnClickListener(view -> onClickButtonPrecedent());

        Intent intent = getIntent();
        person = intent.getParcelableExtra("Person");

        Log.i(APP_TAG, "Parcelable get person name : " + person.getName());

    }


    public void onClickButtonSuivant(){

        validateWidgets();
        affectSexe();
        affectAge();

        Intent intent = new Intent(this, MyHeartActivity.class );
        intent.putExtra("Person", person);
        startActivity(intent);

    }

    public void onClickButtonPrecedent(){
        finish();
    }


    private void validateWidgets() {
        Log.i(APP_TAG, "Validating widgets");
    }

    private void affectSexe() {
        int radioButtonID = rgSexe.getCheckedRadioButtonId();
        View radioButton = rgSexe.findViewById(radioButtonID);
        int idx = rgSexe.indexOfChild(radioButton);
        Log.i(APP_TAG, "checked : " + idx);

        person.setSexe(idx);
    }

    private void affectAge() {
        int age = Integer.parseInt(numberAge.getText().toString());
        person.setAge(age);
    }

}