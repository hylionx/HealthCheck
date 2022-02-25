package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewSavedPersonsActivity extends BaseActivity {
    ListView listViewPersons;
    int [] images;
    String [] names;
    Button bntStartTestNewPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_saved_persons);
        init();
    }




    private void init() {

        images = new int[]{R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4};
        names = new String[]{"Hylia", "Jugurtha", "Anissa", "Wejdene"};
        listViewPersons = findViewById(R.id.listViewPersons);
        bntStartTestNewPerson = findViewById(R.id.bntStartTestNewPerson);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        listViewPersons.setAdapter(customAdaptor);


        bntStartTestNewPerson.setOnClickListener(view -> gotoNextActivity(NameActivity.class));
    }
    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }


    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return  images.length;
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
            textView.setText(names[i]);

            return view1;
        }
    }
}