package com.example.healthcheck;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends BaseActivity {
    public static final String APP_TAG = "MainActivityApp";
    // Listes des permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    ImageView imageView;
    TextView txtMadeBy;
    Animation topaniAnimation, bottoAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.logo);
        txtMadeBy = findViewById(R.id.txtMadeBy);
        topaniAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_top);
        bottoAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_bottom);
        imageView.setAnimation(topaniAnimation);
        txtMadeBy.setAnimation(bottoAnimation);
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