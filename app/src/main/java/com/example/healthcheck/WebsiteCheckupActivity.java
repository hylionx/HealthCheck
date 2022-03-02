package com.example.healthcheck;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.example.healthcheck.data.QuestionAnswer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebsiteCheckupActivity extends BaseActivity {

    protected String postParams = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_checkup);

        init();
    }

    private void init() {
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.getSettings().setJavaScriptEnabled(true);
        getPersonByIntent();

        for (QuestionAnswer qa : person.getQuestionAnswers()) {
            addPostParams(qa.getQuestionID(), qa.getAnswerIndex());
        }

        Log.i("Person", "/////////////// params :  " + postParams);

        String URL = "https://www.fedecardio.org/je-me-teste/test-3-minutes/";
        webview.postUrl(URL, postParams.getBytes());
    }

    protected void addPostParams(String question, Integer value) {
        try {
            postParams += (postParams.isEmpty() ? "" : "&") + question + "=" + URLEncoder.encode("" + value , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
