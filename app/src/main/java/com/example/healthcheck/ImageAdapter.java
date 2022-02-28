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

    public int [] imagesAvatar = {R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3,
            R.drawable.avatar4,
            R.drawable.avatar5,
            R.drawable.avatar6,
            R.drawable.avatar7,
            R.drawable.avatar8,
            R.drawable.avatar9,
            R.drawable.avatar10};

    public ImageAdapter(Context mContext){
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

       /* ImageView image = imageView.findViewById(R.id.imgAvatar);
        image.setImageResource(imagesAvatar[i]);*/

        return imageView;

    }

}
