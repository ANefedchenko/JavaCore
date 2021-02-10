package ua.nure.nefedchenko.practice5;

public class Part1 {

    static class MyFirstThread extends Thread {

        MyFirstThread(String name) {
            super(name);
        }

        public void run() {
            for (int i = 1; i < 4; i++) {
                try {
                    Thread.sleep(3330);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    static class MySecondThread implements Runnable {
        public void run() {
            for (int i = 1; i < 4; i++) {
                try {
                    Thread.sleep(3330);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        MyFirstThread ft = new MyFirstThread("First");
        ft.start();
        try {
            ft.join();
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted", t.getName());
        }
        Thread st = new Thread(new MySecondThread(), "Second");
        st.start();
        try {
            st.join();
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");
    }
}

