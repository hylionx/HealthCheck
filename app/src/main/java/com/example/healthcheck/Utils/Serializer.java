package com.example.healthcheck.Utils;

import android.content.Context;

import com.example.healthcheck.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Serializer {

    public static void serialize(Person person, Context context) {
        FileOutputStream file;
        ObjectOutputStream oos;
        try {
            file = context.openFileOutput(person.getName(), Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(file);
            oos.writeObject(person);
            oos.flush();
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Person deSerialize(String personName, Context context) {
        FileInputStream file;
        ObjectInputStream ois;
        try {
            file = context.openFileInput(personName);
            ois = new ObjectInputStream(file);
            Object person = ois.readObject();
            ois.close();
            return (Person) person;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
