package com.example.healthcheck;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthcheck.Utils.Serializer;

public class NameActivity extends BaseActivity {
    // in Logcat : (MainApp)|(IAMApp)|(MyHeartApp)
    public static final String APP_TAG = "NameActivityApp";

    private EditText editName;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        init();
    }

    private void init() {

        person = Serializer.deSerialize("hylia", this);
        if (person != null)
            Log.i(APP_TAG, "777777777777777   " + person);
        else
            person = new Person();
        btnStart = findViewById(R.id.btnStartTest);
        editName = findViewById(R.id.etName);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

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
        sharedPref.edit().putString("personName", name).commit();
        Log.i(APP_TAG, "name saved in sharedPref: " + sharedPref.getString("personName", null));

        return true;
    }

}