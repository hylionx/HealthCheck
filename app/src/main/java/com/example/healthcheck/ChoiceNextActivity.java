package com.example.healthcheck;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ImageButton;

import com.example.healthcheck.utils.Serializer;


public class ChoiceNextActivity extends BaseActivity {
    public static final String APP_TAG = "ChoiceNextActivityMyApp";

    private ImageButton buttonAppli;
    private ImageButton buttonWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_next);

        getPersonByIntent();

        buttonAppli = findViewById(R.id.buttonAppli);
        buttonWebSite = findViewById(R.id.buttonWebSite);

        getPersonByIntent();

        buttonAppli.setOnClickListener(view -> gotoNextActivity(ListViewCheckUpActivity.class));
        buttonWebSite.setOnClickListener(view -> gotoNextActivity(WebsiteCheckupActivity.class));

        reloadSavedPersons();
        displaySavedPersons();

        Log.i(APP_TAG, "Saving person");
        savePerson();

        animatePop(buttonAppli);
        animatePop(buttonWebSite);
    }

    /**
     * Store the person object in file system with serialization
     * and register the person name in the shared preferences.
     */
    public void savePerson() {
        Serializer.serialize(person, this);
        savedPersons.add(person.getName());
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.edit().putStringSet(SAVED_PERSONS, savedPersons).commit();
    }


}