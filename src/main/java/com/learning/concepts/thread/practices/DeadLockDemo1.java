package com.learning.concepts.thread.practices;

public class DeadLockDemo1 {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA(){

        // Acquire lock1
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1");

            // Waits for lock2
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock 2");
            }
        }
    }

    public void methodB(){

        // Acquire lock2
        synchronized (lock2){
            System.out.println("Thread 2: Holding lock 2");

            // Waits for lock1
            synchronized (lock1){
                System.out.println("Thread 2: Holding lock 1");
            }
        }
    }

    static void main() {
        DeadLockDemo1 example = new DeadLockDemo1();
        new Thread(example::methodA).start();
        new Thread(example::methodB).start();
    }
}
