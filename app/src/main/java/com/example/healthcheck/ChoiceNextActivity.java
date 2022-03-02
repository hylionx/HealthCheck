package com.example.healthcheck;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;


public class ChoiceNextActivity extends BaseActivity {

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

        Log.i("Person", "ChoiceNextActivity ----- savePerson");
        savePerson();

        animatePop(buttonAppli);
        animatePop(buttonWebSite);
    }


}