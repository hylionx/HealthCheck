package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MyDietActivity extends BaseActivity {
    public static final String APP_TAG = "MyDietActivityApp";

    Button button_pre;
    Button btn_suivant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diet);


        button_pre = findViewById(R.id.btn_prec);
        btn_suivant = findViewById(R.id.btnNextMyPhisicalActivity);

        button_pre.setOnClickListener(view -> gotoPreviousActivity());
        btn_suivant.setOnClickListener(view -> gotoNextActivity(MyPhysicalActivityActivity.class));

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}