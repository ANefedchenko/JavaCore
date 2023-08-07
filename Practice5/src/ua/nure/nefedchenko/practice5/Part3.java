package ua.nure.nefedchenko.practice5;

public class Part3 {
    private int counter;
    private int counter2;

    private Thread[] threads;

    public Part3(int n, int k, int t) { }

    public void reset() { }

    public void test() { }

    public void testSync() { }

    public static void main(String[] args) {
        Part3 p = new Part3(3, 5, 100);
        p.test();
        p.reset();
        p.testSync();
    }
}
