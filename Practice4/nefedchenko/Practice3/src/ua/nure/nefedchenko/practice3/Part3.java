package ua.nure.nefedchenko.practice3;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.nefedchenko.practice3.Util.readFile;

public class Part3 {
    public static void main(String[] args) {
        String str = readFile("src/ua/nure/nefedchenko/practice3/part3.txt");
        System.out.println(str);
        System.out.println(convert(str));
    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-ЯЁёҐґЇїІіЄє]{3,}");
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String letter = matcher.group().substring(0, 1);
            Pattern patternLetter = Pattern.compile("[A-ZА-ЯЁҐЇІЄ]");
            Matcher matcherLetter = patternLetter.matcher(letter);
            if (matcherLetter.find()) {
                String str = matcher.group().substring(0, 1).toLowerCase(Locale.ROOT) + matcher.group().substring(1);
                matcher.appendReplacement(sb, str);
            } else {
                String str = matcher.group().substring(0, 1).toUpperCase(Locale.ROOT) + matcher.group().substring(1);
                matcher.appendReplacement(sb, str);
            }
        }

        matcher.appendTail(sb);
        return String.valueOf(sb);
    }
}
