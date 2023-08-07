package ua.nure.nefedchenko.practice3;

import java.util.regex.Pattern;

import static ua.nure.nefedchenko.practice3.Util.readFile;

public class Part2 {
    public static void main(String[] args) {
        String str = readFile("src/ua/nure/nefedchenko/practice3/part2.txt");
        System.out.println(str);
        System.out.println(convert(str));
    }

    public static String convert(String input) {
        Pattern pattern = Pattern.compile("([ .,;'\\-\\n\\r]|[0-9])+");
        String[] data = pattern.split(input);
        int minL = minValues(data);
        int maxL = maxValues(data);
        String[] arrUnique = removeDuplicates(data);
        StringBuilder sb = new StringBuilder();
        sb.append(addMinString(arrUnique, minL)).append(addMaxString(arrUnique, maxL));
        return String.valueOf(sb);
    }

    public static int maxValues(String[] arr) {
        int max = 0;
        for (String datum : arr) {
            if (datum.length() > max) {
                max = datum.length();
            }
        }
        return max;
    }

    public static int minValues(String[] arr) {
        int min = 0;
        for (String datum : arr) {
            if (min == 0 || datum.length() < min) {
                min = datum.length();
            }
        }
        return min;
    }

    public static StringBuilder addMinString(String[] arr, int min) {
        StringBuilder sb = new StringBuilder("Min:");
        for (String datum : arr) {
            if (datum.length() == min) {
                sb.append(" ").append(datum).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1).append('\n');
        return sb;
    }

    public static StringBuilder addMaxString(String[] arr, int max) {
        StringBuilder sb = new StringBuilder("Max:");
        for (String datum : arr) {
            if (datum.length() == max) {
                sb.append(" ").append(datum).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
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
}
