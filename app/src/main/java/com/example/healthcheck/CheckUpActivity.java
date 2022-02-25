package com.example.healthcheck;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckUpActivity extends BaseActivity {

    TextView name;
    ImageView image;
    int index;
    int idq = 1;
    int bgcolor;
    int img;

    LinearLayout linearlayout;
    ConstraintLayout constraintlayoutListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up);
        name = findViewById(R.id.listdata);
        image = findViewById(R.id.image);
        linearlayout = findViewById(R.id.linearlayout);
        constraintlayoutListData = findViewById(R.id.constraintlayoutListData);


        getPersonByIntent();
        Intent intent = getIntent();
        index = intent.getIntExtra("indexForm", 0);
        bgcolor = intent.getIntExtra("bgColors", 0);
        img = intent.getIntExtra("image", 0);

        Log.i("person", "+++++++++++++++++++++++++++++++++++++++++" + bgcolor);

        for (QuestionAnswer qa: person.getQuestionAnswers()) {
            if (qa.getQuestionID().contains("f" + index) ) {
                    Log.i("Person", "-------------" + qa);
                    TextView q = new TextView(this);
                    q.setText( qa.getQuestionValue());
                    q.setTextSize(15);
                    q.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    q.setPadding(0, 20, 0, 0);


                    TextView a = new TextView(this);
                    a.setText("-> " + qa.getAnswerValue());
                    a.setTextSize(10);
                    a.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    a.setPadding(0, 0, 0, 20);

                    linearlayout.addView(q);
                    linearlayout.addView(a);

            }
        }
        person.getQuestionAnswers();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(img);
        constraintlayoutListData.setBackgroundColor(getResources().getColor(bgcolor));
       // constraintlayoutListData.setBackgroundColor(getResources().getColor());
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {



        return true;
    }
}