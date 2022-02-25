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

public class ListViewCheckUpActivity extends BaseActivity {

    ListView listView;
    String[] topicName;
    int [] topicImage;
    int [] bgColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_check_up);
        getPersonByIntent();

        topicName = new String[]{
                getString(R.string.txtMyHeartTitle),
                getString(R.string.my_cardiac_monitoring_title),
                getString(R.string.my_diet_title),
                getString(R.string.myPhysicalActivityTitle),
                getString(R.string.myTobaccoConsumptionTitle),
                getString(R.string.myStressManagementTitle),
                getString(R.string.myHygieneOfLifeTitle)
        };

        topicImage = new int[]{
                R.drawable.moncoeur,
                R.drawable.suivicardiaque,
                R.drawable.alimentation,
                R.drawable.basket,
                R.drawable.tabac,
                R.drawable.stress,
                R.drawable.dodo
        };

        bgColors = new int[]{
                R.color.myHeart,
                R.color.myCardiacMonitoring,
                R.color.myDiet,
                R.color.myPhysicalActivity,
                R.color.myTobaccoActivity,
                R.color.myStressManagment,
                R.color.myHygieneOfLife

        };

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), CheckUpActivity.class);
                intent.putExtra("indexForm", (i+1));
                intent.putExtra(EXTRA_PERSON, person);
                intent.putExtra("name", topicName[i]);
                intent.putExtra("image", topicImage[i]);
                intent.putExtra("bgColors", bgColors[i]);
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
           View view1 = getLayoutInflater().inflate(R.layout.activity_list_view_check_up_format, null);
            TextView name = view1.findViewById(R.id.txtTitleTopic);
            ImageView image = view1.findViewById(R.id.images);

            view1.setBackgroundColor(getResources().getColor(bgColors[i]));
            name.setText(topicName[i]);
            image.setImageResource(topicImage[i]);


            return view1;

        }
    }
}