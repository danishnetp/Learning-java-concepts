package com.learning.concepts.thread.durga;

public class DeadLockDemo1 {
    public static void main(String[] args) throws InterruptedException {
        DeadLockDemo1Thread.mt = Thread.currentThread();
        DeadLockDemo1Thread t = new DeadLockDemo1Thread();
        t.start();
        t.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread , i = " + (i+1));
            Thread.sleep(1000);
        }
    }
}

class DeadLockDemo1Thread extends Thread {
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
