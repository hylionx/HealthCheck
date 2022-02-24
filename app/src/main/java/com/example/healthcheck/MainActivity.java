package com.example.healthcheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String APP_TAG = "MainActivityApp";

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
                Intent intent = new Intent(MainActivity.this, NameActivity.class );
                startActivity(intent);
            }
        }, 3000);
    }
}