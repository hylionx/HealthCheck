package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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

        buttonAppli.setOnClickListener(view -> gotoNextActivity(CheckUpAppActivity.class));

        buttonWebSite.setOnClickListener(view -> gotoNextActivity(WebsiteCheckupActivity.class));
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}