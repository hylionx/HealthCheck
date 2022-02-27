package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.healthcheck.Utils.Serializer;

import java.util.ArrayList;
import java.util.List;

public class ListViewSavedPersonsActivity extends BaseActivity {
    ListView listViewPersons;
    int [] images;
    List<String> names;
    Button bntStartTestNewPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_saved_persons);
        init();
    }




    private void init() {

        reloadSavedPersons();
        displaySavedPersons();


        names = new ArrayList<>(savedPersons);
        listViewPersons = findViewById(R.id.listViewPersons);
        bntStartTestNewPerson = findViewById(R.id.bntStartTestNewPerson);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        listViewPersons.setAdapter(customAdaptor);


        bntStartTestNewPerson.setOnClickListener(view -> gotoNextActivity(NameActivity.class));

        listViewPersons.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChoiceNextActivity.class);
                intent.putExtra(EXTRA_PERSON, (Parcelable) Serializer.deSerialize(names.get(i), ListViewSavedPersonsActivity.this));
                startActivity(intent);
            }
        });
    }


    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return  names.size();
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
            //ImageView mImageView = view1.findViewById(R.id.imgAvatar);
            TextView textView = view1.findViewById(R.id.txtListViewPersonName);
            //mImageView.setImageResource(images[i]);
            textView.setText(names.get(i));

            return view1;
        }
    }
}