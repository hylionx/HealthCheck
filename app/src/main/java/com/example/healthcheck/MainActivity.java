package com.example.healthcheck;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {
    // in Logcat : (MainApp)|(IAMApp)|(MyHeartApp)
    public static final String APP_TAG = "MainApp";

    private EditText editName;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        person = new Person();
        btnStart = findViewById(R.id.btnStartTest);
        editName = findViewById(R.id.etName);
        sharedPreferences = getSharedPreferences("Shared_PREF", MODE_PRIVATE);

        btnStart.setOnClickListener(view -> gotoNextActivity(IAmActivity.class));

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        // check name
        String name = editName.getText().toString();
        if(TextUtils.isEmpty(name)) {
            return handleError("this can't be empty", editName);
        }
        person.setName(name);
        return true;
    }

}