package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListDataActivity extends BaseActivity {

    TextView name;
    ImageView image;
    int index;
    LinearLayout linearlayout;
    ConstraintLayout constraintlayoutListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        name = findViewById(R.id.listdata);
        image = findViewById(R.id.image);
        linearlayout = findViewById(R.id.linearlayout);
        constraintlayoutListData = findViewById(R.id.constraintlayoutListData);


        getPersonByIntent();
        Intent intent = getIntent();
        index = intent.getIntExtra("indexForm", 0);

        Log.i("person", "*************************************" + index);
        //Log.i("person", "*************************************" + person);

        for (QuestionAnswer qa: person.getQuestionAnswers()) {
            if (qa.questionID.contains("f" + index)) {
                Log.i("Person", "-------------" + qa);
                TextView q = new TextView(this);
                q.setText(qa.questionValue);
                q.setTextSize(15);
                q.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                q.setPadding(0,20,0,0);



                TextView a = new TextView(this);
                a.setText(qa.answerValue);
                a.setTextSize(10);
                a.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                a.setPadding(0,0,0,20);

                linearlayout.addView(q);
                linearlayout.addView(a);


            }
        }
        person.getQuestionAnswers();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));

    }

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}