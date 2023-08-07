package ua.nure.nefedchenko.practice3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.nefedchenko.practice3.Util.readFile;

public class Part1 {

    public static void main(String[] args) {
        String str = readFile("src/ua/nure/nefedchenko/practice3/part1.txt");
        System.out.println(str);
        System.out.println("==================Convert 1==================");
        System.out.println(convert1(str));
        System.out.println("==================Convert 2==================");
        System.out.println(convert2(str));
        System.out.println("==================Convert 3==================");
        System.out.println(convert3(str));
        System.out.println("==================Convert 4==================");
        System.out.println(convert4(str));
        Pattern pattern = Pattern.compile("Login;Name;Email;Password\\r?\\n" +
                "ivanov;Ivan Ivanov;ivanov@mail.com;\\d{4}\\r?\\n" +
                "петров;Петр Петров;petrov@google.com;\\d{4}\\r?\\n" +
                "\\s*$");
        String output = convert4(str);
        Matcher matcher = pattern.matcher(output);
        System.out.println(matcher.matches());
    }

    public static String convert1(String input) {
        Pattern pattern = Pattern.compile(";.+;|\\n");
        String[] data = pattern.split(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < data.length - 1; i += 2) {
            sb.append(data[i]).append(": ").append(data[i + 1]).append('\n');
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return String.valueOf(sb);
    }

    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\s*^.+?;|\\s|;|\\n", Pattern.MULTILINE);
        String[] data = pattern.split(input);
        for (int i = 3; i < data.length - 2; i += 3) {
            sb.append(data[i + 1])
                    .append(" ")
                    .append(data[i])
                    .append(" (email: ")
                    .append(data[i + 2])
                    .append(")")
                    .append('\n');
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return String.valueOf(sb);
    }

    public static String convert3(String input) {
        Pattern pattern1 = Pattern.compile("(;.+|\\n|\\r)+");
        Pattern pattern2 = Pattern.compile("(.+@|\\n|\\r)+");
        String[] data1 = pattern1.split(input);
        String[] data2 = pattern2.split(input);

        String[] arrUnique = removeDuplicates(data2);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i != arrUnique.length; i++) {
            sb.append(arrUnique[i]).append(" ==>");
            for (int j = 1; j != data2.length; j++) {
                if (data2[j].equals(arrUnique[i])) {
                    sb.append(" ").append(data1[j]).append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1).append('\n');
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return String.valueOf(sb);
    }

    public static String[] removeDuplicates(String[] values) {
        String[] array = new String[values.length];
        System.arraycopy(values, 0, array, 0, values.length);
        int length = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i - 1; j != 0; j--) {
                if (array[i].equals(array[j])) {
                    int numMoved = array.length - i - 1;
                    if (numMoved > 0) {
                        System.arraycopy(array, i + 1, array, i, numMoved);
                        length--;
                    }
                }
            }
        }
        String[] arr = new String[length];
        System.arraycopy(array, 0, arr, 0, length);
        return arr;
    }

    public static String convert4(String input) {
        final int minValue = 1000;
        final int maxValue = 9999;
        Pattern pattern = Pattern.compile(System.lineSeparator());
        String[] data = pattern.split(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                sb.append(data[i]).append(";").append("Password").append(System.lineSeparator());
            } else {
                int randomNum = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
                sb.append(data[i]).append(";").append(randomNum).append(System.lineSeparator());
            }
        }
        return String.valueOf(sb);
    }
}
