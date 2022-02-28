package com.example.healthcheck;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ListViewCheckUpActivity extends BaseActivity {

    private ListView listView;
    private String[] topicName;
    private int [] topicImage;
    private int [] bgColors;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private RatingBar ratingBar;
    private Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_check_up);
        getPersonByIntent();
        btnPopup = findViewById(R.id.btnPopup);

        createDialog();

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
                intent.putExtra(EXTRA_PERSON, (Parcelable) person);
                intent.putExtra("name", topicName[i]);
                intent.putExtra("image", topicImage[i]);
                intent.putExtra("bgColors", bgColors[i]);
                startActivity(intent);
            }
        });



    }


    public void createDialog(){
        //pop up dialogue

        dialogBuilder = new AlertDialog.Builder(this);
        final View popUpRater = getLayoutInflater().inflate(R.layout.popup,null);
        btnPopup = popUpRater.findViewById(R.id.btnPopup);

        ratingBar = popUpRater.findViewById(R.id.ratingBar);
        dialogBuilder.setView(popUpRater);
        dialog = dialogBuilder.create();
        dialog.show();

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
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