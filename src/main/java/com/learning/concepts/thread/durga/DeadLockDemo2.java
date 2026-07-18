package com.learning.concepts.thread.durga;

public class DeadLockDemo2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("DeadLockDemo2 started..");
        Thread.currentThread().join();
        System.out.println("DeadLockDemo2 end..");
    }
}

