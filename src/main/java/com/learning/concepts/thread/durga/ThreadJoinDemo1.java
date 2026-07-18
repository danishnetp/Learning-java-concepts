package com.learning.concepts.thread.durga;

public class ThreadJoinDemo1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread.mt = Thread.currentThread();
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread , i = " + (i+1));
            Thread.sleep(1000);
        }
    }
}

class MyThread extends Thread {
    static Thread mt;

    public void run() {
        try {
            mt.join();
        } catch (InterruptedException ignored) {
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread, i = " + (i+1));
        }
    }
}
