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
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcheck.data.Person;
import com.example.healthcheck.utils.Serializer;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents the parent activity of all our activities.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final String APP_TAG = "BaseActivityMyApp";
    public static final String SAVED_PERSONS = "savedPersons";
    public static final String EXTRA_PERSON = "com.example.extras.EXTRA_PERSON";


    protected String questions[];
    protected Person person;
    protected Set<String> savedPersons;
    protected int formNumber = -1; // -1 by default for non-form activities
    protected RatingBar rater;
    /**
     * Get the person object from intent and affect it to the person attribute.
     */
    protected void getPersonByIntent() {
        Intent intent = getIntent();
        person = intent.getParcelableExtra(EXTRA_PERSON);
        Log.i(APP_TAG, "Received " + person);

    }

    /**
     * Start the next activity after validation all widgets
     * and putting the person object by intent.
     * @param cls The class of the next activity.
     */
    protected void gotoNextActivity(Class<?> cls) {
        if (validateWidgetsAndAffectPersonData()) {

            Intent intent = new Intent(this, cls );
            intent.putExtra(EXTRA_PERSON, (Parcelable) person);
            startActivity(intent);

            if (!(formNumber < 0)) {
                person.removeQAs("f" + formNumber);
            }
        }
    }

    /**
     * Finish the current activity and get back to the previous one
     * after validation all widgets and putting the person object by intent.
     */
    protected void gotoPreviousActivity(){
        if (validateWidgetsAndAffectPersonData()) {
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
        // sinon il n'y a pas de m??canisme de vibration
    }

    /**
     * Vibrate and show an error message on the tip of the a TextView or with a Toast.
     * @param msg The error message.
     * @param textView a TextView on which to display the tip ( if null, show on Toast).
     * @return Always followed by false.
     */
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

    /**
     * Verify if there's no error with all the widgets of the activity
     * and affect the new data to the person object.
     * @return false if an error found (true by default).
     */
    protected boolean validateWidgetsAndAffectPersonData() {
        return true;
    }



    /**
     * Retrieve the saved StringSet of person's names.
     */
    public void reloadSavedPersons() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        savedPersons = new TreeSet<String>(sharedPref.getStringSet(SAVED_PERSONS, new TreeSet<String>()));
        Log.i(APP_TAG, "reloadSavedPersons new size = " + savedPersons.size());
    }


    /**
     * Log all registered person's names in the shared preferences.
     */
    public void displaySavedPersons() {
        reloadSavedPersons();
        Log.i(APP_TAG,"displaySavedPersons size = "+savedPersons.size()+": ");
        for (String item : savedPersons) {
            Log.i(APP_TAG,"\t- " + item);
        }
    }

    public void animatePop(View view) {
        Animation bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_pop);
        view.setAnimation(bottomAnimation);
    }



}
