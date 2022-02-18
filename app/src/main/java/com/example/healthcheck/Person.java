package com.example.healthcheck;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    public Person() {

    }

    public enum SexeEnum {
        MALE,
        FEMALE,
        OTHER
    }

    private String name;
    private int age;
    private SexeEnum sexe;



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public SexeEnum getSexe() {
        return sexe;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public void setSexe(SexeEnum sexe) {
        this.sexe = sexe;
    }



    protected Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
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

}
