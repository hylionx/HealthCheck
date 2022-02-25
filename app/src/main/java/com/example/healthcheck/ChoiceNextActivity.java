package com.example.healthcheck;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.healthcheck.Utils.Serializer;

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

        Serializer.serialize(person, this);
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}