package com.learning.concepts.thread.practices;

public class StrictAlternateDemo1 {
    // shared variable
    private static final Object lock = new Object();
    private static boolean isThreadRunning = true;

    static void main() {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                synchronized (lock) {
                    while (!isThreadRunning) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                    // Switch turn and notify the other thread
                    isThreadRunning = false;
                    lock.notifyAll();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (isThreadRunning) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                    // Switch turn and notify the other thread
                    isThreadRunning = true;
                    lock.notifyAll();
                }
            }
        });

        thread1.setName("Thread1");
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
    }
}
