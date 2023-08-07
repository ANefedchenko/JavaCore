package ua.nure.nefedchenko.practice1;

public class Part7 {
    private static final String ARROW = " ==> ";
    public static final int ALPHABET_LENGTH = 26;
    public static final int A_IN_UNICODE = 64;

    private static String[] myStr = new String[]{"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"};

    public static int str2int(String number) {
        int digit = 0;
        int step = number.length() - 1;
        for (int i = number.length(); i > 0; i--) {
            digit += (number.charAt(number.length() - i) - A_IN_UNICODE)
                    * Math.pow(ALPHABET_LENGTH, step--);
        }
        return digit;
    }

    public static String int2str(int number) {
        StringBuilder strbld = new StringBuilder();

        int remain;
        int div = number;
        while (div != 0) {
            remain = div % ALPHABET_LENGTH;
            if (remain == 0) {
                strbld.append('Z');
                div = (div - 1) / ALPHABET_LENGTH;
            } else {
                strbld.append((char) (remain + A_IN_UNICODE));
                div = (div - remain) / ALPHABET_LENGTH;
            }
        }
        return strbld.reverse().toString();
    }

    public static String rightColumn(String number) {
        return int2str(str2int(number) + 1);
    }
    public static void main(String[] args) {
        for (String s : myStr) {
            System.out.println(s + ARROW + str2int(s) + ARROW + int2str(str2int(s)));
        }

    }
}