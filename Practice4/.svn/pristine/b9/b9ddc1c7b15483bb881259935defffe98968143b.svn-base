package ua.nure.nefedchenko.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Part5 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String key;
            String[] data;
            while ((key = br.readLine()) != null) {
                if ("stop".equals(key)) {
                    break;
                }
                data = key.split("\\s");
                if (data.length == 2) {
                    getValue(data[0], data[1]);
                } else {
                    System.out.println("No such values");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void getValue(String key, String prop) {
        String myBundle;
        if ("ru".equals(prop)) {
            myBundle = "resources_ru";
        } else {
            myBundle = "resources_en";
        }
        ResourceBundle bundle = ResourceBundle.getBundle(myBundle, new Locale(prop));
        try {
            System.out.println(bundle.getString(key));
        } catch (MissingResourceException ex) {
            System.out.println("No such values");
        }
    }
}
