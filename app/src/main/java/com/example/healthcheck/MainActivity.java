package com.example.healthcheck;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.TextView;

import com.example.healthcheck.formActivities.NameActivity;

public class MainActivity extends BaseActivity {
    // in Logcat : (.)*MyApp
    public static final String APP_TAG = "MainActivityMyApp";

    private ImageView imageView;
    private TextView txtMadeBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.logo);
        txtMadeBy = findViewById(R.id.txtMadeBy);
        Animation topAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_top);
        Animation bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_bottom);
        imageView.setAnimation(topAnimation);
        txtMadeBy.setAnimation(bottomAnimation);
        reloadSavedPersons();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Class<?> nextClass = (savedPersons.size() > 0) ? ListViewSavedPersonsActivity.class : NameActivity.class;
                Intent intent = new Intent(MainActivity.this, nextClass );
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}