package com.example.healthcheck.Utils;

import android.content.Context;

import com.example.healthcheck.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class that Serialize and deserialize a person object
 * and store it into a file with the same name as the person.
 */
public abstract class Serializer {

    /**
     * Serialization of a person object.
     * @param person The object to serialize.
     * @param context
     */
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


    /**
     * Deserialization of a person object from file.
     * @param personName The name of the file.
     * @param context
     * @return A Person object or null if file not found.
     */
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
