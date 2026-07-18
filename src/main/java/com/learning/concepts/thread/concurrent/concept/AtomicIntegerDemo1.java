package com.learning.concepts.thread.concurrent.concept;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo1 {
    public static void main(String[] args) {
        AtomicIntegerSharedResource sharedResource = new AtomicIntegerSharedResource();
        Thread thread1 = new Thread(() ->
        {
            for (int i = 0; i < 200; i++) {
                sharedResource.increment();
               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
            }
        });

        Thread thread2 = new Thread(() ->
        {
            for (int i = 0; i < 200; i++) {
                sharedResource.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception ignored) {
        }

        System.out.println(sharedResource.get());
    }

}

class AtomicIntegerSharedResource {
    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int get() {
        return counter.get();
    }
}
