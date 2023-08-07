package ua.nure.nefedchenko.practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    private static final String ENCODING = "Cp1251";
    public static void main(String[] args) {
        String str = read("part1.txt");
        System.out.println(convert(str));
    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-ЯЁёҐґЇїІіЄє]{4,}");
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        String word;
        char letter;
        while (matcher.find()) {
            word = matcher.group();
            char[] data = word.toCharArray();
            for (int i = 0; i < data.length; i++) {
                letter = data[i];
                if (Character.isUpperCase(letter)) {
                    data[i] = Character.toLowerCase(letter);
                } else {
                    data[i] = Character.toUpperCase(letter);
                }
            }
            word = String.valueOf(data);
            matcher.appendReplacement(sb, word);
        }
        matcher.appendTail(sb);
        return String.valueOf(sb);
    }

    public static String read(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
