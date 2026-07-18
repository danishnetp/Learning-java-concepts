package com.learning.concepts.thread.concurrent.concept;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo1 {
    public static void main(String[] args) {
        LockDemo1Resource resource1 = new LockDemo1Resource();
        Thread thread1 = new Thread(resource1::f1);
        Thread thread2 = new Thread(resource1::f1);
        Thread thread3 = new Thread(resource1::f1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class LockDemo1Resource {
    Lock lock = new ReentrantLock();

    void f1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " entered");
            try {
                Thread.sleep(2000);

            } catch (Exception ignored) {
            }
            System.out.println(Thread.currentThread().getName() + " exited");
        } finally {
            lock.unlock();
        }
    }
}
