package com.example.healthcheck;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.healthcheck.data.QuestionAnswer;

public class CheckUpActivity extends BaseActivity {
    public static final String APP_TAG = "CheckUpActivityMyApp";


    private TextView name;
    private ImageView image;
    private int index;
    private int bgcolor;
    private int img;

    private LinearLayout linearlayout;
    private ConstraintLayout constraintlayoutListData;

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
                Log.i(APP_TAG, "QuestionAnswer : " + qa);
                TextView question = new TextView(this);
                question.setText( qa.getQuestionValue());
                question.setTextSize(20);
                question.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                question.setPadding(0, 20, 0, 0);
                linearlayout.addView(question);

                TextView answer = new TextView(this);
                answer.setText(qa.getAnswerValue());
                answer.setTextSize(15);
                answer.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                answer.setPadding(0, 0, 0, 20);
                linearlayout.addView(answer);

                String advice = qa.getCardiologistAdvice();
                if (!(advice.isEmpty())) {
                    TextView cardiologistAdvice = new TextView(this);
                    cardiologistAdvice.setText(qa.getCardiologistAdvice());
                    cardiologistAdvice.setTextSize(10);
                    cardiologistAdvice.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    cardiologistAdvice.setPadding(0, 0, 0, 20);
                    linearlayout.addView(cardiologistAdvice);
                }
            }
        }
        person.getQuestionAnswers();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(img);
        constraintlayoutListData.setBackgroundColor(getResources().getColor(bgcolor));
    }
}