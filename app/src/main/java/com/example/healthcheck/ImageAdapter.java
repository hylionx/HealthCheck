package com.example.healthcheck;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private int [] imagesAvatar;

    public ImageAdapter(Context mContext, int [] imagesAvatar){
        this.imagesAvatar = imagesAvatar;
        this.mContext = mContext;
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

}
