package ua.nure.nefedchenko.practice5;

public class Spam {
    private Thread[] threads;

    public Spam(String[] messages, int[] times) {

    }

    public void start() {}
    public void stop() {}
    private static class Worker extends Thread {}

    public static void main(String[] args) {
        String[] messages = new String[] { "@@@", "bbbbbbb" };
        int[] times = new int[] { 333, 222 };
        Spam spam = new Spam(messages, times);
    }
}
