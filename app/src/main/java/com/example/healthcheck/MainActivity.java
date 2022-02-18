package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // in Logcat : (MainApp)|(IAMApp)|(MyHeartApp)
    public static final String APP_TAG = "MainApp";

    private Person person;
    private EditText edit_name;
    private Button btn_start;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        person = new Person();
        btn_start = findViewById(R.id.btn_start);
        edit_name = findViewById(R.id.edit_name);
        sharedPreferences = getSharedPreferences("Shared_PREF", MODE_PRIVATE);

        btn_start.setOnClickListener(view -> onClickButtonStart());

    }

    public void onClickButtonStart(){

        String name = edit_name.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name);
        editor.apply();

        person.setName(name);

        Toast.makeText(MainActivity.this, "Information Saved", Toast.LENGTH_SHORT).show();
        Log.v(MainActivity.APP_TAG,"Entete section: " + edit_name.getText());
        Intent intent = new Intent (MainActivity.this, IAm.class);
        intent.putExtra("Person", person);
        Log.i(APP_TAG, "Parcelable Person put");
        startActivity(intent);
    }

}