package com.example.healthcheck;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Parcelable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcheck.Utils.Serializer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Set;
import java.util.TreeSet;

public abstract class BaseActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SAVED_PERSONS = "savedPersons";

    protected static final String EXTRA_PERSON = "com.example.extras.EXTRA_PERSON";
    protected String questions[];
    protected Person person;
    Set<String> savedPersons;


    protected void getPersonByIntent() {
        Intent intent = getIntent();
        person = intent.getParcelableExtra(EXTRA_PERSON);
        //Log.d("Person", "Received " + person);
    }

    protected void gotoNextActivity(Class<?> cls) {
        if (validateWidgetsAndAffectPersonDatas()) {

            Intent intent = new Intent(this, cls );
            intent.putExtra(EXTRA_PERSON, (Parcelable) person);
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


    public void reloadSavedPersons() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        savedPersons = new TreeSet<String>(sharedPref.getStringSet(SAVED_PERSONS, new TreeSet<String>()));
        Log.i("Person", "reloadSavedPersons new size = " + savedPersons.size());
    }

    public void savePerson() {
        Serializer.serialize(person, this);
        savedPersons.add(person.getName());
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.edit().putStringSet(SAVED_PERSONS, savedPersons).commit();
    }

    public void displaySavedPersons() {
        reloadSavedPersons();
        Log.d("Person","displaySavedPersons size = "+savedPersons.size()+": ");
        for (String item : savedPersons) {
            Log.d("Person","\t- " + item);
        }
    }



}
