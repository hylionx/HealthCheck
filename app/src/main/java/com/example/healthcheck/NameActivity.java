package com.example.healthcheck;

import android.Manifest;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;

import com.example.healthcheck.Utils.Serializer;

import java.util.Set;
import java.util.TreeSet;

public class NameActivity extends BaseActivity {
    // in Logcat : (MainApp)|(IAMApp)|(MyHeartApp)
    public static final String APP_TAG = "NameActivityApp";

    // Listes des permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private EditText editName;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        init();
    }

    private void init() {

        person = new Person();
        btnStart = findViewById(R.id.btnStartTest);
        editName = findViewById(R.id.etName);

        btnStart.setOnClickListener(view -> gotoNextActivity(IAmActivity.class));
        //Log.i(APP_TAG, "Name ----- reloadSavedPersons");
        reloadSavedPersons();
        //Log.i(APP_TAG, "Name ----- displaySavedPersons");
        displaySavedPersons();

        verifyStoragePermissions(this);
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

    public static void verifyStoragePermissions(Activity activity) {
        // Vérifie si nous avons les droits d'écriture
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // Aie, il faut les demander àl'utilisateur
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


}