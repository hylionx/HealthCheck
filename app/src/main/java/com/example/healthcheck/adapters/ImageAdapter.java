package com.example.healthcheck.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.healthcheck.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private int [] imagesAvatar;

    public ImageAdapter(Context mContext){
        this.mContext = mContext;
        this.imagesAvatar = new int[]{
                R.drawable.avatar1,
                R.drawable.avatar2,
                R.drawable.avatar3,
                R.drawable.avatar4,
                R.drawable.avatar5,
                R.drawable.avatar6,
                R.drawable.avatar7,
                R.drawable.avatar8,
                R.drawable.avatar9,
                R.drawable.avatar10,
                R.drawable.avatar11,
                R.drawable.avatar12,
                R.drawable.avatar13,
                R.drawable.avatar14,
                R.drawable.avatar15,
                R.drawable.avatar16,
                R.drawable.avatar17,
                R.drawable.avatar18,
                R.drawable.avatar19,
                R.drawable.avatar20,
                R.drawable.avatar21,
                R.drawable.avatar22,
                R.drawable.avatar23,
                R.drawable.avatar24,
                R.drawable.avatar25,
                R.drawable.avatar26
        };
    }

    @Override
    public int getCount() {
        return imagesAvatar.length;
    }

    @Override
    public Object getItem(int i) {
        return imagesAvatar[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imagesAvatar[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));

        return imageView;

    }

    public int getImg(int i) {
        return imagesAvatar[i];
    }
}
