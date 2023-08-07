package ua.nure.nefedchenko.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) {
        String input = read("part3.txt");
        String charReg = "(?<!\\S)[а-яА-Яa-zA-Z](?!\\S)";
        String stringReg = "[a-zA-Zа-яА-Я]{2,}";
        String intReg = "(?<![\\.\\d])\\d+(?![\\.\\d])";
        String doubleReg = "[0-9]*[.,][0-9]*";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text;
            while (!("stop".equals(text = br.readLine()))) {
                switch (text) {
                    case ("char"):
                        printMatch(charReg, input);
                        break;
                    case ("String"):
                        printMatch(stringReg, input);
                        break;
                    case ("int"):
                        printMatch(intReg, input);
                        break;
                    case ("double"):
                        printMatch(doubleReg, input);
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printMatch(String reg, String input) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        if (sb.length() == 0) {
            System.out.print("No such values");
        } else {
            System.out.print(sb);
        }
        System.out.print(System.lineSeparator());
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
