package com.example.healthcheck;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ImageButton;

import com.example.healthcheck.Utils.Serializer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Set;
import java.util.TreeSet;


public class ChoiceNextActivity extends BaseActivity {

    ImageButton buttonAppli;
    ImageButton buttonWebSite;

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

        Log.i("Person", "ChoiceNextActivity ----- savePerson");
        savePerson();
    }


}