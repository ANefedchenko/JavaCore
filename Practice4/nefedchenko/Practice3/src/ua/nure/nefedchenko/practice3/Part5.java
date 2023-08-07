package ua.nure.nefedchenko.practice3;

import java.util.Locale;

public class Part5 {

    private static int decimalStat;
    public static final int HUNDRED = 100;
    public static final int FIFTY = 50;
    public static final int FORTY = 40;
    public static final int TEN = 10;

    public static void main(String[] args) {
        final int numOfNumbers = 100;
        for (int i = 1; i <= numOfNumbers; i++) {
            System.out.println(i + " --> " + decimal2Roman(i) + " --> " + roman2Decimal(decimal2Roman(i)));
        }
    }

    public static String decimal2Roman(int x) {

        StringBuilder sb = new StringBuilder("");
        int c1 = x / HUNDRED;
        sb.append(hundred(c1));
        int l1 = x / FIFTY;
        int l2 = x % FIFTY;
        if (l1 == 1) {
            sb.append(from50to99(l2));
        }
        int x1 = x / TEN;
        sb.append(to50(x1));
        int x2 = x % TEN;
        sb.append(basic(x2));
        return sb.toString();
    }

    private static String hundred(int in) {
        if (in == 1) {
            return "C";
        } else {
            return "";
        }
    }

    private static String to50(int in) {
        if (in == 4) {
            return "XL";
        } else if ((in != 0) && (in < 4)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < in) {
                sb.append("X");
                i++;
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    private static String from50to99(int in) {
        if (in >= FORTY) {
            return "XC";
        } else if (in != 0) {
            StringBuilder sb = new StringBuilder("L");
            int i = 0;
            while (i < (in / 10)) {
                sb.append("X");
                i++;
            }
            return sb.toString();
        } else {
            return "L";
        }

    }

    private static String basic(int in) {
        String[] a = {
                "",
                "I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX"
        };
        return a[in];
    }

    public static int roman2Decimal(String s) {
        int lastNum = 0;
        String romanNum = s.toUpperCase(Locale.ROOT);
        for (int i = romanNum.length() - 1; i >= 0; i--) {
            char convertToDecimal = romanNum.charAt(i);
            switch (convertToDecimal) {
                case 'C':
                    processDecimal(HUNDRED, lastNum);
                    lastNum = HUNDRED;
                    break;

                case 'L':
                    processDecimal(FIFTY, lastNum);
                    lastNum = FIFTY;
                    break;

                case 'X':
                    processDecimal(TEN, lastNum);
                    lastNum = TEN   ;
                    break;

                case 'V':
                    processDecimal(5, lastNum);
                    lastNum = 5;
                    break;

                case 'I':
                    processDecimal(1, lastNum);
                    lastNum = 1;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + convertToDecimal);
            }
        }
        int decimal = decimalStat;
        decimalStat = 0;
        return decimal;
    }

    public static void processDecimal(int decimal, int lastNum) {
        if (lastNum > decimal) {
            decimalStat -= decimal;
        } else {
            decimalStat += decimal;
        }
    }
}