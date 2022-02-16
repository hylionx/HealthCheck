package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class IAm extends AppCompatActivity {
    Button btn_suiv;
    Button btn_prec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_am);


        btn_suiv = findViewById(R.id.btn_suiv);
        btn_suiv.setOnClickListener(view -> onClickButtonSuivant());
        btn_prec = findViewById(R.id.btn_prec);
        btn_prec.setOnClickListener(view -> onClickButtonPrecedent());
    }




    public void onClickButtonSuivant(){
        Intent intent = new Intent(this,MyHeart.class );
        startActivity(intent);

    }


    public void onClickButtonPrecedent(){
        finish();
    }
}