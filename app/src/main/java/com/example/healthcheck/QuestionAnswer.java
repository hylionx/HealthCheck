package com.example.healthcheck;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class QuestionAnswer implements Parcelable, Serializable {

    private String questionID;
    private String questionValue;
    private Integer answerIndex;
    private String answerValue;

    private String cardiologistAdvice = "";



    public QuestionAnswer(String questionID, String questionValue, Integer answerIndex, String answerValue) {
        this.questionID = questionID;
        this.questionValue = questionValue;
        this.answerValue = answerValue;
        this.answerIndex = answerIndex;
    }


    protected QuestionAnswer(Parcel in) {
        questionID = in.readString();
        questionValue = in.readString();
        if (in.readByte() == 0) {
            answerIndex = null;
        } else {
            answerIndex = in.readInt();
        }
        answerValue = in.readString();
        cardiologistAdvice = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionID);
        dest.writeString(questionValue);
        if (answerIndex == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(answerIndex);
        }
        dest.writeString(answerValue);
        dest.writeString(cardiologistAdvice);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionAnswer> CREATOR = new Creator<QuestionAnswer>() {
        @Override
        public QuestionAnswer createFromParcel(Parcel in) {
            return new QuestionAnswer(in);
        }

        @Override
        public QuestionAnswer[] newArray(int size) {
            return new QuestionAnswer[size];
        }
    };

    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "questionID='" + questionID + '\'' +
                ", questionValue='" + questionValue + '\'' +
                ", answerValue='" + answerValue + '\'' +
                ", answerIndex=" + answerIndex +
                '}';
    }

    public String getQuestionID() {
        return questionID;
    }

    public Integer getAnswerIndex() {
        return answerIndex;
    }

    public String getQuestionValue() {
        return questionValue;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public String getCardiologistAdvice() {
        return cardiologistAdvice;
    }

    public void setCardiologistAdvice(String cardiologistAdvice) {
        this.cardiologistAdvice = cardiologistAdvice;
    }
}
