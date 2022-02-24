package com.example.healthcheck;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String EXTRA_PERSON = "com.example.extras.EXTRA_PERSON";
    protected Person person;
    protected SharedPreferences sharedPref; // = PreferenceManager.getDefaultSharedPreferences(this);
    protected String postParams = "";


    protected void addPostParams(String question, int value) {
        try {
            postParams += (postParams.isEmpty() ? "" : "&") + question + "=" + URLEncoder.encode("" + value , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    protected void getPersonByIntent() {
        Intent intent = getIntent();
        person = intent.getParcelableExtra(EXTRA_PERSON);
    }

    protected void gotoNextActivity(Class<?> cls) {
        if (validateWidgetsAndAffectPersonDatas()) {

            Intent intent = new Intent(this, cls );
            intent.putExtra(EXTRA_PERSON, person);
            startActivity(intent);
        }
    }

    protected void gotoPreviousActivity(){
        if (validateWidgetsAndAffectPersonDatas()) {
            finish();
        }
    }

    public void vibrate(long duration_ms) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(duration_ms < 1)
            duration_ms = 1;
        if(v != null && v.hasVibrator()) {
        // Attention changement comportement avec API >= 26 (cf doc)
            if(Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                v.vibrate(duration_ms);
            }
        }
        // sinon il n'y a pas de mécanisme de vibration
    }

    protected boolean handleError(String msg, TextView textView){
        vibrate(200);
        if (textView != null) {
            textView.requestFocus();
            textView.setError(msg);
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    protected boolean handleError(String msg){

        return handleError(msg, null);
    }

    protected abstract boolean validateWidgetsAndAffectPersonDatas();


}
