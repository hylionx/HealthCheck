package com.example.healthcheck;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.healthcheck.adapters.CheckUpAdapter;
import com.example.healthcheck.data.QuestionAnswer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class ListViewCheckUpActivity extends BaseActivity {

    public static final String APP_TAG = "ListViewCheckUpActivityMyApp";

    private ListView listView;
    private String[] topicName;
    private int[] topicImage;
    private int[] bgColors;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private RatingBar ratingBar;
    private Button btnPopup;
    private String URL = "https://www.fedecardio.org/je-me-teste/test-3-minutes/";
    private Document document = null;
    private SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_check_up);
        getPersonByIntent();
        btnPopup = findViewById(R.id.btnPopup);

        // rate the app once
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPref.getFloat("ratingValue", -1.0f) == -1.0f){
            createDialog();
        }


        listView = findViewById(R.id.listview);

        CheckUpAdapter checkUpAdapter = new CheckUpAdapter(this);
        listView.setAdapter(checkUpAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                checkUpAdapter.next(EXTRA_PERSON, i, (Parcelable) person);
            }
        });

    }

    public void createDialog() {
        //pop up dialogue

        dialogBuilder = new AlertDialog.Builder(this);
        final View popUpRater = getLayoutInflater().inflate(R.layout.popup, null);
        btnPopup = popUpRater.findViewById(R.id.btnPopup);

        ratingBar = popUpRater.findViewById(R.id.ratingBar);
        dialogBuilder.setView(popUpRater);
        dialog = dialogBuilder.create();
        dialog.show();

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(APP_TAG, "valeur rating = "+ ratingBar.getRating());
                float ratingValue = ratingBar.getRating();
                sharedPref.edit().putFloat("ratingValue", ratingValue).commit();
                dialog.dismiss();
            }
        });

        setCardiologistAdvices();
    }

    protected void setCardiologistAdvices() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Map<String, String> data = new HashMap<>();
                    for (QuestionAnswer qa : person.getQuestionAnswers()) {
                        data.put(qa.getQuestionID(), qa.getAnswerIndex().toString());
                    }
                    document = Jsoup.connect(URL).data(data).post();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            thread.join();
            Elements advices = document.select("p.question-conseil");
            int qaIndex = 2; // Advices start from second activity
            for (Element advice : advices) {
                QuestionAnswer qa = person.getQuestionAnswers().get(qaIndex++);
                qa.setCardiologistAdvice(advice.text());
                Log.i(APP_TAG, "advices: " + qa.getCardiologistAdvice());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}