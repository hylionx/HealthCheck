package com.example.healthcheck.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthcheck.CheckUpActivity;
import com.example.healthcheck.R;

public class CheckUpAdapter extends BaseAdapter {

    Context context;
    String[] topicName;
    int[] topicImage;
    int[] bgColors;

    public CheckUpAdapter(Context context) {
        this.context = context;
        topicName = new String[]{
                context.getString(R.string.txtMyProfilTitle),
                context.getString(R.string.txtMyHeartTitle),
                context.getString(R.string.my_cardiac_monitoring_title),
                context.getString(R.string.my_diet_title),
                context.getString(R.string.myPhysicalActivityTitle),
                context.getString(R.string.myTobaccoConsumptionTitle),
                context.getString(R.string.myStressManagementTitle),
                context.getString(R.string.myHygieneOfLifeTitle)
        };

        topicImage = new int[]{
                R.drawable.profill,
                R.drawable.moncoeur,
                R.drawable.suivicardiaque,
                R.drawable.alimentation,
                R.drawable.basket,
                R.drawable.tabac,
                R.drawable.stress,
                R.drawable.dodo
        };

        bgColors = new int[]{
                R.color.iAm,
                R.color.myHeart,
                R.color.myCardiacMonitoring,
                R.color.myDiet,
                R.color.myPhysicalActivity,
                R.color.myTobaccoActivity,
                R.color.myStressManagment,
                R.color.myHygieneOfLife

        };
    }

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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view1 = inflater.inflate(R.layout.activity_list_view_check_up_format, null);
        TextView name = view1.findViewById(R.id.txtTitleTopic);
        ImageView image = view1.findViewById(R.id.images);

        view1.setBackgroundColor(context.getResources().getColor(bgColors[i]));
        name.setText(topicName[i]);
        image.setImageResource(topicImage[i]);

        return view1;

    }

    public void next(String extra, int i, Parcelable person ) {
        Intent intent = new Intent(context, CheckUpActivity.class);
        intent.putExtra("indexForm", (i + 1));
        intent.putExtra(extra, (Parcelable) person);
        intent.putExtra("name", topicName[i]);
        intent.putExtra("image", topicImage[i]);
        intent.putExtra("bgColors", bgColors[i]);
        context.startActivity(intent);
    }
}