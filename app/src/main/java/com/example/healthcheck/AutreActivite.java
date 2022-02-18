package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AutreActivite extends AppCompatActivity {

    TextView txt_name;
    SharedPreferences preferences;
    Button btn_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre_activite);

        this.txt_name = (TextView) this.findViewById(R.id.txt_name);
        this.btn_quit = (Button) this.findViewById(R.id.btn_quit);

        preferences = getSharedPreferences("Shared_PREF", MODE_PRIVATE);

        String name = preferences.getString("NAME", "");
        txt_name.setText(name);

        btn_quit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent (AutreActivite.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}