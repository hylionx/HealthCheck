package com.example.healthcheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CheckUpAppActivity extends BaseActivity {

    ListView listView;
    String[] topicName = {"My Heart", "My Cardiac Monitoring"," My Diet", "My Physical Activity", "My Tobacco Consumption", "My stress Managment","My Hygiene of life"};
    int [] topicImage = {R.drawable.coeur, R.drawable.suivicardiaque, R.drawable.alimentation, R.drawable.basket, R.drawable.tabac, R.drawable.stress, R.drawable.dodo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up_app);
        getPersonByIntent();

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                intent.putExtra("indexForm", (i+1));
                intent.putExtra(EXTRA_PERSON, person);
                intent.putExtra("name", topicName[i]);
                intent.putExtra("image", topicImage[i]);
                startActivity(intent);
            }
        });
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }

    private class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return topicImage.length;
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
           View view1 = getLayoutInflater().inflate(R.layout.activity_row_data, null);
            TextView name = view1.findViewById(R.id.txtTitleTopic);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(topicName[i]);
            image.setImageResource(topicImage[i]);

            return view1;

        }
    }
}