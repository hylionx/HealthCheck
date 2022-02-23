package com.example.healthcheck;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Handler;

public class MainActivity extends BaseActivity {
    public static final String APP_TAG = "APPActivity";

    ImageView imageView;
    Animation topaniAnimation, bottoAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.logo);
        topaniAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_top);
        bottoAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_bottom);
        imageView.setAnimation(topaniAnimation);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoNextActivity(NameActivity.class);
            }
        }, 3000);


    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}