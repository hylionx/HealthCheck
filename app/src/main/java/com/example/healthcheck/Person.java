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


    private String name;
    private int avatar;
    /**
     * An array of QuestionAnswer that will be updated in each activity.
     */
    private List<QuestionAnswer> questionAnswers = new ArrayList<>();


    public Person() {
    }




    protected Person(Parcel in) {
        name = in.readString();
        avatar = in.readInt();
        in.readTypedList(questionAnswers, QuestionAnswer.CREATOR);

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(avatar);
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
        questionAnswers.add(qa);
        Log.i("Person", "QA added : " + qa);
    }

    public void removeQAs(String regex) {
        Log.d("Person", "\n\n\n\npopLastQAs: " + regex);
        int last = questionAnswers.size();
        while (last-- > 0) {
            if (questionAnswers.get(last).getQuestionID().contains(regex)) {
                Log.d("Person", "removing : " + questionAnswers.get(last).getQuestionID());
                questionAnswers.remove(last);

            } else {
                return;
            }
        }
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

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
