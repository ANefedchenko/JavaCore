package ua.nure.nefedchenko.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        final int radix = 16;
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder result = new StringBuilder();
        for (byte b : hash) {
            result.append(Integer.toString((b & 0xff) + 0x100, radix).toUpperCase(Locale.ROOT).substring(1));
        }
        return result.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
    }
}

