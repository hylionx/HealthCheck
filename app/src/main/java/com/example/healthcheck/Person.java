package com.example.healthcheck;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.healthcheck.Utils.Serializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person implements Parcelable, Serializable {

    // MAIN
    private String name;
    private List<QuestionAnswer> questionAnswers = new ArrayList<>();

    public Person() {
    }


    protected Person(Parcel in) {
        name = in.readString();
        in.readTypedList(questionAnswers, QuestionAnswer.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(questionAnswers);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void addQA(String questionID, String questionValue, Integer AnswerIndex, String AnswerValue) {
        QuestionAnswer qa = new QuestionAnswer(questionID, questionValue, AnswerIndex, AnswerValue);
        this.questionAnswers.add(qa);
        Log.i("Person", "QA added : " + qa);
    }

    @Override
    public String toString() {
        String str = "Person{ name= " + name + ", questionAnswers=[\n";
        for (QuestionAnswer qa: questionAnswers) {
            str += qa + "\n";
        }
        str += "]}";
        return str;
    }
}
