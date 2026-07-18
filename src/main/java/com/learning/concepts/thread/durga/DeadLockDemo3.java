package com.learning.concepts.thread.durga;

public class DeadLockDemo3 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1: Holding Lock A...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread 1: Waiting for lock B...");
                synchronized (lockB) {
                    System.out.println("Thread 1: Acquired lock B!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2: Holding Lock B...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread 2: Waiting for lock A...");
                synchronized (lockA) {
                    System.out.println("Thread 2 : Acquired lock B!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
