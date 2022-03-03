package com.example.healthcheck;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.healthcheck.adapters.SavedPersonsAdapter;
import com.example.healthcheck.data.Person;
import com.example.healthcheck.formActivities.NameActivity;
import com.example.healthcheck.utils.Serializer;

import java.util.ArrayList;
import java.util.List;

public class ListViewSavedPersonsActivity extends BaseActivity {
    public static final String APP_TAG = "ListViewSavedPersonsActivityMyApp";



    private ListView listViewPersons;
    private Button bntStartTestNewPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_saved_persons);
        init();
    }
    private void init() {

        reloadSavedPersons();
        displaySavedPersons();


        listViewPersons = findViewById(R.id.listViewPersons);
        bntStartTestNewPerson = findViewById(R.id.bntStartTestNewPerson);

        SavedPersonsAdapter savedPersonsAdapter = new SavedPersonsAdapter(this, savedPersons);
        listViewPersons.setAdapter(savedPersonsAdapter);

        bntStartTestNewPerson.setOnClickListener(view -> gotoNextActivity(NameActivity.class));

        listViewPersons.setOnItemClickListener((adapterView, view, i, l) -> savedPersonsAdapter.next(EXTRA_PERSON, i));
    }

}