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

import com.example.healthcheck.data.Person;
import com.example.healthcheck.utils.Serializer;

import java.util.ArrayList;
import java.util.List;

public class ListViewSavedPersonsActivity extends BaseActivity {
    private ListView listViewPersons;
    private List<Person> persons;
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

        persons = new ArrayList();
        for (String name: savedPersons) {
            persons.add(Serializer.deSerialize(name, ListViewSavedPersonsActivity.this));
        }
        listViewPersons = findViewById(R.id.listViewPersons);
        bntStartTestNewPerson = findViewById(R.id.bntStartTestNewPerson);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        listViewPersons.setAdapter(customAdaptor);

        bntStartTestNewPerson.setOnClickListener(view -> gotoNextActivity(NameActivity.class));

        listViewPersons.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChoiceNextActivity.class);
                intent.putExtra(EXTRA_PERSON, (Parcelable) persons.get(i));
                startActivity(intent);
            }
        });
    }


    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return  persons.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1 = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView mImageView = view1.findViewById(R.id.imgAvatar);
            TextView textView = view1.findViewById(R.id.txtListViewPersonName);
            mImageView.setImageResource(persons.get(i).getAvatar());
            textView.setText(persons.get(i).getName());

            return view1;
        }
    }
}