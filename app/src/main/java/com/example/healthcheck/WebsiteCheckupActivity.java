package com.example.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

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
        getPersonByIntent();

        for (QuestionAnswer qa : person.getQuestionAnswers()) {
            addPostParams(qa.getQuestionID(), qa.getAnswerIndex());
        }

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

    @Override
    protected boolean validateWidgetsAndAffectPersonDatas() {
        return true;
    }
}